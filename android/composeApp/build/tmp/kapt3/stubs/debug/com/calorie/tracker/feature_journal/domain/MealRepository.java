package com.calorie.tracker.feature_journal.domain;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00a6@\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/calorie/tracker/feature_journal/domain/MealRepository;", "", "getMealsForDate", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/calorie/tracker/model/Meal;", "startOfDay", "", "endOfDay", "getUnsyncedMeals", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertMeal", "meal", "(Lcom/calorie/tracker/model/Meal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateMeal", "", "composeApp_debug"})
public abstract interface MealRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.calorie.tracker.model.Meal>> getMealsForDate(long startOfDay, long endOfDay);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertMeal(@org.jetbrains.annotations.NotNull()
    com.calorie.tracker.model.Meal meal, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUnsyncedMeals(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.calorie.tracker.model.Meal>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateMeal(@org.jetbrains.annotations.NotNull()
    com.calorie.tracker.model.Meal meal, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}