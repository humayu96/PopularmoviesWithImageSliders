package com.example.popularmovieswithimagesliders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SlidePageAdapter extends PagerAdapter {


    private Context context;
    private List<SlideItems> mList;


    public SlidePageAdapter(Context context, List<SlideItems> mList) {
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View slideview = inflater.inflate(R.layout.slide_item , null);

        ImageView slide_imageView = slideview.findViewById(R.id.image_view);
        TextView slide_textvie = slideview.findViewById(R.id.slider_title);


        slide_imageView.setImageResource(mList.get(position).getImage());
        slide_textvie.setText(mList.get(position).getTitle());

        container.addView(slideview);



        return slideview ;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view ==o;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View) object);
    }
}
