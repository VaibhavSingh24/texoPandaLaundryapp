package com.example.texopandalaundryapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class slideAdapter extends PagerAdapter{

    Context context;
    LayoutInflater layoutInflater;

    public slideAdapter(Context context) {
        this.context = context;
    }

    public int[] sliderImages =
            {
                    R.drawable.ic_launcher_background,
                    R.drawable.ic_launcher_background,
                    R.drawable.ic_launcher_background,
                    R.drawable.ic_launcher_background

            };
    public String[] sliderHeadings =
            {
                    "Heading 1",
                    "Heading 2",
                    "Heading 3",
                    "Heading 4"

            };

    public String[] sliderDescription =
            {
                    "Some  text here",
                    "Some  text here",
                    "Some  text here",
                    "Some  text here"


            };

    @Override
    public int getCount() {
        return sliderHeadings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slides,container,false);

        ImageView slider_img = (ImageView) view.findViewById(R.id.introImg1);
        TextView headings = (TextView) view.findViewById(R.id.heading);
        TextView para = (TextView) view.findViewById(R.id.parag);

        slider_img.setImageResource(sliderImages[position]);
        headings.setText(sliderHeadings[position]);
        para.setText(sliderDescription[position]);

        container.addView(view);


        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}

