package com.aisheti.sahayak.data.db;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class ShetiDatabase_Impl extends ShetiDatabase {
  private volatile ScanHistoryDao _scanHistoryDao;

  private volatile SavedAdviceDao _savedAdviceDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `scan_history` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `type` TEXT NOT NULL, `query` TEXT NOT NULL, `response` TEXT NOT NULL, `imagePath` TEXT, `timestamp` INTEGER NOT NULL, `language` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `saved_advice` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `title` TEXT NOT NULL, `content` TEXT NOT NULL, `category` TEXT NOT NULL, `timestamp` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '44ae005e2e94c68158bb7282bf3cf5d4')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `scan_history`");
        db.execSQL("DROP TABLE IF EXISTS `saved_advice`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsScanHistory = new HashMap<String, TableInfo.Column>(7);
        _columnsScanHistory.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsScanHistory.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsScanHistory.put("query", new TableInfo.Column("query", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsScanHistory.put("response", new TableInfo.Column("response", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsScanHistory.put("imagePath", new TableInfo.Column("imagePath", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsScanHistory.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsScanHistory.put("language", new TableInfo.Column("language", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysScanHistory = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesScanHistory = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoScanHistory = new TableInfo("scan_history", _columnsScanHistory, _foreignKeysScanHistory, _indicesScanHistory);
        final TableInfo _existingScanHistory = TableInfo.read(db, "scan_history");
        if (!_infoScanHistory.equals(_existingScanHistory)) {
          return new RoomOpenHelper.ValidationResult(false, "scan_history(com.aisheti.sahayak.data.models.ScanHistory).\n"
                  + " Expected:\n" + _infoScanHistory + "\n"
                  + " Found:\n" + _existingScanHistory);
        }
        final HashMap<String, TableInfo.Column> _columnsSavedAdvice = new HashMap<String, TableInfo.Column>(5);
        _columnsSavedAdvice.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSavedAdvice.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSavedAdvice.put("content", new TableInfo.Column("content", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSavedAdvice.put("category", new TableInfo.Column("category", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSavedAdvice.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSavedAdvice = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSavedAdvice = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSavedAdvice = new TableInfo("saved_advice", _columnsSavedAdvice, _foreignKeysSavedAdvice, _indicesSavedAdvice);
        final TableInfo _existingSavedAdvice = TableInfo.read(db, "saved_advice");
        if (!_infoSavedAdvice.equals(_existingSavedAdvice)) {
          return new RoomOpenHelper.ValidationResult(false, "saved_advice(com.aisheti.sahayak.data.models.SavedAdvice).\n"
                  + " Expected:\n" + _infoSavedAdvice + "\n"
                  + " Found:\n" + _existingSavedAdvice);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "44ae005e2e94c68158bb7282bf3cf5d4", "ecfbaa552694eb23c244ab4a3f0278bb");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "scan_history","saved_advice");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `scan_history`");
      _db.execSQL("DELETE FROM `saved_advice`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(ScanHistoryDao.class, ScanHistoryDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(SavedAdviceDao.class, SavedAdviceDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public ScanHistoryDao scanHistoryDao() {
    if (_scanHistoryDao != null) {
      return _scanHistoryDao;
    } else {
      synchronized(this) {
        if(_scanHistoryDao == null) {
          _scanHistoryDao = new ScanHistoryDao_Impl(this);
        }
        return _scanHistoryDao;
      }
    }
  }

  @Override
  public SavedAdviceDao savedAdviceDao() {
    if (_savedAdviceDao != null) {
      return _savedAdviceDao;
    } else {
      synchronized(this) {
        if(_savedAdviceDao == null) {
          _savedAdviceDao = new SavedAdviceDao_Impl(this);
        }
        return _savedAdviceDao;
      }
    }
  }
}
