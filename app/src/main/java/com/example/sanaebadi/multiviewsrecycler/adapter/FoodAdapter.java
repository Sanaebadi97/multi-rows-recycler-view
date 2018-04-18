package com.example.sanaebadi.multiviewsrecycler.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sanaebadi.multiviewsrecycler.R;
import com.example.sanaebadi.multiviewsrecycler.activity.FirstDetailsActivity;
import com.example.sanaebadi.multiviewsrecycler.activity.SecondDetailsActivity;
import com.example.sanaebadi.multiviewsrecycler.model.Food;

import java.util.List;

/**
 * Created by sanaebadi on 4/12/18.
 */

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.CustomViewHolder> {

  private static final int TYPE_FIRST = 0;
  private static final int TYPE_SEC = 1;

  public Context context;
  private List<Food> foodList;

  public FoodAdapter(Context context, List<Food> foodList) {
    this.context = context;
    this.foodList = foodList;
  }


  @Override
  public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    if (viewType == TYPE_FIRST) {
      View view = LayoutInflater.from(context)
        .inflate(R.layout.first_item_single, parent, false);
      return new CustomViewHolder(view, viewType);

    } else if (viewType == TYPE_SEC) {
      View view = LayoutInflater.from(context)
        .inflate(R.layout.second_item_single, parent, false);
      return new CustomViewHolder(view, viewType);
    }


    return null;
  }

  @Override
  public void onBindViewHolder(CustomViewHolder holder, int position) {

    final Food food = foodList.get(position);

    if (holder.hoderId == 1) {

      Glide.with(context)
        .load(food.getFood_image())
        .into(holder.img_food_first);


      holder.txt_res_name_first.setText(food.getRestaurant_name());
      holder.txt_res_kind_first.setText(food.getRestaurant_kind());
      holder.txt_res_rink_first.setText("امتیاز : " + String.valueOf(food.getRank()));


      holder.lay_photo_first.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

          Intent intent = new Intent(context, FirstDetailsActivity.class);
          intent.putExtra("PHOTO", food.getFood_image());
          intent.putExtra("NAME", food.getRestaurant_name());
          intent.putExtra("KIND", food.getRestaurant_kind());
          intent.putExtra("RANK", food.getRank());
          intent.putExtra("DESC", food.getDesc());
          context.startActivity(intent);
        }
      });

    } else {

      Glide.with(context)
        .load(food.getFood_image())
        .into(holder.img_food_sec);

      holder.txt_res_name_sec.setText(food.getRestaurant_name());
      holder.txt_res_kind_sec.setText(food.getRestaurant_kind());
      holder.txt_res_rink_sec.setText("امتیاز : " + String.valueOf(food.getRank()));

      holder.lay_photo_second.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          Intent intent = new Intent(context, SecondDetailsActivity.class);
          intent.putExtra("PHOTO", food.getFood_image());
          intent.putExtra("NAME", food.getRestaurant_name());
          intent.putExtra("KIND", food.getRestaurant_kind());
          intent.putExtra("RANK", food.getRank());
          intent.putExtra("RANK", food.getRank());
          intent.putExtra("DESC", food.getDesc());
          context.startActivity(intent);
        }
      });

    }

  }

  @Override
  public int getItemCount() {
    return foodList.size();
  }


  class CustomViewHolder extends RecyclerView.ViewHolder {

    private int hoderId;
    private ImageView img_food_first, img_food_sec;
    private TextView txt_res_name_first, txt_res_kind_first, txt_res_rink_first,
      txt_res_name_sec, txt_res_kind_sec, txt_res_rink_sec;
    private RelativeLayout lay_photo_first, lay_photo_second;


    public CustomViewHolder(View itemView, int viewType) {
      super(itemView);

      if (viewType == TYPE_FIRST) {
        img_food_first = itemView.findViewById(R.id.img_food_first);
        txt_res_name_first = itemView.findViewById(R.id.txt_res_name_first);
        txt_res_kind_first = itemView.findViewById(R.id.txt_res_kind_first);
        txt_res_rink_first = itemView.findViewById(R.id.txt_res_rink_first);
        lay_photo_first = itemView.findViewById(R.id.lay_photo_first);
        hoderId = 1;

      } else {

        img_food_sec = itemView.findViewById(R.id.img_food_sec);
        txt_res_name_sec = itemView.findViewById(R.id.txt_res_name_sec);
        txt_res_kind_sec = itemView.findViewById(R.id.txt_res_kind_sec);
        txt_res_rink_sec = itemView.findViewById(R.id.txt_res_rink_sec);
        lay_photo_second = itemView.findViewById(R.id.lay_photo_sec);
        hoderId = 0;
      }
    }
  }


  @Override
  public int getItemViewType(int position) {
    if (position % 2 == 0) {
      return TYPE_FIRST;
    } else {
      return TYPE_SEC;
    }
  }

  private boolean isPositionHeader(int position) {
    return position == 0;
  }


  @Override
  public long getItemId(int position) {
    return position;
  }


}
