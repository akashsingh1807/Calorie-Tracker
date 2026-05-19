package com.calorie.tracker.feature_journal.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0096@\u00a2\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/calorie/tracker/feature_journal/data/local/AndroidMealRepository;", "Lcom/calorie/tracker/feature_journal/domain/MealRepository;", "mealDao", "Lcom/calorie/tracker/feature_journal/data/local/MealDao;", "(Lcom/calorie/tracker/feature_journal/data/local/MealDao;)V", "getMealsForDate", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/calorie/tracker/model/Meal;", "startOfDay", "", "endOfDay", "getUnsyncedMeals", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertMeal", "meal", "(Lcom/calorie/tracker/model/Meal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateMeal", "", "composeApp_debug"})
public final class AndroidMealRepository implements com.calorie.tracker.feature_journal.domain.MealRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.calorie.tracker.feature_journal.data.local.MealDao mealDao = null;
    
    public AndroidMealRepository(@org.jetbrains.annotations.NotNull()
    com.calorie.tracker.feature_journal.data.local.MealDao mealDao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.calorie.tracker.model.Meal>> getMealsForDate(long startOfDay, long endOfDay) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object insertMeal(@org.jetbrains.annotations.NotNull()
    com.calorie.tracker.model.Meal meal, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getUnsyncedMeals(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.calorie.tracker.model.Meal>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object updateMeal(@org.jetbrains.annotations.NotNull()
    com.calorie.tracker.model.Meal meal, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}