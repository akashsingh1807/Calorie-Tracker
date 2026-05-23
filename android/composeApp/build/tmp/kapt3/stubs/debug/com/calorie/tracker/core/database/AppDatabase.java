package com.calorie.tracker.core.database;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&\u00a8\u0006\f"}, d2 = {"Lcom/calorie/tracker/core/database/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "bookmarkedMealDao", "Lcom/calorie/tracker/feature_journal/data/local/BookmarkedMealDao;", "mealDao", "Lcom/calorie/tracker/feature_journal/data/local/MealDao;", "waterDao", "Lcom/calorie/tracker/feature_journal/data/local/WaterDao;", "weightDao", "Lcom/calorie/tracker/feature_journal/data/local/WeightDao;", "Companion", "composeApp_debug"})
@androidx.room.Database(entities = {com.calorie.tracker.feature_journal.data.local.MealEntity.class, com.calorie.tracker.feature_journal.data.local.BookmarkedMealEntity.class, com.calorie.tracker.feature_journal.data.local.WeightEntity.class, com.calorie.tracker.feature_journal.data.local.WaterEntity.class}, version = 5, exportSchema = false)
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    private static final androidx.room.migration.Migration MIGRATION_1_2 = null;
    
    /**
     * Migration 2 → 3: Add 8 micronutrient columns to the meals table
     */
    @org.jetbrains.annotations.NotNull()
    private static final androidx.room.migration.Migration MIGRATION_2_3 = null;
    
    /**
     * Migration 3 → 4: Add rawTextInput and isAiLogged for WhatsApp-style chat UI
     */
    @org.jetbrains.annotations.NotNull()
    private static final androidx.room.migration.Migration MIGRATION_3_4 = null;
    
    /**
     * Migration 4 → 5: Add weight_logs and water_logs tables
     */
    @org.jetbrains.annotations.NotNull()
    private static final androidx.room.migration.Migration MIGRATION_4_5 = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.calorie.tracker.core.database.AppDatabase.Companion Companion = null;
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.calorie.tracker.feature_journal.data.local.MealDao mealDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.calorie.tracker.feature_journal.data.local.BookmarkedMealDao bookmarkedMealDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.calorie.tracker.feature_journal.data.local.WeightDao weightDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.calorie.tracker.feature_journal.data.local.WaterDao waterDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/calorie/tracker/core/database/AppDatabase$Companion;", "", "()V", "MIGRATION_1_2", "Landroidx/room/migration/Migration;", "getMIGRATION_1_2", "()Landroidx/room/migration/Migration;", "MIGRATION_2_3", "getMIGRATION_2_3", "MIGRATION_3_4", "getMIGRATION_3_4", "MIGRATION_4_5", "getMIGRATION_4_5", "composeApp_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.room.migration.Migration getMIGRATION_1_2() {
            return null;
        }
        
        /**
         * Migration 2 → 3: Add 8 micronutrient columns to the meals table
         */
        @org.jetbrains.annotations.NotNull()
        public final androidx.room.migration.Migration getMIGRATION_2_3() {
            return null;
        }
        
        /**
         * Migration 3 → 4: Add rawTextInput and isAiLogged for WhatsApp-style chat UI
         */
        @org.jetbrains.annotations.NotNull()
        public final androidx.room.migration.Migration getMIGRATION_3_4() {
            return null;
        }
        
        /**
         * Migration 4 → 5: Add weight_logs and water_logs tables
         */
        @org.jetbrains.annotations.NotNull()
        public final androidx.room.migration.Migration getMIGRATION_4_5() {
            return null;
        }
    }
}