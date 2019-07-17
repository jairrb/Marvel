package com.manamob.marvel.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.manamob.marvel.data.database.DataBase;
import com.manamob.marvel.data.database.dao.ComicsDao;
import com.manamob.marvel.model.Comics;
import com.manamob.marvel.model.ComicsResponse;
import com.manamob.marvel.repository.MarvelRepository;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import static com.manamob.marvel.util.AppUtil.isNetworkConnected;

public class ComicsViewModel extends AndroidViewModel {
    private MutableLiveData<List<Comics>> comicsLiveData = new MutableLiveData<>();
    private MutableLiveData<Throwable> errorLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> loadingLiveData = new MutableLiveData<>();

    private CompositeDisposable disposable = new CompositeDisposable();
    private MarvelRepository repository = new MarvelRepository();

    public ComicsViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Comics>> getComicsLiveData() {
        return comicsLiveData;
    }

    public LiveData<Boolean> getLoadingLiveData() {
        return loadingLiveData;
    }

    public LiveData<Throwable> getErrorLiveData() {
        return errorLiveData;
    }


    public void searchComics() {
        if (isNetworkConnected(getApplication())) {
            getApiCharacter();
        } else {
            getLocalCharacter();
        }
    }

    private void getLocalCharacter() {
        disposable.add(
                repository.getComicsLocal(getApplication().getApplicationContext())
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable1 -> loadingLiveData.setValue(false))
                        .doAfterTerminate(() -> loadingLiveData.setValue(false))
                        .subscribe(comicsList -> comicsLiveData.setValue(comicsList)
                                , throwable -> errorLiveData.setValue(throwable))
        );
    }

    private void getApiCharacter() {
        disposable.add(
                repository.getComicsApi()
                        .subscribeOn(Schedulers.newThread())
                        .map(comicsResponse -> saveItems(comicsResponse))
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable1 -> loadingLiveData.setValue(true))
                        .doAfterTerminate(() -> loadingLiveData.setValue(false))
                        .subscribe(comicsResponse -> comicsLiveData.setValue(comicsResponse.getData().getComics())
                                , throwable -> errorLiveData.setValue(throwable))
        );
    }

    private ComicsResponse saveItems(ComicsResponse comicsResponse) {
        ComicsDao comicsDao = DataBase.getDatabase(getApplication()
                .getApplicationContext())
                .comicsDao();

        comicsDao.insertAll(comicsResponse.getData().getComics());
        return comicsResponse;
    }

    // Limpa as chamadas que fizemos no RX
    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}