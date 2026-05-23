package com.calorie.tracker.feature_journal.domain;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u00a6@\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\tH\u00a6@\u00a2\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fH&J\u0018\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000f2\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\u0013"}, d2 = {"Lcom/calorie/tracker/feature_journal/domain/WaterRepository;", "", "addGlasses", "", "glasses", "", "dateStr", "", "timestamp", "", "(ILjava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteWaterLog", "id", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllWaterLogs", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/calorie/tracker/feature_journal/domain/WaterEntry;", "getWaterLogByDate", "composeApp_debug"})
public abstract interface WaterRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.calorie.tracker.feature_journal.domain.WaterEntry>> getAllWaterLogs();
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.calorie.tracker.feature_journal.domain.WaterEntry> getWaterLogByDate(@org.jetbrains.annotations.NotNull()
    java.lang.String dateStr);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addGlasses(int glasses, @org.jetbrains.annotations.NotNull()
    java.lang.String dateStr, long timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteWaterLog(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}