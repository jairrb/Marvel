package com.manamob.marvel.data.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.manamob.marvel.data.database.dao.ComicsDao;
import com.manamob.marvel.model.Comics;

@androidx.room.Database(entities = {Comics.class}, version = 6, exportSchema = false)
@TypeConverters(Converters.class)

public abstract class DataBase extends RoomDatabase {
    private static volatile DataBase INSTANCE;
    public abstract ComicsDao comicsDao();

    public static DataBase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (DataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, DataBase.class, "my_db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}