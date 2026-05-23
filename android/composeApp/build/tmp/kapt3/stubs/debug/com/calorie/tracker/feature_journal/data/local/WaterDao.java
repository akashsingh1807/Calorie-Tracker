package com.calorie.tracker.feature_journal.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH\'J\u0018\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\b2\u0006\u0010\f\u001a\u00020\rH\'J\u0016\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/calorie/tracker/feature_journal/data/local/WaterDao;", "", "deleteWaterLog", "", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllWaterLogs", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/calorie/tracker/feature_journal/data/local/WaterEntity;", "getWaterLogByDate", "dateStr", "", "insertWaterLog", "waterEntity", "(Lcom/calorie/tracker/feature_journal/data/local/WaterEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "composeApp_debug"})
@androidx.room.Dao()
public abstract interface WaterDao {
    
    @androidx.room.Query(value = "SELECT * FROM water_logs ORDER BY timestamp DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.calorie.tracker.feature_journal.data.local.WaterEntity>> getAllWaterLogs();
    
    @androidx.room.Query(value = "SELECT * FROM water_logs WHERE dateStr = :dateStr LIMIT 1")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.calorie.tracker.feature_journal.data.local.WaterEntity> getWaterLogByDate(@org.jetbrains.annotations.NotNull()
    java.lang.String dateStr);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertWaterLog(@org.jetbrains.annotations.NotNull()
    com.calorie.tracker.feature_journal.data.local.WaterEntity waterEntity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM water_logs WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteWaterLog(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}