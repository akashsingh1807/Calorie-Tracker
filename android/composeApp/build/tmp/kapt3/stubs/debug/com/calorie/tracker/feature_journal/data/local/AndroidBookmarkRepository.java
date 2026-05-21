package com.calorie.tracker.feature_journal.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\tJ\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bH\u0016J\u0016\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\rH\u0096@\u00a2\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/calorie/tracker/feature_journal/data/local/AndroidBookmarkRepository;", "Lcom/calorie/tracker/feature_journal/domain/BookmarkRepository;", "dao", "Lcom/calorie/tracker/feature_journal/data/local/BookmarkedMealDao;", "(Lcom/calorie/tracker/feature_journal/data/local/BookmarkedMealDao;)V", "deleteBookmark", "", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllBookmarks", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/calorie/tracker/model/BookmarkedMeal;", "insertBookmark", "meal", "(Lcom/calorie/tracker/model/BookmarkedMeal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "composeApp_debug"})
public final class AndroidBookmarkRepository implements com.calorie.tracker.feature_journal.domain.BookmarkRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.calorie.tracker.feature_journal.data.local.BookmarkedMealDao dao = null;
    
    public AndroidBookmarkRepository(@org.jetbrains.annotations.NotNull()
    com.calorie.tracker.feature_journal.data.local.BookmarkedMealDao dao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.calorie.tracker.model.BookmarkedMeal>> getAllBookmarks() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object insertBookmark(@org.jetbrains.annotations.NotNull()
    com.calorie.tracker.model.BookmarkedMeal meal, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object deleteBookmark(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}