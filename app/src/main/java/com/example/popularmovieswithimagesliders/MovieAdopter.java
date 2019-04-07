package com.example.popularmovieswithimagesliders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MovieAdopter extends RecyclerView.Adapter<MovieAdopter.MoviewViewHolder> {

    Context context;
    List<Movies>listmovies;
    MovieItemClickListener movieItemClickListener;

    public MovieAdopter(Context context, List<Movies> listmovies , MovieItemClickListener listener) {
        this.context = context;
        this.listmovies = listmovies;
        movieItemClickListener = listener;
    }

    @NonNull
    @Override
    public MoviewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {


        View view = LayoutInflater.from(context).inflate(R.layout.recycler_movie,viewGroup,false);

        return new MoviewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviewViewHolder moviewViewHolder, int i) {

        moviewViewHolder.textView_title.setText(listmovies.get(i).getTitle());
        moviewViewHolder.imageView.setImageResource(listmovies.get(i).getThumbnail());
    }


    @Override
    public int getItemCount() {
        return listmovies.size();
    }

    public class MoviewViewHolder extends RecyclerView.ViewHolder{


        public TextView textView_title;
        public ImageView imageView;

        public MoviewViewHolder(@NonNull View itemView) {
            super(itemView);


            textView_title = itemView.findViewById(R.id.recyler_text);
            imageView = itemView.findViewById(R.id.recycler_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    movieItemClickListener.onMovieClick(listmovies.get(getAdapterPosition()),imageView);

                }
            });


        }
    }
}
