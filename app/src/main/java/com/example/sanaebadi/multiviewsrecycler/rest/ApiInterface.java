package com.example.sanaebadi.multiviewsrecycler.rest;

import com.example.sanaebadi.multiviewsrecycler.model.Food;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by sanaebadi on 3/22/18.
 */

public interface ApiInterface {

  @POST("get-food-data.php")
  Call<List<Food>> getFood();

}
