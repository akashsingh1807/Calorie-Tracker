package com.calorie.tracker.feature_journal.data.local;

import android.database.Cursor;
import android.os.CancellationSignal;
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
public final class WeightDao_Impl implements WeightDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<WeightEntity> __insertionAdapterOfWeightEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteWeight;

  public WeightDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfWeightEntity = new EntityInsertionAdapter<WeightEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `weight_logs` (`id`,`weightKg`,`dateStr`,`timestamp`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @Nullable final WeightEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindDouble(2, entity.getWeightKg());
        if (entity.getDateStr() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDateStr());
        }
        statement.bindLong(4, entity.getTimestamp());
      }
    };
    this.__preparedStmtOfDeleteWeight = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM weight_logs WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertWeight(final WeightEntity weightEntity,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfWeightEntity.insert(weightEntity);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteWeight(final long id, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteWeight.acquire();
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
          __preparedStmtOfDeleteWeight.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<WeightEntity>> getAllWeights() {
    final String _sql = "SELECT * FROM weight_logs ORDER BY timestamp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"weight_logs"}, new Callable<List<WeightEntity>>() {
      @Override
      @NonNull
      public List<WeightEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfWeightKg = CursorUtil.getColumnIndexOrThrow(_cursor, "weightKg");
          final int _cursorIndexOfDateStr = CursorUtil.getColumnIndexOrThrow(_cursor, "dateStr");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final List<WeightEntity> _result = new ArrayList<WeightEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final WeightEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final double _tmpWeightKg;
            _tmpWeightKg = _cursor.getDouble(_cursorIndexOfWeightKg);
            final String _tmpDateStr;
            if (_cursor.isNull(_cursorIndexOfDateStr)) {
              _tmpDateStr = null;
            } else {
              _tmpDateStr = _cursor.getString(_cursorIndexOfDateStr);
            }
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            _item = new WeightEntity(_tmpId,_tmpWeightKg,_tmpDateStr,_tmpTimestamp);
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
  public Object getLatestWeight(final Continuation<? super WeightEntity> $completion) {
    final String _sql = "SELECT * FROM weight_logs ORDER BY timestamp DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<WeightEntity>() {
      @Override
      @Nullable
      public WeightEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfWeightKg = CursorUtil.getColumnIndexOrThrow(_cursor, "weightKg");
          final int _cursorIndexOfDateStr = CursorUtil.getColumnIndexOrThrow(_cursor, "dateStr");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final WeightEntity _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final double _tmpWeightKg;
            _tmpWeightKg = _cursor.getDouble(_cursorIndexOfWeightKg);
            final String _tmpDateStr;
            if (_cursor.isNull(_cursorIndexOfDateStr)) {
              _tmpDateStr = null;
            } else {
              _tmpDateStr = _cursor.getString(_cursorIndexOfDateStr);
            }
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            _result = new WeightEntity(_tmpId,_tmpWeightKg,_tmpDateStr,_tmpTimestamp);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getWeightByDate(final String dateStr,
      final Continuation<? super WeightEntity> $completion) {
    final String _sql = "SELECT * FROM weight_logs WHERE dateStr = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (dateStr == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, dateStr);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<WeightEntity>() {
      @Override
      @Nullable
      public WeightEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfWeightKg = CursorUtil.getColumnIndexOrThrow(_cursor, "weightKg");
          final int _cursorIndexOfDateStr = CursorUtil.getColumnIndexOrThrow(_cursor, "dateStr");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final WeightEntity _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final double _tmpWeightKg;
            _tmpWeightKg = _cursor.getDouble(_cursorIndexOfWeightKg);
            final String _tmpDateStr;
            if (_cursor.isNull(_cursorIndexOfDateStr)) {
              _tmpDateStr = null;
            } else {
              _tmpDateStr = _cursor.getString(_cursorIndexOfDateStr);
            }
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            _result = new WeightEntity(_tmpId,_tmpWeightKg,_tmpDateStr,_tmpTimestamp);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
