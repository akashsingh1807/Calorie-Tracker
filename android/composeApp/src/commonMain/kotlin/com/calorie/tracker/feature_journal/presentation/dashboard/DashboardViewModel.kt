package com.calorie.tracker.feature_journal.presentation.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.calorie.tracker.feature_journal.domain.MealRepository
import com.calorie.tracker.model.Meal
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.toInstant

import kotlinx.datetime.LocalDate
import kotlinx.coroutines.flow.collectLatest

class DashboardViewModel(
    private val mealRepository: MealRepository
) : ViewModel() {

    private val _meals = MutableStateFlow<List<Meal>>(emptyList())
    val meals: StateFlow<List<Meal>> = _meals.asStateFlow()

    private val _selectedDate = MutableStateFlow<LocalDate>(
        Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date
    )
    val selectedDate: StateFlow<LocalDate> = _selectedDate.asStateFlow()

    init {
        viewModelScope.launch {
            _selectedDate.collectLatest { date ->
                val timeZone = TimeZone.currentSystemDefault()
                val startOfDay = LocalDateTime(
                    year = date.year,
                    monthNumber = date.monthNumber,
                    dayOfMonth = date.dayOfMonth,
                    hour = 0,
                    minute = 0,
                    second = 0,
                    nanosecond = 0
                ).toInstant(timeZone).toEpochMilliseconds()

                val endOfDay = startOfDay + 24 * 60 * 60 * 1000L

                mealRepository.getMealsForDate(startOfDay, endOfDay).collectLatest { dailyMeals ->
                    _meals.value = dailyMeals
                }
            }
        }
    }

    fun selectDate(date: LocalDate) {
        _selectedDate.value = date
    }
}
