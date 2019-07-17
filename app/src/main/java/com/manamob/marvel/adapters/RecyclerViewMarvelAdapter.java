package com.manamob.marvel.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.manamob.marvel.R;
import com.manamob.marvel.interfaces.RecyclerViewClickListener;
import com.manamob.marvel.model.Comics;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewMarvelAdapter extends RecyclerView.Adapter<RecyclerViewMarvelAdapter.ViewHolder> {
    private List<Comics> comicsList;
    private RecyclerViewClickListener listener;

    public RecyclerViewMarvelAdapter(List<Comics> comics) {
        this.comicsList = comics;
    }

    @NonNull
    @Override
    public RecyclerViewMarvelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.recyclerview_comics_item,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final Comics comics =  comicsList.get(position);
        viewHolder.bind(comics);
        viewHolder.itemView.setOnClickListener(v -> listener.onItemClick(comics));

    }

    @Override
    public int getItemCount() {
        return comicsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageViewComic;
        private TextView textViewNumber;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            imageViewComic = itemView.findViewById(R.id.imageViewComic);
            textViewNumber = itemView.findViewById(R.id.textViewNumber);
        }

        public void bind(Comics comics){
            Picasso
                    .get()
                    .load(comics.getThumbnail().getPath()+"/portrait_incredible."+comics.getThumbnail().getExtension())
                    .placeholder(R.drawable.marvel_logo)
                    .error(R.drawable.marvel_logo)
                    .into(imageViewComic);
            textViewNumber.setText("# "+comics.getIssueNumber());
        }
    }
}
