package com.calorie.tracker.feature_journal.presentation.dashboard;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0010J\u000e\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020&J\u0012\u0010\'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020\u0010H\u0002J\u0006\u0010*\u001a\u00020\"J4\u0010+\u001a\u00020\"2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020(0\r2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u00020\u0010J\u000e\u00101\u001a\u00020\"2\u0006\u00102\u001a\u000203J\u0006\u00104\u001a\u00020\"J\u0017\u00105\u001a\u0004\u0018\u0001062\u0006\u0010#\u001a\u00020\u0010H\u0002\u00a2\u0006\u0002\u00107J\u0017\u00108\u001a\u0004\u0018\u0001092\u0006\u0010#\u001a\u00020\u0010H\u0002\u00a2\u0006\u0002\u0010:J\u000e\u0010;\u001a\u00020\"2\u0006\u0010<\u001a\u00020\u000eJ6\u0010=\u001a\u00020\"2\u0006\u0010>\u001a\u00020\u00102\u0006\u0010?\u001a\u0002062\u0006\u0010@\u001a\u0002062\u0006\u0010A\u001a\u0002062\u0006\u0010B\u001a\u0002062\u0006\u0010C\u001a\u00020\u0014J\u001c\u0010D\u001a\u00020\"2\u0006\u0010E\u001a\u00020\u00102\f\u0010,\u001a\b\u0012\u0004\u0012\u00020(0\rJ\u000e\u0010F\u001a\u00020\"2\u0006\u0010G\u001a\u00020\u0012J\u000e\u0010H\u001a\u00020\"2\u0006\u0010C\u001a\u00020\u0014R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\r0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0019\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\r0\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00140\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018\u00a8\u0006I"}, d2 = {"Lcom/calorie/tracker/feature_journal/presentation/dashboard/DashboardViewModel;", "Landroidx/lifecycle/ViewModel;", "mealRepository", "Lcom/calorie/tracker/feature_journal/domain/MealRepository;", "apiClient", "Lcom/calorie/tracker/core/network/CalorieApiClient;", "bookmarkRepository", "Lcom/calorie/tracker/feature_journal/domain/BookmarkRepository;", "(Lcom/calorie/tracker/feature_journal/domain/MealRepository;Lcom/calorie/tracker/core/network/CalorieApiClient;Lcom/calorie/tracker/feature_journal/domain/BookmarkRepository;)V", "_analysisState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/calorie/tracker/feature_journal/presentation/dashboard/MealAnalysisState;", "_bookmarks", "", "Lcom/calorie/tracker/model/BookmarkedMeal;", "_feedbackMessage", "", "_meals", "Lcom/calorie/tracker/model/Meal;", "_selectedDate", "Lkotlinx/datetime/LocalDate;", "analysisState", "Lkotlinx/coroutines/flow/StateFlow;", "getAnalysisState", "()Lkotlinx/coroutines/flow/StateFlow;", "bookmarks", "getBookmarks", "feedbackMessage", "getFeedbackMessage", "meals", "getMeals", "selectedDate", "getSelectedDate", "analyzeAndLogMeal", "", "text", "analyzeAndLogMealFromImage", "imageBytes", "", "buildFallbackItem", "Lcom/calorie/tracker/model/FoodItemDto;", "query", "clearFeedback", "confirmAndLogMeals", "foodItems", "originalText", "saveAsBookmark", "", "bookmarkName", "deleteBookmark", "id", "", "dismissAnalysis", "extractGrams", "", "(Ljava/lang/String;)Ljava/lang/Double;", "extractPieces", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "logBookmark", "bookmark", "logMeal", "mealType", "calories", "protein", "carbs", "fat", "date", "saveBookmark", "name", "saveLoggedMealAsBookmark", "meal", "selectDate", "composeApp_debug"})
public final class DashboardViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.calorie.tracker.feature_journal.domain.MealRepository mealRepository = null;
    @org.jetbrains.annotations.Nullable()
    private final com.calorie.tracker.core.network.CalorieApiClient apiClient = null;
    @org.jetbrains.annotations.Nullable()
    private final com.calorie.tracker.feature_journal.domain.BookmarkRepository bookmarkRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.calorie.tracker.model.Meal>> _meals = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.calorie.tracker.model.Meal>> meals = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<kotlinx.datetime.LocalDate> _selectedDate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<kotlinx.datetime.LocalDate> selectedDate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.calorie.tracker.feature_journal.presentation.dashboard.MealAnalysisState> _analysisState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.calorie.tracker.feature_journal.presentation.dashboard.MealAnalysisState> analysisState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.calorie.tracker.model.BookmarkedMeal>> _bookmarks = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.calorie.tracker.model.BookmarkedMeal>> bookmarks = null;
    
    /**
     * Snackbar-style feedback message after quick actions
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _feedbackMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> feedbackMessage = null;
    
    public DashboardViewModel(@org.jetbrains.annotations.NotNull()
    com.calorie.tracker.feature_journal.domain.MealRepository mealRepository, @org.jetbrains.annotations.Nullable()
    com.calorie.tracker.core.network.CalorieApiClient apiClient, @org.jetbrains.annotations.Nullable()
    com.calorie.tracker.feature_journal.domain.BookmarkRepository bookmarkRepository) {
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
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.calorie.tracker.feature_journal.presentation.dashboard.MealAnalysisState> getAnalysisState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.calorie.tracker.model.BookmarkedMeal>> getBookmarks() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getFeedbackMessage() {
        return null;
    }
    
    public final void selectDate(@org.jetbrains.annotations.NotNull()
    kotlinx.datetime.LocalDate date) {
    }
    
    public final void clearFeedback() {
    }
    
    /**
     * Analyzes the user's text input via Gemini AI to extract accurate food items
     * with per-quantity nutrition. Shows a confirmation dialog before logging.
     */
    public final void analyzeAndLogMeal(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    public final void analyzeAndLogMealFromImage(@org.jetbrains.annotations.NotNull()
    byte[] imageBytes) {
    }
    
    /**
     * Called when user confirms the food items in the dialog
     */
    public final void confirmAndLogMeals(@org.jetbrains.annotations.NotNull()
    java.util.List<com.calorie.tracker.model.FoodItemDto> foodItems, @org.jetbrains.annotations.Nullable()
    java.lang.String originalText, boolean saveAsBookmark, @org.jetbrains.annotations.NotNull()
    java.lang.String bookmarkName) {
    }
    
    public final void dismissAnalysis() {
    }
    
    /**
     * Save a list of food items as a named bookmark
     */
    public final void saveBookmark(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.util.List<com.calorie.tracker.model.FoodItemDto> foodItems) {
    }
    
    /**
     * Save an already-logged meal (from the meals list) as a bookmark
     */
    public final void saveLoggedMealAsBookmark(@org.jetbrains.annotations.NotNull()
    com.calorie.tracker.model.Meal meal) {
    }
    
    /**
     * Instantly log a bookmarked meal without AI analysis
     */
    public final void logBookmark(@org.jetbrains.annotations.NotNull()
    com.calorie.tracker.model.BookmarkedMeal bookmark) {
    }
    
    /**
     * Delete a bookmark
     */
    public final void deleteBookmark(long id) {
    }
    
    public final void logMeal(@org.jetbrains.annotations.NotNull()
    java.lang.String mealType, double calories, double protein, double carbs, double fat, @org.jetbrains.annotations.NotNull()
    kotlinx.datetime.LocalDate date) {
    }
    
    /**
     * Local fallback parser — used when network is unavailable.
     * Uses per-100g nutrient tables for common Indian and global foods,
     * now including micronutrients (fiber, sugar, sodium, potassium, calcium, iron, vitaminC, vitaminD).
     */
    private final com.calorie.tracker.model.FoodItemDto buildFallbackItem(java.lang.String query) {
        return null;
    }
    
    private final java.lang.Double extractGrams(java.lang.String text) {
        return null;
    }
    
    private final java.lang.Integer extractPieces(java.lang.String text) {
        return null;
    }
}