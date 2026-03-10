package com.aisheti.sahayak.data.db;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lcom/aisheti/sahayak/data/db/ShetiDatabase;", "Landroidx/room/RoomDatabase;", "()V", "savedAdviceDao", "Lcom/aisheti/sahayak/data/db/SavedAdviceDao;", "scanHistoryDao", "Lcom/aisheti/sahayak/data/db/ScanHistoryDao;", "app_release"})
@androidx.room.Database(entities = {com.aisheti.sahayak.data.models.ScanHistory.class, com.aisheti.sahayak.data.models.SavedAdvice.class}, version = 1, exportSchema = false)
public abstract class ShetiDatabase extends androidx.room.RoomDatabase {
    
    public ShetiDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.aisheti.sahayak.data.db.ScanHistoryDao scanHistoryDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.aisheti.sahayak.data.db.SavedAdviceDao savedAdviceDao();
}