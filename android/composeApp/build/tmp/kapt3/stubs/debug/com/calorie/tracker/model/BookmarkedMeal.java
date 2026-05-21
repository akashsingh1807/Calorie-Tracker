package com.calorie.tracker.model;

/**
 * Common/shared model for a saved bookmark meal.
 * Platform-independent — does not reference Room annotations.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0001+BI\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003JY\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010%\u001a\u00020&H\u00d6\u0001J\f\u0010\'\u001a\b\u0012\u0004\u0012\u00020)0(J\t\u0010*\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015\u00a8\u0006,"}, d2 = {"Lcom/calorie/tracker/model/BookmarkedMeal;", "", "id", "", "name", "", "totalCalories", "", "totalProtein", "totalCarbs", "totalFat", "itemsData", "createdAt", "(JLjava/lang/String;DDDDLjava/lang/String;J)V", "getCreatedAt", "()J", "getId", "getItemsData", "()Ljava/lang/String;", "getName", "getTotalCalories", "()D", "getTotalCarbs", "getTotalFat", "getTotalProtein", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toFoodItems", "", "Lcom/calorie/tracker/model/FoodItemDto;", "toString", "Companion", "composeApp_debug"})
public final class BookmarkedMeal {
    private final long id = 0L;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String name = null;
    private final double totalCalories = 0.0;
    private final double totalProtein = 0.0;
    private final double totalCarbs = 0.0;
    private final double totalFat = 0.0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String itemsData = null;
    private final long createdAt = 0L;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String ITEM_SEP = "\u00a7\u00a7";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String FIELD_SEP = "||";
    @org.jetbrains.annotations.NotNull()
    public static final com.calorie.tracker.model.BookmarkedMeal.Companion Companion = null;
    
    public BookmarkedMeal(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, double totalCalories, double totalProtein, double totalCarbs, double totalFat, @org.jetbrains.annotations.NotNull()
    java.lang.String itemsData, long createdAt) {
        super();
    }
    
    public final long getId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getItemsData() {
        return null;
    }
    
    public final long getCreatedAt() {
        return 0L;
    }
    
    /**
     * Deserialise stored string back to FoodItemDto list
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.calorie.tracker.model.FoodItemDto> toFoodItems() {
        return null;
    }
    
    public final long component1() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    public final double component3() {
        return 0.0;
    }
    
    public final double component4() {
        return 0.0;
    }
    
    public final double component5() {
        return 0.0;
    }
    
    public final double component6() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    public final long component8() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.calorie.tracker.model.BookmarkedMeal copy(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String name, double totalCalories, double totalProtein, double totalCarbs, double totalFat, @org.jetbrains.annotations.NotNull()
    java.lang.String itemsData, long createdAt) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\u0004J\u0014\u0010\n\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/calorie/tracker/model/BookmarkedMeal$Companion;", "", "()V", "FIELD_SEP", "", "ITEM_SEP", "deserialiseItems", "", "Lcom/calorie/tracker/model/FoodItemDto;", "data", "serialiseItems", "items", "composeApp_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        /**
         * Serialise a list of FoodItemDto into a compact storage string.
         * Format (14 fields per item): name||serving||cal||prot||carbs||fat||fiber||sugar||sodium||potassium||calcium||iron||vitC||vitD
         */
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String serialiseItems(@org.jetbrains.annotations.NotNull()
        java.util.List<com.calorie.tracker.model.FoodItemDto> items) {
            return null;
        }
        
        /**
         * Deserialise the stored string back to a list of FoodItemDto.
         */
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.calorie.tracker.model.FoodItemDto> deserialiseItems(@org.jetbrains.annotations.NotNull()
        java.lang.String data) {
            return null;
        }
    }
}