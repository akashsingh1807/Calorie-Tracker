package com.calorie.tracker.feature_journal.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0096@\u00a2\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\fH\u0096@\u00a2\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u0012H\u0016J\u0018\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00122\u0006\u0010\t\u001a\u00020\nH\u0016J\f\u0010\u0016\u001a\u00020\u0014*\u00020\u0017H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/calorie/tracker/feature_journal/data/local/AndroidWaterRepository;", "Lcom/calorie/tracker/feature_journal/domain/WaterRepository;", "dao", "Lcom/calorie/tracker/feature_journal/data/local/WaterDao;", "(Lcom/calorie/tracker/feature_journal/data/local/WaterDao;)V", "addGlasses", "", "glasses", "", "dateStr", "", "timestamp", "", "(ILjava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteWaterLog", "id", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllWaterLogs", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/calorie/tracker/feature_journal/domain/WaterEntry;", "getWaterLogByDate", "toDomain", "Lcom/calorie/tracker/feature_journal/data/local/WaterEntity;", "composeApp_debug"})
public final class AndroidWaterRepository implements com.calorie.tracker.feature_journal.domain.WaterRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.calorie.tracker.feature_journal.data.local.WaterDao dao = null;
    
    public AndroidWaterRepository(@org.jetbrains.annotations.NotNull()
    com.calorie.tracker.feature_journal.data.local.WaterDao dao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.calorie.tracker.feature_journal.domain.WaterEntry>> getAllWaterLogs() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<com.calorie.tracker.feature_journal.domain.WaterEntry> getWaterLogByDate(@org.jetbrains.annotations.NotNull()
    java.lang.String dateStr) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object addGlasses(int glasses, @org.jetbrains.annotations.NotNull()
    java.lang.String dateStr, long timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object deleteWaterLog(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final com.calorie.tracker.feature_journal.domain.WaterEntry toDomain(com.calorie.tracker.feature_journal.data.local.WaterEntity $this$toDomain) {
        return null;
    }
}