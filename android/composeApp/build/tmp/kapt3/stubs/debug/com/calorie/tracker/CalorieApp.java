package com.calorie.tracker;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0015"}, d2 = {"Lcom/calorie/tracker/CalorieApp;", "Landroid/app/Application;", "()V", "BASE_URL", "", "apiClient", "Lcom/calorie/tracker/core/network/CalorieApiClient;", "getApiClient", "()Lcom/calorie/tracker/core/network/CalorieApiClient;", "apiClient$delegate", "Lkotlin/Lazy;", "authRepository", "Lcom/calorie/tracker/feature_auth/domain/AuthRepository;", "getAuthRepository", "()Lcom/calorie/tracker/feature_auth/domain/AuthRepository;", "authRepository$delegate", "mealRepository", "Lcom/calorie/tracker/feature_journal/domain/MealRepository;", "getMealRepository", "()Lcom/calorie/tracker/feature_journal/domain/MealRepository;", "mealRepository$delegate", "composeApp_debug"})
public final class CalorieApp extends android.app.Application {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String BASE_URL = "http://10.0.2.2:8080";
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy apiClient$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy authRepository$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy mealRepository$delegate = null;
    
    public CalorieApp() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.calorie.tracker.core.network.CalorieApiClient getApiClient() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.calorie.tracker.feature_auth.domain.AuthRepository getAuthRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.calorie.tracker.feature_journal.domain.MealRepository getMealRepository() {
        return null;
    }
}