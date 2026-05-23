package com.calorie.tracker.core.database;

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
import com.calorie.tracker.feature_journal.data.local.BookmarkedMealDao;
import com.calorie.tracker.feature_journal.data.local.BookmarkedMealDao_Impl;
import com.calorie.tracker.feature_journal.data.local.MealDao;
import com.calorie.tracker.feature_journal.data.local.MealDao_Impl;
import com.calorie.tracker.feature_journal.data.local.WaterDao;
import com.calorie.tracker.feature_journal.data.local.WaterDao_Impl;
import com.calorie.tracker.feature_journal.data.local.WeightDao;
import com.calorie.tracker.feature_journal.data.local.WeightDao_Impl;
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
public final class AppDatabase_Impl extends AppDatabase {
  private volatile MealDao _mealDao;

  private volatile BookmarkedMealDao _bookmarkedMealDao;

  private volatile WeightDao _weightDao;

  private volatile WaterDao _waterDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(5) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `meals` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `mealType` TEXT NOT NULL, `imageUrl` TEXT, `timestamp` INTEGER NOT NULL, `totalCalories` REAL NOT NULL, `totalProtein` REAL NOT NULL, `totalCarbs` REAL NOT NULL, `totalFat` REAL NOT NULL, `isSynced` INTEGER NOT NULL, `totalFiber` REAL NOT NULL, `totalSugar` REAL NOT NULL, `totalSodium` REAL NOT NULL, `totalPotassium` REAL NOT NULL, `totalCalcium` REAL NOT NULL, `totalIron` REAL NOT NULL, `totalVitaminC` REAL NOT NULL, `totalVitaminD` REAL NOT NULL, `rawTextInput` TEXT, `isAiLogged` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `bookmarked_meals` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `totalCalories` REAL NOT NULL, `totalProtein` REAL NOT NULL, `totalCarbs` REAL NOT NULL, `totalFat` REAL NOT NULL, `itemsData` TEXT NOT NULL, `createdAt` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `weight_logs` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `weightKg` REAL NOT NULL, `dateStr` TEXT NOT NULL, `timestamp` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `water_logs` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `glasses` INTEGER NOT NULL, `dateStr` TEXT NOT NULL, `timestamp` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '03fe41fc383cd2670ccf78fc81833beb')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `meals`");
        db.execSQL("DROP TABLE IF EXISTS `bookmarked_meals`");
        db.execSQL("DROP TABLE IF EXISTS `weight_logs`");
        db.execSQL("DROP TABLE IF EXISTS `water_logs`");
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
        final HashMap<String, TableInfo.Column> _columnsMeals = new HashMap<String, TableInfo.Column>(19);
        _columnsMeals.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeals.put("mealType", new TableInfo.Column("mealType", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeals.put("imageUrl", new TableInfo.Column("imageUrl", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeals.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeals.put("totalCalories", new TableInfo.Column("totalCalories", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeals.put("totalProtein", new TableInfo.Column("totalProtein", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeals.put("totalCarbs", new TableInfo.Column("totalCarbs", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeals.put("totalFat", new TableInfo.Column("totalFat", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeals.put("isSynced", new TableInfo.Column("isSynced", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeals.put("totalFiber", new TableInfo.Column("totalFiber", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeals.put("totalSugar", new TableInfo.Column("totalSugar", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeals.put("totalSodium", new TableInfo.Column("totalSodium", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeals.put("totalPotassium", new TableInfo.Column("totalPotassium", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeals.put("totalCalcium", new TableInfo.Column("totalCalcium", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeals.put("totalIron", new TableInfo.Column("totalIron", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeals.put("totalVitaminC", new TableInfo.Column("totalVitaminC", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeals.put("totalVitaminD", new TableInfo.Column("totalVitaminD", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeals.put("rawTextInput", new TableInfo.Column("rawTextInput", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMeals.put("isAiLogged", new TableInfo.Column("isAiLogged", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMeals = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMeals = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMeals = new TableInfo("meals", _columnsMeals, _foreignKeysMeals, _indicesMeals);
        final TableInfo _existingMeals = TableInfo.read(db, "meals");
        if (!_infoMeals.equals(_existingMeals)) {
          return new RoomOpenHelper.ValidationResult(false, "meals(com.calorie.tracker.feature_journal.data.local.MealEntity).\n"
                  + " Expected:\n" + _infoMeals + "\n"
                  + " Found:\n" + _existingMeals);
        }
        final HashMap<String, TableInfo.Column> _columnsBookmarkedMeals = new HashMap<String, TableInfo.Column>(8);
        _columnsBookmarkedMeals.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBookmarkedMeals.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBookmarkedMeals.put("totalCalories", new TableInfo.Column("totalCalories", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBookmarkedMeals.put("totalProtein", new TableInfo.Column("totalProtein", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBookmarkedMeals.put("totalCarbs", new TableInfo.Column("totalCarbs", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBookmarkedMeals.put("totalFat", new TableInfo.Column("totalFat", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBookmarkedMeals.put("itemsData", new TableInfo.Column("itemsData", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBookmarkedMeals.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBookmarkedMeals = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBookmarkedMeals = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBookmarkedMeals = new TableInfo("bookmarked_meals", _columnsBookmarkedMeals, _foreignKeysBookmarkedMeals, _indicesBookmarkedMeals);
        final TableInfo _existingBookmarkedMeals = TableInfo.read(db, "bookmarked_meals");
        if (!_infoBookmarkedMeals.equals(_existingBookmarkedMeals)) {
          return new RoomOpenHelper.ValidationResult(false, "bookmarked_meals(com.calorie.tracker.feature_journal.data.local.BookmarkedMealEntity).\n"
                  + " Expected:\n" + _infoBookmarkedMeals + "\n"
                  + " Found:\n" + _existingBookmarkedMeals);
        }
        final HashMap<String, TableInfo.Column> _columnsWeightLogs = new HashMap<String, TableInfo.Column>(4);
        _columnsWeightLogs.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWeightLogs.put("weightKg", new TableInfo.Column("weightKg", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWeightLogs.put("dateStr", new TableInfo.Column("dateStr", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWeightLogs.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWeightLogs = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesWeightLogs = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoWeightLogs = new TableInfo("weight_logs", _columnsWeightLogs, _foreignKeysWeightLogs, _indicesWeightLogs);
        final TableInfo _existingWeightLogs = TableInfo.read(db, "weight_logs");
        if (!_infoWeightLogs.equals(_existingWeightLogs)) {
          return new RoomOpenHelper.ValidationResult(false, "weight_logs(com.calorie.tracker.feature_journal.data.local.WeightEntity).\n"
                  + " Expected:\n" + _infoWeightLogs + "\n"
                  + " Found:\n" + _existingWeightLogs);
        }
        final HashMap<String, TableInfo.Column> _columnsWaterLogs = new HashMap<String, TableInfo.Column>(4);
        _columnsWaterLogs.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWaterLogs.put("glasses", new TableInfo.Column("glasses", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWaterLogs.put("dateStr", new TableInfo.Column("dateStr", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWaterLogs.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWaterLogs = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesWaterLogs = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoWaterLogs = new TableInfo("water_logs", _columnsWaterLogs, _foreignKeysWaterLogs, _indicesWaterLogs);
        final TableInfo _existingWaterLogs = TableInfo.read(db, "water_logs");
        if (!_infoWaterLogs.equals(_existingWaterLogs)) {
          return new RoomOpenHelper.ValidationResult(false, "water_logs(com.calorie.tracker.feature_journal.data.local.WaterEntity).\n"
                  + " Expected:\n" + _infoWaterLogs + "\n"
                  + " Found:\n" + _existingWaterLogs);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "03fe41fc383cd2670ccf78fc81833beb", "9d3cd5d89570d2b29c90e4ed26fb280d");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "meals","bookmarked_meals","weight_logs","water_logs");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `meals`");
      _db.execSQL("DELETE FROM `bookmarked_meals`");
      _db.execSQL("DELETE FROM `weight_logs`");
      _db.execSQL("DELETE FROM `water_logs`");
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
    _typeConvertersMap.put(MealDao.class, MealDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(BookmarkedMealDao.class, BookmarkedMealDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(WeightDao.class, WeightDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(WaterDao.class, WaterDao_Impl.getRequiredConverters());
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
  public MealDao mealDao() {
    if (_mealDao != null) {
      return _mealDao;
    } else {
      synchronized(this) {
        if(_mealDao == null) {
          _mealDao = new MealDao_Impl(this);
        }
        return _mealDao;
      }
    }
  }

  @Override
  public BookmarkedMealDao bookmarkedMealDao() {
    if (_bookmarkedMealDao != null) {
      return _bookmarkedMealDao;
    } else {
      synchronized(this) {
        if(_bookmarkedMealDao == null) {
          _bookmarkedMealDao = new BookmarkedMealDao_Impl(this);
        }
        return _bookmarkedMealDao;
      }
    }
  }

  @Override
  public WeightDao weightDao() {
    if (_weightDao != null) {
      return _weightDao;
    } else {
      synchronized(this) {
        if(_weightDao == null) {
          _weightDao = new WeightDao_Impl(this);
        }
        return _weightDao;
      }
    }
  }

  @Override
  public WaterDao waterDao() {
    if (_waterDao != null) {
      return _waterDao;
    } else {
      synchronized(this) {
        if(_waterDao == null) {
          _waterDao = new WaterDao_Impl(this);
        }
        return _waterDao;
      }
    }
  }
}
