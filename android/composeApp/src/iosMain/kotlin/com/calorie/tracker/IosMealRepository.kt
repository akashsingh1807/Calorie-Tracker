@file:OptIn(kotlinx.cinterop.ExperimentalForeignApi::class)
package com.calorie.tracker

import com.calorie.tracker.feature_journal.domain.MealRepository
import com.calorie.tracker.model.Meal
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.*

class IosMealRepository : MealRepository {
    private val mealsFlow = MutableStateFlow<List<Meal>>(emptyList())
    private val json = Json { ignoreUnknownKeys = true }
    private val filePath: String?

    init {
        val fileManager = NSFileManager.defaultManager
        val urls = fileManager.URLsForDirectory(NSDocumentDirectory, NSUserDomainMask)
        val documentDirectory = urls.firstOrNull() as? NSURL
        filePath = documentDirectory?.URLByAppendingPathComponent("meals.json")?.path
        loadMeals()
    }

    private fun loadMeals() {
        val path = filePath ?: return
        val fileManager = NSFileManager.defaultManager
        if (fileManager.fileExistsAtPath(path)) {
            val content = NSString.stringWithContentsOfFile(path, encoding = NSUTF8StringEncoding, error = null)
            if (content != null) {
                try {
                    val list = json.decodeFromString<List<Meal>>(content.toString())
                    mealsFlow.value = list
                } catch (e: Exception) {
                    println("Error loading meals: ${e.message}")
                }
            }
        }
    }

    private fun saveMeals() {
        val path = filePath ?: return
        val list = mealsFlow.value
        val jsonString = json.encodeToString(list)
        (jsonString as NSString).writeToFile(path, atomically = true, encoding = NSUTF8StringEncoding, error = null)
    }

    override fun getMealsForDate(startOfDay: Long, endOfDay: Long): Flow<List<Meal>> {
        return mealsFlow.map { list ->
            list.filter { it.timestamp in startOfDay until endOfDay }
        }
    }

    override suspend fun insertMeal(meal: Meal): Long {
        val newId = (mealsFlow.value.maxOfOrNull { it.id } ?: 0L) + 1
        val newMeal = meal.copy(id = newId)
        mealsFlow.value = mealsFlow.value + newMeal
        saveMeals()
        return newId
    }

    override suspend fun getUnsyncedMeals(): List<Meal> {
        return mealsFlow.value.filter { !it.isSynced }
    }

    override suspend fun updateMeal(meal: Meal) {
        mealsFlow.value = mealsFlow.value.map {
            if (it.id == meal.id) meal else it
        }
        saveMeals()
    }
}

