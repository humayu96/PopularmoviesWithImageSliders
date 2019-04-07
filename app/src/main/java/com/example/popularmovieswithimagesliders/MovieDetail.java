package com.example.popularmovieswithimagesliders;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieDetail extends AppCompatActivity {

    private ImageView imageView_detail;
    private TextView textView_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);


        String movietitle = getIntent().getStringExtra("Title");

        int Image = getIntent().getExtras().getInt("ImageURl");


        imageView_detail = findViewById(R.id.image_detailmovie);

        textView_detail = findViewById(R.id.textView_detail);

        imageView_detail.setImageResource(Image);
        textView_detail.setText(movietitle);
    }
}
