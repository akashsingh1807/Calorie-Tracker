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
import java.lang.Integer;
import java.lang.Long;
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
public final class BookmarkedMealDao_Impl implements BookmarkedMealDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<BookmarkedMealEntity> __insertionAdapterOfBookmarkedMealEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteBookmark;

  public BookmarkedMealDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBookmarkedMealEntity = new EntityInsertionAdapter<BookmarkedMealEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `bookmarked_meals` (`id`,`name`,`totalCalories`,`totalProtein`,`totalCarbs`,`totalFat`,`itemsData`,`createdAt`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @Nullable final BookmarkedMealEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        statement.bindDouble(3, entity.getTotalCalories());
        statement.bindDouble(4, entity.getTotalProtein());
        statement.bindDouble(5, entity.getTotalCarbs());
        statement.bindDouble(6, entity.getTotalFat());
        if (entity.getItemsData() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getItemsData());
        }
        statement.bindLong(8, entity.getCreatedAt());
      }
    };
    this.__preparedStmtOfDeleteBookmark = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM bookmarked_meals WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertBookmark(final BookmarkedMealEntity meal,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfBookmarkedMealEntity.insertAndReturnId(meal);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteBookmark(final long id, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteBookmark.acquire();
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
          __preparedStmtOfDeleteBookmark.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<BookmarkedMealEntity>> getAllBookmarks() {
    final String _sql = "SELECT * FROM bookmarked_meals ORDER BY createdAt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"bookmarked_meals"}, new Callable<List<BookmarkedMealEntity>>() {
      @Override
      @NonNull
      public List<BookmarkedMealEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfTotalCalories = CursorUtil.getColumnIndexOrThrow(_cursor, "totalCalories");
          final int _cursorIndexOfTotalProtein = CursorUtil.getColumnIndexOrThrow(_cursor, "totalProtein");
          final int _cursorIndexOfTotalCarbs = CursorUtil.getColumnIndexOrThrow(_cursor, "totalCarbs");
          final int _cursorIndexOfTotalFat = CursorUtil.getColumnIndexOrThrow(_cursor, "totalFat");
          final int _cursorIndexOfItemsData = CursorUtil.getColumnIndexOrThrow(_cursor, "itemsData");
          final int _cursorIndexOfCreatedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "createdAt");
          final List<BookmarkedMealEntity> _result = new ArrayList<BookmarkedMealEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final BookmarkedMealEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final double _tmpTotalCalories;
            _tmpTotalCalories = _cursor.getDouble(_cursorIndexOfTotalCalories);
            final double _tmpTotalProtein;
            _tmpTotalProtein = _cursor.getDouble(_cursorIndexOfTotalProtein);
            final double _tmpTotalCarbs;
            _tmpTotalCarbs = _cursor.getDouble(_cursorIndexOfTotalCarbs);
            final double _tmpTotalFat;
            _tmpTotalFat = _cursor.getDouble(_cursorIndexOfTotalFat);
            final String _tmpItemsData;
            if (_cursor.isNull(_cursorIndexOfItemsData)) {
              _tmpItemsData = null;
            } else {
              _tmpItemsData = _cursor.getString(_cursorIndexOfItemsData);
            }
            final long _tmpCreatedAt;
            _tmpCreatedAt = _cursor.getLong(_cursorIndexOfCreatedAt);
            _item = new BookmarkedMealEntity(_tmpId,_tmpName,_tmpTotalCalories,_tmpTotalProtein,_tmpTotalCarbs,_tmpTotalFat,_tmpItemsData,_tmpCreatedAt);
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
  public Object countByName(final String name, final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM bookmarked_meals WHERE name = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (name == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, name);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
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
