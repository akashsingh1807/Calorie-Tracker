package com.calorie.tracker.feature_journal.data.local;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class WaterDao_Impl implements WaterDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<WaterEntity> __insertionAdapterOfWaterEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteWaterLog;

  public WaterDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfWaterEntity = new EntityInsertionAdapter<WaterEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `water_logs` (`id`,`glasses`,`dateStr`,`timestamp`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @Nullable final WaterEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getGlasses());
        if (entity.getDateStr() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDateStr());
        }
        statement.bindLong(4, entity.getTimestamp());
      }
    };
    this.__preparedStmtOfDeleteWaterLog = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM water_logs WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertWaterLog(final WaterEntity waterEntity,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfWaterEntity.insert(waterEntity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteWaterLog(final long id, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteWaterLog.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteWaterLog.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<WaterEntity>> getAllWaterLogs() {
    final String _sql = "SELECT * FROM water_logs ORDER BY timestamp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"water_logs"}, new Callable<List<WaterEntity>>() {
      @Override
      @NonNull
      public List<WaterEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfGlasses = CursorUtil.getColumnIndexOrThrow(_cursor, "glasses");
          final int _cursorIndexOfDateStr = CursorUtil.getColumnIndexOrThrow(_cursor, "dateStr");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final List<WaterEntity> _result = new ArrayList<WaterEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final WaterEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final int _tmpGlasses;
            _tmpGlasses = _cursor.getInt(_cursorIndexOfGlasses);
            final String _tmpDateStr;
            if (_cursor.isNull(_cursorIndexOfDateStr)) {
              _tmpDateStr = null;
            } else {
              _tmpDateStr = _cursor.getString(_cursorIndexOfDateStr);
            }
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            _item = new WaterEntity(_tmpId,_tmpGlasses,_tmpDateStr,_tmpTimestamp);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<WaterEntity> getWaterLogByDate(final String dateStr) {
    final String _sql = "SELECT * FROM water_logs WHERE dateStr = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (dateStr == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, dateStr);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"water_logs"}, new Callable<WaterEntity>() {
      @Override
      @Nullable
      public WaterEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfGlasses = CursorUtil.getColumnIndexOrThrow(_cursor, "glasses");
          final int _cursorIndexOfDateStr = CursorUtil.getColumnIndexOrThrow(_cursor, "dateStr");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final WaterEntity _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final int _tmpGlasses;
            _tmpGlasses = _cursor.getInt(_cursorIndexOfGlasses);
            final String _tmpDateStr;
            if (_cursor.isNull(_cursorIndexOfDateStr)) {
              _tmpDateStr = null;
            } else {
              _tmpDateStr = _cursor.getString(_cursorIndexOfDateStr);
            }
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            _result = new WaterEntity(_tmpId,_tmpGlasses,_tmpDateStr,_tmpTimestamp);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
