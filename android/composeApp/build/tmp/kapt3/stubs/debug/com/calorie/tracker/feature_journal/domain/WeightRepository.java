package com.calorie.tracker.feature_journal.domain;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH&J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nH\u00a6@\u00a2\u0006\u0002\u0010\fJ\u0018\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u00a6@\u00a2\u0006\u0002\u0010\u0010J&\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0015\u00a8\u0006\u0016"}, d2 = {"Lcom/calorie/tracker/feature_journal/domain/WeightRepository;", "", "deleteWeight", "", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllWeights", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/calorie/tracker/feature_journal/domain/WeightEntry;", "getLatestWeight", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getWeightByDate", "dateStr", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertWeight", "weightKg", "", "timestamp", "(DLjava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "composeApp_debug"})
public abstract interface WeightRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.calorie.tracker.feature_journal.domain.WeightEntry>> getAllWeights();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getLatestWeight(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.calorie.tracker.feature_journal.domain.WeightEntry> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getWeightByDate(@org.jetbrains.annotations.NotNull()
    java.lang.String dateStr, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.calorie.tracker.feature_journal.domain.WeightEntry> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertWeight(double weightKg, @org.jetbrains.annotations.NotNull()
    java.lang.String dateStr, long timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteWeight(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}