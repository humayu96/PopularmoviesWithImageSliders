package com.example.popularmovieswithimagesliders;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity implements MovieItemClickListener {

    private List<SlideItems> slideItems;
    private ViewPager slide_viewPager;

    private TabLayout tabLayout;

    RecyclerView recyclerView;

    MovieAdopter movieAdopter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        slide_viewPager = findViewById(R.id.slider_page);
        tabLayout = findViewById(R.id.tab_layout_indicator);
        recyclerView = findViewById(R.id.recycler_movie);

        slideItems = new ArrayList<>();

        slideItems.add(new SlideItems(R.drawable.kingsman , "KingsMan The Golden Circle"));
        slideItems.add(new SlideItems(R.drawable.maxresdefault , "Mad Max"));
        slideItems.add(new SlideItems(R.drawable.deadpoolbullets , "Dead Pool"));
        slideItems.add(new SlideItems(R.drawable.fast , "Fast And Furious 9"));
        slideItems.add(new SlideItems(R.drawable.equalizer , "The Equalizer 2"));


        SlidePageAdapter adapter = new SlidePageAdapter(this,slideItems);
        slide_viewPager.setAdapter(adapter);

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new MainActivity.SliderTimer(),3000,4000);

        tabLayout.setupWithViewPager(slide_viewPager,true);

        List<Movies> listof_movies = new ArrayList<>();
        listof_movies.add(new Movies("DeadPool",R.drawable.deadpoolbullets));
        listof_movies.add(new Movies("The Equalizer 2",R.drawable.venom));
        listof_movies.add(new Movies("Mad Max",R.drawable.venom));
        listof_movies.add(new Movies("KingsMan The Golden Circle",R.drawable.venom));
        listof_movies.add(new Movies("DeadPool",R.drawable.venom));

        movieAdopter = new MovieAdopter(this,listof_movies,this);
        recyclerView.setAdapter(movieAdopter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));




    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onMovieClick(Movies movies, ImageView movieimagemovieI) {

        Intent intent = new Intent(this,MovieDetail.class);
        intent.putExtra("TITLE",movies.getTitle());
        intent.putExtra("ImageURl",movies.getThumbnail());
//        startActivity(intent);

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,

                                                            movieimagemovieI,"shared");

        startActivity(intent,options.toBundle());



    }

    class SliderTimer extends TimerTask{

        @Override
        public void run() {

            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(slide_viewPager.getCurrentItem() < slideItems.size() -1){
                        slide_viewPager.setCurrentItem(slide_viewPager.getCurrentItem()+1);

                    }
                    else {
                        slide_viewPager.setCurrentItem(0);

                    }
                }

            });

        }
    }
}
