package com.calorie.tracker.core.network;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H\u0086@\u00a2\u0006\u0002\u0010\u000bJ$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012J$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0014\u001a\u00020\u0003H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0015\u0010\u000bJ\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0003H\u0086@\u00a2\u0006\u0002\u0010\u000bJ$\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\r2\u0006\u0010\u001c\u001a\u00020\u001dH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001e\u0010\u001fJ$\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001b0\r2\u0006\u0010!\u001a\u00020\u0003H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\"\u0010\u000bJ$\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\r2\u0006\u0010\u001c\u001a\u00020%H\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b&\u0010\'J\u000e\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u0003J\f\u0010*\u001a\u00020\u0017*\u00020+H\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006,"}, d2 = {"Lcom/calorie/tracker/core/network/CalorieApiClient;", "", "baseUrl", "", "httpClient", "Lio/ktor/client/HttpClient;", "(Ljava/lang/String;Lio/ktor/client/HttpClient;)V", "authToken", "addMeal", "Lio/ktor/client/statement/HttpResponse;", "requestBody", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "analyzeMealImage", "Lkotlin/Result;", "Lcom/calorie/tracker/model/AnalyzeTextResponse;", "imageBytes", "", "analyzeMealImage-gIAlu-s", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "analyzeText", "text", "analyzeText-gIAlu-s", "clearAuthToken", "", "getDailyMeals", "date", "login", "Lcom/calorie/tracker/model/AuthResponse;", "request", "Lcom/calorie/tracker/model/LoginRequest;", "login-gIAlu-s", "(Lcom/calorie/tracker/model/LoginRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginWithGoogle", "idToken", "loginWithGoogle-gIAlu-s", "register", "Lcom/calorie/tracker/model/SignupResponse;", "Lcom/calorie/tracker/model/RegisterRequest;", "register-gIAlu-s", "(Lcom/calorie/tracker/model/RegisterRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setAuthToken", "token", "withAuth", "Lio/ktor/client/request/HttpRequestBuilder;", "composeApp_debug"})
public final class CalorieApiClient {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String baseUrl = null;
    @org.jetbrains.annotations.NotNull()
    private final io.ktor.client.HttpClient httpClient = null;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String authToken;
    
    public CalorieApiClient(@org.jetbrains.annotations.NotNull()
    java.lang.String baseUrl, @org.jetbrains.annotations.NotNull()
    io.ktor.client.HttpClient httpClient) {
        super();
    }
    
    public final void setAuthToken(@org.jetbrains.annotations.NotNull()
    java.lang.String token) {
    }
    
    public final void clearAuthToken() {
    }
    
    private final void withAuth(io.ktor.client.request.HttpRequestBuilder $this$withAuth) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getDailyMeals(@org.jetbrains.annotations.NotNull()
    java.lang.String date, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super io.ktor.client.statement.HttpResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addMeal(@org.jetbrains.annotations.NotNull()
    java.lang.String requestBody, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super io.ktor.client.statement.HttpResponse> $completion) {
        return null;
    }
}