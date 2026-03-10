package com.aisheti.sahayak.data.db;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00100\u000fH\'J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0010H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\t\u00a8\u0006\u0013"}, d2 = {"Lcom/aisheti/sahayak/data/db/ScanHistoryDao;", "", "count", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delete", "", "history", "Lcom/aisheti/sahayak/data/models/ScanHistory;", "(Lcom/aisheti/sahayak/data/models/ScanHistory;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteOlderThan", "cutoff", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllHistory", "Landroidx/lifecycle/LiveData;", "", "getAllHistoryOnce", "insert", "app_release"})
@androidx.room.Dao()
public abstract interface ScanHistoryDao {
    
    @androidx.room.Query(value = "SELECT * FROM scan_history ORDER BY timestamp DESC LIMIT 50")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.aisheti.sahayak.data.models.ScanHistory>> getAllHistory();
    
    @androidx.room.Query(value = "SELECT * FROM scan_history ORDER BY timestamp DESC LIMIT 50")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllHistoryOnce(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.aisheti.sahayak.data.models.ScanHistory>> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.aisheti.sahayak.data.models.ScanHistory history, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.aisheti.sahayak.data.models.ScanHistory history, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM scan_history WHERE timestamp < :cutoff")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteOlderThan(long cutoff, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM scan_history")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object count(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
}