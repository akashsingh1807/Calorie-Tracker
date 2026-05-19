package com.calorie.tracker.feature_journal.presentation.dashboard;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/calorie/tracker/feature_journal/presentation/dashboard/DashboardViewModel;", "Landroidx/lifecycle/ViewModel;", "mealRepository", "Lcom/calorie/tracker/feature_journal/domain/MealRepository;", "(Lcom/calorie/tracker/feature_journal/domain/MealRepository;)V", "_meals", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/calorie/tracker/model/Meal;", "_selectedDate", "Lkotlinx/datetime/LocalDate;", "meals", "Lkotlinx/coroutines/flow/StateFlow;", "getMeals", "()Lkotlinx/coroutines/flow/StateFlow;", "selectedDate", "getSelectedDate", "selectDate", "", "date", "composeApp_debug"})
public final class DashboardViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.calorie.tracker.feature_journal.domain.MealRepository mealRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.calorie.tracker.model.Meal>> _meals = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.calorie.tracker.model.Meal>> meals = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<kotlinx.datetime.LocalDate> _selectedDate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<kotlinx.datetime.LocalDate> selectedDate = null;
    
    public DashboardViewModel(@org.jetbrains.annotations.NotNull()
    com.calorie.tracker.feature_journal.domain.MealRepository mealRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.calorie.tracker.model.Meal>> getMeals() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<kotlinx.datetime.LocalDate> getSelectedDate() {
        return null;
    }
    
    public final void selectDate(@org.jetbrains.annotations.NotNull()
    kotlinx.datetime.LocalDate date) {
    }
}