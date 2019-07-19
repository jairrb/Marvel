package com.manamob.marvel.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.manamob.marvel.R;
import com.manamob.marvel.adapters.RecyclerViewMarvelAdapter;
import com.manamob.marvel.model.Result;
import com.manamob.marvel.viewmodel.ComicsViewModel;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView recyclerViewComics;
    private ComicsViewModel comicsViewModel;
    private RecyclerViewMarvelAdapter adapter;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Init Views
        initViews();

        comicsViewModel.getComics();

        //Observable Update Recycler
        comicsViewModel.getComicsLiveData()
                .observe(this, comics -> adapter.update(comics));

        //Observable Loading
        comicsViewModel.getLoadingLiveData()
                .observe(this, isLoading -> {
                    if (isLoading) {
                        progressBar.setVisibility(View.VISIBLE);
                    } else {
                        progressBar.setVisibility(View.GONE);
                    }
                });

        //Observable Error
        comicsViewModel.getErrorLiveData()
                .observe(this, throwable -> {
                    Snackbar.make(recyclerViewComics, throwable.getMessage(),Snackbar.LENGTH_SHORT).show();
                });
    }

    /*
        Funtion to initialize Views
    */
    private void initViews() {
        //ViewModel
        comicsViewModel = ViewModelProviders.of(this).get(ComicsViewModel.class);

        //Views
        recyclerViewComics = findViewById(R.id.recyclerViewComics);
        progressBar = findViewById(R.id.progressBar);

        //Adapter
        adapter = new RecyclerViewMarvelAdapter(new ArrayList<>());

        recyclerViewComics.setHasFixedSize(true);
        recyclerViewComics.setItemViewCacheSize(20);
        recyclerViewComics.setAdapter(adapter);
        recyclerViewComics.setLayoutManager(new GridLayoutManager(this, 3));


    }

    /*
        Funtion to initialize Views
    */
    public void onItemClick(Result result){
        Intent intent = new Intent(getApplication().getApplicationContext(),DetailActivity.class);
        intent.putExtra("COMIC",result);
        startActivity(intent);
    }
}
