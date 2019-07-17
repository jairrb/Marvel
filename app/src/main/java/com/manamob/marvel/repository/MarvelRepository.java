package com.manamob.marvel.repository;

import android.content.Context;

import androidx.room.Database;

import com.manamob.marvel.data.database.DataBase;
import com.manamob.marvel.data.database.dao.ComicsDao;
import com.manamob.marvel.model.Comics;
import com.manamob.marvel.model.ComicsResponse;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

import static com.manamob.marvel.data.network.ApiService.PRIVATE_KEY;
import static com.manamob.marvel.data.network.ApiService.PUBLIC_KEY;
import static com.manamob.marvel.data.network.ApiService.getApiService;
import static com.manamob.marvel.util.AppUtil.md5;

public class MarvelRepository {

    public Flowable<List<Comics>> getComicsLocal(Context context){
        DataBase databaseComics = DataBase.getDatabase(context);
        ComicsDao comicsDao = databaseComics.comicsDao();
        return comicsDao.getAllRxJava();
    }

    public void insertItems(Context context, List<Comics> comics){
        DataBase databaseComics = DataBase.getDatabase(context);
        ComicsDao comicsDao = databaseComics.comicsDao();
        comicsDao.insertAll(comics);
    }

    public Single<ComicsResponse> getComicsApi(){
        String ts = Long.toString(System.currentTimeMillis()/1000);
        String hash = md5(ts+PRIVATE_KEY + PUBLIC_KEY);

        return getApiService().getComics("magazine","comic",true,"focDate","50",ts,hash,PUBLIC_KEY);
    }
}
