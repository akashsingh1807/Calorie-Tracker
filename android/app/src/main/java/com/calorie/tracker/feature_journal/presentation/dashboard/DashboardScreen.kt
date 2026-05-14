package com.calorie.tracker.feature_journal.presentation.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    viewModel: DashboardViewModel = hiltViewModel(),
    onAddMealClick: () -> Unit
) {
    val meals by viewModel.meals.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Today's Summary") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddMealClick) {
                Icon(Icons.Default.Add, contentDescription = "Add Meal")
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            // Dashboard Summary Card
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Calories: ${meals.sumOf { it.totalCalories }} / 2000 kcal")
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Protein: ${meals.sumOf { it.totalProtein }}g")
                    Text("Carbs: ${meals.sumOf { it.totalCarbs }}g")
                    Text("Fat: ${meals.sumOf { it.totalFat }}g")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text("Meal Timeline", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))

            // Meals List
            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                items(meals) { meal ->
                    Card(modifier = Modifier.fillMaxWidth()) {
                        Row(
                            modifier = Modifier
                                .padding(16.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(meal.mealType, style = MaterialTheme.typography.bodyLarge)
                            Text("${meal.totalCalories} kcal", style = MaterialTheme.typography.bodyMedium)
                        }
                    }
                }
            }
        }
    }
}
