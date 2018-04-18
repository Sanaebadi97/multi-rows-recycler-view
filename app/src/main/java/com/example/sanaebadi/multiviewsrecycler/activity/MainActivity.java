package com.example.sanaebadi.multiviewsrecycler.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.example.sanaebadi.multiviewsrecycler.R;
import com.example.sanaebadi.multiviewsrecycler.adapter.FoodAdapter;
import com.example.sanaebadi.multiviewsrecycler.model.Food;
import com.example.sanaebadi.multiviewsrecycler.rest.ApiClient;
import com.example.sanaebadi.multiviewsrecycler.rest.ApiInterface;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends BaseActivity {

  private static final String TAG = "MainActivity";

  private ApiInterface apiInterface;
  private Call<List<Food>> foodCall;

  @BindView(R.id.food_list)
  RecyclerView food_list;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // bind the view using butterKnife
    ButterKnife.bind(this);

    getData();


    food_list.setLayoutManager(new LinearLayoutManager(MainActivity.this,
      LinearLayoutManager.VERTICAL, false));
    food_list.setItemAnimator(new DefaultItemAnimator());
    food_list.hasFixedSize();
    food_list.setFitsSystemWindows(true);
    food_list.setItemViewCacheSize(20);
    food_list.setDrawingCacheEnabled(true);
    food_list.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_LOW);

  }


  //get data from retrofit
  private void getData() {

    apiInterface = ApiClient.createApi();
    foodCall = apiInterface.getFood();

    foodCall.enqueue(new Callback<List<Food>>() {
      @Override
      public void onResponse(Call<List<Food>> call, Response<List<Food>> response) {

        List<Food> foodList = response.body();
        FoodAdapter foodAdapter = new FoodAdapter(MainActivity.this, foodList);
        food_list.setAdapter(foodAdapter);
      }

      @Override
      public void onFailure(Call<List<Food>> call, Throwable t) {
        Log.e(TAG, "FoodOnFailure: " + t.getMessage());
        Toast.makeText(MainActivity.this, "onFailure: " + t.getMessage(), Toast.LENGTH_SHORT).show();
      }
    });
  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.main_menu, menu);
    return super.onCreateOptionsMenu(menu);
  }



}
