package com.manamob.marvel.data.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.manamob.marvel.model.Result;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface ComicsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Result result);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Result> resultList);

    @Update
    void update(Result result);


    @Query("SELECT * FROM comics limit 50")
    List<Result> getAll();

    @Query("SELECT * FROM  comics limit 50")
    Flowable<List<Result>> getAllRxJava();

}
