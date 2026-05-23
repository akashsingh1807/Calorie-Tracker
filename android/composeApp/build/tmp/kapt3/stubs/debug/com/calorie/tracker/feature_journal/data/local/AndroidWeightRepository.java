package com.calorie.tracker.feature_journal.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\tJ\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bH\u0016J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096@\u00a2\u0006\u0002\u0010\u000fJ\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@\u00a2\u0006\u0002\u0010\u0013J&\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\u0018J\f\u0010\u0019\u001a\u00020\r*\u00020\u001aH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/calorie/tracker/feature_journal/data/local/AndroidWeightRepository;", "Lcom/calorie/tracker/feature_journal/domain/WeightRepository;", "dao", "Lcom/calorie/tracker/feature_journal/data/local/WeightDao;", "(Lcom/calorie/tracker/feature_journal/data/local/WeightDao;)V", "deleteWeight", "", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllWeights", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/calorie/tracker/feature_journal/domain/WeightEntry;", "getLatestWeight", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getWeightByDate", "dateStr", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertWeight", "weightKg", "", "timestamp", "(DLjava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toDomain", "Lcom/calorie/tracker/feature_journal/data/local/WeightEntity;", "composeApp_debug"})
public final class AndroidWeightRepository implements com.calorie.tracker.feature_journal.domain.WeightRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.calorie.tracker.feature_journal.data.local.WeightDao dao = null;
    
    public AndroidWeightRepository(@org.jetbrains.annotations.NotNull()
    com.calorie.tracker.feature_journal.data.local.WeightDao dao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.calorie.tracker.feature_journal.domain.WeightEntry>> getAllWeights() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getLatestWeight(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.calorie.tracker.feature_journal.domain.WeightEntry> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getWeightByDate(@org.jetbrains.annotations.NotNull()
    java.lang.String dateStr, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.calorie.tracker.feature_journal.domain.WeightEntry> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object insertWeight(double weightKg, @org.jetbrains.annotations.NotNull()
    java.lang.String dateStr, long timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object deleteWeight(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final com.calorie.tracker.feature_journal.domain.WeightEntry toDomain(com.calorie.tracker.feature_journal.data.local.WeightEntity $this$toDomain) {
        return null;
    }
}