package com.example.sanaebadi.multiviewsrecycler.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sanaebadi.multiviewsrecycler.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FirstDetailsActivity extends BaseActivity {


  @BindView(R.id.img_food)
  ImageView img_food;

  @BindView(R.id.txt_name)
  TextView txt_name;

  @BindView(R.id.ratingBar_view)
  ProgressBar ratingBar_view;

  @BindView(R.id.txt_desc)
  TextView txt_desc;

  private String imageUrl, txtname, txtDesc;
  private int rank;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_details_first);

    ButterKnife.bind(this);

    ratingBar_view.getProgressDrawable().setColorFilter(
      Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);

    Intent intent = getIntent();

    imageUrl = intent.getStringExtra("PHOTO");
    txtname = intent.getStringExtra("NAME");
    rank = intent.getIntExtra("RANK", 0);
    txtDesc = intent.getStringExtra("DESC");


    Glide.with(this).load(imageUrl)
      .into(img_food);

    txt_name.setText(txtname);
    ratingBar_view.setProgress(rank);
    txt_desc.setText(txtDesc);

  }
}
