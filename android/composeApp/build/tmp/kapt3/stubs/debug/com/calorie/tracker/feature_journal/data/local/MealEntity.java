package com.calorie.tracker.feature_journal.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b2\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 E2\u00020\u0001:\u0001EB\u00a3\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\t\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u00a2\u0006\u0002\u0010\u0017J\t\u0010,\u001a\u00020\u0003H\u00c6\u0003J\t\u0010-\u001a\u00020\tH\u00c6\u0003J\t\u0010.\u001a\u00020\tH\u00c6\u0003J\t\u0010/\u001a\u00020\tH\u00c6\u0003J\t\u00100\u001a\u00020\tH\u00c6\u0003J\t\u00101\u001a\u00020\tH\u00c6\u0003J\t\u00102\u001a\u00020\tH\u00c6\u0003J\t\u00103\u001a\u00020\tH\u00c6\u0003J\t\u00104\u001a\u00020\tH\u00c6\u0003J\t\u00105\u001a\u00020\u0005H\u00c6\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u00107\u001a\u00020\u0003H\u00c6\u0003J\t\u00108\u001a\u00020\tH\u00c6\u0003J\t\u00109\u001a\u00020\tH\u00c6\u0003J\t\u0010:\u001a\u00020\tH\u00c6\u0003J\t\u0010;\u001a\u00020\tH\u00c6\u0003J\t\u0010<\u001a\u00020\u000eH\u00c6\u0003J\u00b5\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\tH\u00c6\u0001J\u0013\u0010>\u001a\u00020\u000e2\b\u0010?\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010@\u001a\u00020AH\u00d6\u0001J\u0006\u0010B\u001a\u00020CJ\t\u0010D\u001a\u00020\u0005H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u001cR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0011\u0010\u0013\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0011\u0010\u000b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u0011\u0010\f\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u0011\u0010\u000f\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u0011\u0010\u0014\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010 R\u0011\u0010\u0012\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010 R\u0011\u0010\n\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010 R\u0011\u0010\u0011\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010 R\u0011\u0010\u0010\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010 R\u0011\u0010\u0015\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010 R\u0011\u0010\u0016\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010 \u00a8\u0006F"}, d2 = {"Lcom/calorie/tracker/feature_journal/data/local/MealEntity;", "", "id", "", "mealType", "", "imageUrl", "timestamp", "totalCalories", "", "totalProtein", "totalCarbs", "totalFat", "isSynced", "", "totalFiber", "totalSugar", "totalSodium", "totalPotassium", "totalCalcium", "totalIron", "totalVitaminC", "totalVitaminD", "(JLjava/lang/String;Ljava/lang/String;JDDDDZDDDDDDDD)V", "getId", "()J", "getImageUrl", "()Ljava/lang/String;", "()Z", "getMealType", "getTimestamp", "getTotalCalcium", "()D", "getTotalCalories", "getTotalCarbs", "getTotalFat", "getTotalFiber", "getTotalIron", "getTotalPotassium", "getTotalProtein", "getTotalSodium", "getTotalSugar", "getTotalVitaminC", "getTotalVitaminD", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toDomain", "Lcom/calorie/tracker/model/Meal;", "toString", "Companion", "composeApp_debug"})
@androidx.room.Entity(tableName = "meals")
public final class MealEntity {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final long id = 0L;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String mealType = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String imageUrl = null;
    private final long timestamp = 0L;
    private final double totalCalories = 0.0;
    private final double totalProtein = 0.0;
    private final double totalCarbs = 0.0;
    private final double totalFat = 0.0;
    private final boolean isSynced = false;
    private final double totalFiber = 0.0;
    private final double totalSugar = 0.0;
    private final double totalSodium = 0.0;
    private final double totalPotassium = 0.0;
    private final double totalCalcium = 0.0;
    private final double totalIron = 0.0;
    private final double totalVitaminC = 0.0;
    private final double totalVitaminD = 0.0;
    @org.jetbrains.annotations.NotNull()
    public static final com.calorie.tracker.feature_journal.data.local.MealEntity.Companion Companion = null;
    
    public MealEntity(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String mealType, @org.jetbrains.annotations.Nullable()
    java.lang.String imageUrl, long timestamp, double totalCalories, double totalProtein, double totalCarbs, double totalFat, boolean isSynced, double totalFiber, double totalSugar, double totalSodium, double totalPotassium, double totalCalcium, double totalIron, double totalVitaminC, double totalVitaminD) {
        super();
    }
    
    public final long getId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMealType() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getImageUrl() {
        return null;
    }
    
    public final long getTimestamp() {
        return 0L;
    }
    
    public final double getTotalCalories() {
        return 0.0;
    }
    
    public final double getTotalProtein() {
        return 0.0;
    }
    
    public final double getTotalCarbs() {
        return 0.0;
    }
    
    public final double getTotalFat() {
        return 0.0;
    }
    
    public final boolean isSynced() {
        return false;
    }
    
    public final double getTotalFiber() {
        return 0.0;
    }
    
    public final double getTotalSugar() {
        return 0.0;
    }
    
    public final double getTotalSodium() {
        return 0.0;
    }
    
    public final double getTotalPotassium() {
        return 0.0;
    }
    
    public final double getTotalCalcium() {
        return 0.0;
    }
    
    public final double getTotalIron() {
        return 0.0;
    }
    
    public final double getTotalVitaminC() {
        return 0.0;
    }
    
    public final double getTotalVitaminD() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.calorie.tracker.model.Meal toDomain() {
        return null;
    }
    
    public final long component1() {
        return 0L;
    }
    
    public final double component10() {
        return 0.0;
    }
    
    public final double component11() {
        return 0.0;
    }
    
    public final double component12() {
        return 0.0;
    }
    
    public final double component13() {
        return 0.0;
    }
    
    public final double component14() {
        return 0.0;
    }
    
    public final double component15() {
        return 0.0;
    }
    
    public final double component16() {
        return 0.0;
    }
    
    public final double component17() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    public final long component4() {
        return 0L;
    }
    
    public final double component5() {
        return 0.0;
    }
    
    public final double component6() {
        return 0.0;
    }
    
    public final double component7() {
        return 0.0;
    }
    
    public final double component8() {
        return 0.0;
    }
    
    public final boolean component9() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.calorie.tracker.feature_journal.data.local.MealEntity copy(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String mealType, @org.jetbrains.annotations.Nullable()
    java.lang.String imageUrl, long timestamp, double totalCalories, double totalProtein, double totalCarbs, double totalFat, boolean isSynced, double totalFiber, double totalSugar, double totalSodium, double totalPotassium, double totalCalcium, double totalIron, double totalVitaminC, double totalVitaminD) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/calorie/tracker/feature_journal/data/local/MealEntity$Companion;", "", "()V", "fromDomain", "Lcom/calorie/tracker/feature_journal/data/local/MealEntity;", "meal", "Lcom/calorie/tracker/model/Meal;", "composeApp_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.calorie.tracker.feature_journal.data.local.MealEntity fromDomain(@org.jetbrains.annotations.NotNull()
        com.calorie.tracker.model.Meal meal) {
            return null;
        }
    }
}