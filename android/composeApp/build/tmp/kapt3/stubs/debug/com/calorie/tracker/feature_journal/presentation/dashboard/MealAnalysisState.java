package com.calorie.tracker.feature_journal.presentation.dashboard;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/calorie/tracker/feature_journal/presentation/dashboard/MealAnalysisState;", "", "()V", "Analyzing", "Error", "Idle", "PendingConfirmation", "Lcom/calorie/tracker/feature_journal/presentation/dashboard/MealAnalysisState$Analyzing;", "Lcom/calorie/tracker/feature_journal/presentation/dashboard/MealAnalysisState$Error;", "Lcom/calorie/tracker/feature_journal/presentation/dashboard/MealAnalysisState$Idle;", "Lcom/calorie/tracker/feature_journal/presentation/dashboard/MealAnalysisState$PendingConfirmation;", "composeApp_debug"})
public abstract class MealAnalysisState {
    
    private MealAnalysisState() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/calorie/tracker/feature_journal/presentation/dashboard/MealAnalysisState$Analyzing;", "Lcom/calorie/tracker/feature_journal/presentation/dashboard/MealAnalysisState;", "()V", "composeApp_debug"})
    public static final class Analyzing extends com.calorie.tracker.feature_journal.presentation.dashboard.MealAnalysisState {
        @org.jetbrains.annotations.NotNull()
        public static final com.calorie.tracker.feature_journal.presentation.dashboard.MealAnalysisState.Analyzing INSTANCE = null;
        
        private Analyzing() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/calorie/tracker/feature_journal/presentation/dashboard/MealAnalysisState$Error;", "Lcom/calorie/tracker/feature_journal/presentation/dashboard/MealAnalysisState;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "composeApp_debug"})
    public static final class Error extends com.calorie.tracker.feature_journal.presentation.dashboard.MealAnalysisState {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String message = null;
        
        public Error(@org.jetbrains.annotations.NotNull()
        java.lang.String message) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getMessage() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.calorie.tracker.feature_journal.presentation.dashboard.MealAnalysisState.Error copy(@org.jetbrains.annotations.NotNull()
        java.lang.String message) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/calorie/tracker/feature_journal/presentation/dashboard/MealAnalysisState$Idle;", "Lcom/calorie/tracker/feature_journal/presentation/dashboard/MealAnalysisState;", "()V", "composeApp_debug"})
    public static final class Idle extends com.calorie.tracker.feature_journal.presentation.dashboard.MealAnalysisState {
        @org.jetbrains.annotations.NotNull()
        public static final com.calorie.tracker.feature_journal.presentation.dashboard.MealAnalysisState.Idle INSTANCE = null;
        
        private Idle() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Lcom/calorie/tracker/feature_journal/presentation/dashboard/MealAnalysisState$PendingConfirmation;", "Lcom/calorie/tracker/feature_journal/presentation/dashboard/MealAnalysisState;", "originalText", "", "foodItems", "", "Lcom/calorie/tracker/model/FoodItemDto;", "(Ljava/lang/String;Ljava/util/List;)V", "getFoodItems", "()Ljava/util/List;", "getOriginalText", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "composeApp_debug"})
    public static final class PendingConfirmation extends com.calorie.tracker.feature_journal.presentation.dashboard.MealAnalysisState {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String originalText = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.calorie.tracker.model.FoodItemDto> foodItems = null;
        
        public PendingConfirmation(@org.jetbrains.annotations.NotNull()
        java.lang.String originalText, @org.jetbrains.annotations.NotNull()
        java.util.List<com.calorie.tracker.model.FoodItemDto> foodItems) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getOriginalText() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.calorie.tracker.model.FoodItemDto> getFoodItems() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.calorie.tracker.model.FoodItemDto> component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.calorie.tracker.feature_journal.presentation.dashboard.MealAnalysisState.PendingConfirmation copy(@org.jetbrains.annotations.NotNull()
        java.lang.String originalText, @org.jetbrains.annotations.NotNull()
        java.util.List<com.calorie.tracker.model.FoodItemDto> foodItems) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
}