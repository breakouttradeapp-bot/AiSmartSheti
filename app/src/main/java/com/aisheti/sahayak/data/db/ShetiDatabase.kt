package com.aisheti.sahayak.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.aisheti.sahayak.data.models.SavedAdvice
import com.aisheti.sahayak.data.models.ScanHistory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import android.content.Context
import javax.inject.Singleton

// ─── DAOs ─────────────────────────────────────────────────────────────────────

@Dao
interface ScanHistoryDao {
    @Query("SELECT * FROM scan_history ORDER BY timestamp DESC LIMIT 50")
    fun getAllHistory(): LiveData<List<ScanHistory>>

    @Query("SELECT * FROM scan_history ORDER BY timestamp DESC LIMIT 50")
    suspend fun getAllHistoryOnce(): List<ScanHistory>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(history: ScanHistory): Long

    @Delete
    suspend fun delete(history: ScanHistory)

    @Query("DELETE FROM scan_history WHERE timestamp < :cutoff")
    suspend fun deleteOlderThan(cutoff: Long)

    @Query("SELECT COUNT(*) FROM scan_history")
    suspend fun count(): Int
}

@Dao
interface SavedAdviceDao {
    @Query("SELECT * FROM saved_advice ORDER BY timestamp DESC")
    fun getAllSaved(): LiveData<List<SavedAdvice>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(advice: SavedAdvice): Long

    @Delete
    suspend fun delete(advice: SavedAdvice)

    @Query("DELETE FROM saved_advice")
    suspend fun deleteAll()
}

// ─── Database ──────────────────────────────────────────────────────────────────

@Database(
    entities = [ScanHistory::class, SavedAdvice::class],
    version = 1,
    exportSchema = false
)
abstract class ShetiDatabase : RoomDatabase() {
    abstract fun scanHistoryDao(): ScanHistoryDao
    abstract fun savedAdviceDao(): SavedAdviceDao
}

// ─── Database Module ───────────────────────────────────────────────────────────

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideShetiDatabase(@ApplicationContext context: Context): ShetiDatabase =
        Room.databaseBuilder(
            context,
            ShetiDatabase::class.java,
            "sheti_database"
        )
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideScanHistoryDao(db: ShetiDatabase): ScanHistoryDao = db.scanHistoryDao()

    @Provides
    fun provideSavedAdviceDao(db: ShetiDatabase): SavedAdviceDao = db.savedAdviceDao()
}
