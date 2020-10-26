package com.pvt.gosselin;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }
    //Arrays
    public int[] slide_images = {
      R.drawable.gosselinnotext,
      R.drawable.lap,
      R.drawable.howl,
    };
    public String[] slide_headings = {
      "Moving with Gosselin",
      "What we move",
      "How we move"
    };
    public String[] slide_descs = {
      "Ask for a free quote, book your move, pay secure, track your household goods. Your international move in 1 easy to use app. Let’s get moving!"+
              "\n",
            "We move just about anything. But it goes without saying that you want more details before handing us over your most valuable possessions. Below are categories of what we move and how we do it. Feel free to browse through them or ask us anything about categories we didn’t display."+
                    "We also move just about anybody. Expats, private persons, diplomats, military personnel and their families. Moving with kids can be quite challenging. We will tailor our services to your specific needs and wishes. ",
            "Gosselin has been moving people internationally since the 1930's. If your place of departure or destination is anywhere in Europe, count on us. "+
                    "\n"
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == (RelativeLayout) o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);
        ImageView slideImageView = (ImageView) view.findViewById(R.id.slideimageView);
        TextView slideHeading = (TextView) view.findViewById(R.id.title);
        TextView slideDescription = (TextView) view.findViewById(R.id.despo);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_descs[position]);

        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position,Object object) {
        container.removeView((RelativeLayout)object);
    }
}
