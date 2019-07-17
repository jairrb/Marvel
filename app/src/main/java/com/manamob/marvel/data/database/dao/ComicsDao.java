package com.manamob.marvel.data.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.manamob.marvel.model.Comics;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface ComicsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Comics comics);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Comics> comicsList);

    @Update
    void update(Comics comics);


    @Query("SELECT * FROM comics limit 50")
    List<Comics> getAll();

    @Query("SELECT * FROM  comics limit 50")
    Flowable<List<Comics>> getAllRxJava();

}
