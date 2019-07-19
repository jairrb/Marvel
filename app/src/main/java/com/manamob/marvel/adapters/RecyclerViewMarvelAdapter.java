package com.manamob.marvel.adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.manamob.marvel.R;
import com.manamob.marvel.model.Result;
import com.manamob.marvel.view.DetailActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewMarvelAdapter extends RecyclerView.Adapter<RecyclerViewMarvelAdapter.ViewHolder> {
    private List<Result> resultList;

    //Constructor
    public RecyclerViewMarvelAdapter(List<Result> resultList) {
        this.resultList = resultList;
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.recyclerview_comics_item, viewGroup, false);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final Result result = resultList.get(position);
        viewHolder.bind(result);

        viewHolder.itemView.setOnClickListener(v -> {
            String transitionName = "image_" + position;
            Intent intent = new Intent(viewHolder.itemView.getContext(), DetailActivity.class);
            intent.putExtra("COMIC", result);
            intent.putExtra("TRANSITIONNAME", transitionName);

            viewHolder.imageViewComic.setTransitionName(transitionName);

            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat
                    .makeSceneTransitionAnimation((Activity) viewHolder.itemView.getContext(),
                            viewHolder.imageViewComic, transitionName);

            viewHolder.itemView.getContext().startActivity(intent,optionsCompat.toBundle());

        });
    }


    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewComic;
        private TextView textViewNumber;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewComic = itemView.findViewById(R.id.imageViewComic);
            textViewNumber = itemView.findViewById(R.id.textViewNumber);
        }

        public void bind(Result result) {
            Picasso
                    .get()
                    .load(result.getThumbnail().getPath() + "/portrait_incredible." + result.getThumbnail().getExtension())
                    .placeholder(R.drawable.marvel_logo)
                    .error(R.drawable.marvel_logo)
                    .into(imageViewComic);

            textViewNumber.setText("# " + result.getIssueNumber());
        }
    }

    public void update(List<Result> resultList) {
        if (resultList != null) {
            this.resultList = resultList;
            notifyDataSetChanged();
        }
    }
}