package com.calorie.tracker.feature_journal.presentation.dashboard;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\\\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aL\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\bH\u0003\u001a,\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0003\u001aZ\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007\u001aR\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00032$\u0010\u001f\u001a \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u0003\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00010 2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0003\u001a$\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u001e2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00010\bH\u0003\u001a0\u0010&\u001a\u00020\u00012\u0006\u0010\'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001cH\u0003\u001a\u0018\u0010,\u001a\u00020\u00012\u0006\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u001cH\u0003\u001a\u0016\u0010/\u001a\u00020\u00012\f\u00100\u001a\b\u0012\u0004\u0012\u0002010\u0003H\u0003\u001a\u0018\u00102\u001a\u00020\u00012\u0006\u00103\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u001cH\u0003\u00a8\u00064"}, d2 = {"BookmarkBottomSheet", "", "bookmarks", "", "Lcom/calorie/tracker/model/BookmarkedMeal;", "onDismiss", "Lkotlin/Function0;", "onLogBookmark", "Lkotlin/Function1;", "onDeleteBookmark", "", "BookmarkCard", "bookmark", "onLog", "onDelete", "DashboardScreen", "viewModel", "Lcom/calorie/tracker/feature_journal/presentation/dashboard/DashboardViewModel;", "calorieGoal", "", "carbsGoalPct", "proteinGoalPct", "fatGoalPct", "onMenuClick", "onStreakClick", "onLogout", "FoodConfirmationDialog", "originalText", "", "initialFoodItems", "Lcom/calorie/tracker/model/FoodItemDto;", "onConfirm", "Lkotlin/Function3;", "", "FoodItemConfirmRow", "item", "onQuantityChange", "", "FoodItemDetailRow", "name", "calories", "carbs", "protein", "fat", "MacroBadge", "label", "value", "MicronutrientsCard", "meals", "Lcom/calorie/tracker/model/Meal;", "TotalsColumnItem", "title", "composeApp_debug"})
public final class DashboardScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void DashboardScreen(@org.jetbrains.annotations.NotNull()
    com.calorie.tracker.feature_journal.presentation.dashboard.DashboardViewModel viewModel, int calorieGoal, int carbsGoalPct, int proteinGoalPct, int fatGoalPct, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onMenuClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onStreakClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onLogout) {
    }
    
    /**
     * Dialog that shows detected food items with quantities and lets user
     * review/adjust quantities before confirming the log.
     */
    @androidx.compose.runtime.Composable()
    private static final void FoodConfirmationDialog(java.lang.String originalText, java.util.List<com.calorie.tracker.model.FoodItemDto> initialFoodItems, kotlin.jvm.functions.Function3<? super java.util.List<com.calorie.tracker.model.FoodItemDto>, ? super java.lang.Boolean, ? super java.lang.String, kotlin.Unit> onConfirm, kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss) {
    }
    
    /**
     * Bottom sheet showing all saved/bookmarked meals for quick re-logging.
     */
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    private static final void BookmarkBottomSheet(java.util.List<com.calorie.tracker.model.BookmarkedMeal> bookmarks, kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss, kotlin.jvm.functions.Function1<? super com.calorie.tracker.model.BookmarkedMeal, kotlin.Unit> onLogBookmark, kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> onDeleteBookmark) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void BookmarkCard(com.calorie.tracker.model.BookmarkedMeal bookmark, kotlin.jvm.functions.Function0<kotlin.Unit> onLog, kotlin.jvm.functions.Function0<kotlin.Unit> onDelete) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void FoodItemConfirmRow(com.calorie.tracker.model.FoodItemDto item, kotlin.jvm.functions.Function1<? super java.lang.Double, kotlin.Unit> onQuantityChange) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void FoodItemDetailRow(java.lang.String name, java.lang.String calories, java.lang.String carbs, java.lang.String protein, java.lang.String fat) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void MacroBadge(java.lang.String label, java.lang.String value) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void TotalsColumnItem(java.lang.String title, java.lang.String value) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void MicronutrientsCard(java.util.List<com.calorie.tracker.model.Meal> meals) {
    }
}