package com.calorie.tracker.model

/**
 * Common/shared model for a saved bookmark meal.
 * Platform-independent — does not reference Room annotations.
 */
data class BookmarkedMeal(
    val id: Long = 0,
    val name: String,
    val totalCalories: Double,
    val totalProtein: Double,
    val totalCarbs: Double,
    val totalFat: Double,
    val itemsData: String,
    val createdAt: Long = 0L
) {
    /** Deserialise stored string back to FoodItemDto list */
    fun toFoodItems(): List<FoodItemDto> = deserialiseItems(itemsData)

    companion object {
        private const val ITEM_SEP = "§§"
        private const val FIELD_SEP = "||"

        /**
         * Serialise a list of FoodItemDto into a compact storage string.
         * Format (14 fields per item): name||serving||cal||prot||carbs||fat||fiber||sugar||sodium||potassium||calcium||iron||vitC||vitD
         */
        fun serialiseItems(items: List<FoodItemDto>): String =
            items.joinToString(ITEM_SEP) { i ->
                listOf(
                    i.name, i.servingSize,
                    i.calories, i.protein, i.carbs, i.fat,
                    i.fiber, i.sugar, i.sodium, i.potassium,
                    i.calcium, i.iron, i.vitaminC, i.vitaminD
                ).joinToString(FIELD_SEP)
            }

        /** Deserialise the stored string back to a list of FoodItemDto. */
        fun deserialiseItems(data: String): List<FoodItemDto> {
            if (data.isBlank()) return emptyList()
            return data.split(ITEM_SEP).mapNotNull { entry ->
                val p = entry.split(FIELD_SEP)
                when {
                    p.size >= 14 -> FoodItemDto(
                        name        = p[0],
                        servingSize = p[1],
                        calories    = p[2].toDoubleOrNull() ?: 0.0,
                        protein     = p[3].toDoubleOrNull() ?: 0.0,
                        carbs       = p[4].toDoubleOrNull() ?: 0.0,
                        fat         = p[5].toDoubleOrNull() ?: 0.0,
                        fiber       = p[6].toDoubleOrNull() ?: 0.0,
                        sugar       = p[7].toDoubleOrNull() ?: 0.0,
                        sodium      = p[8].toDoubleOrNull() ?: 0.0,
                        potassium   = p[9].toDoubleOrNull() ?: 0.0,
                        calcium     = p[10].toDoubleOrNull() ?: 0.0,
                        iron        = p[11].toDoubleOrNull() ?: 0.0,
                        vitaminC    = p[12].toDoubleOrNull() ?: 0.0,
                        vitaminD    = p[13].toDoubleOrNull() ?: 0.0
                    )
                    // Legacy format (6 fields) — backward compat with old bookmarks
                    p.size >= 6 -> FoodItemDto(
                        name        = p[0],
                        servingSize = p[1],
                        calories    = p[2].toDoubleOrNull() ?: 0.0,
                        protein     = p[3].toDoubleOrNull() ?: 0.0,
                        carbs       = p[4].toDoubleOrNull() ?: 0.0,
                        fat         = p[5].toDoubleOrNull() ?: 0.0
                    )
                    else -> null
                }
            }
        }
    }
}
