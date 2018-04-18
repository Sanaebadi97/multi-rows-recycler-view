package com.example.sanaebadi.multiviewsrecycler.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sanaebadi on 4/12/18.
 */

public class Food {
  @SerializedName("id")
  private int id;

  @SerializedName("food_image")
  private String food_image;

  @SerializedName("restaurant_name")
  private String restaurant_name;

  @SerializedName("restaurant_kind")
  private String restaurant_kind;

  @SerializedName("rank")
  private int rank;

  @SerializedName("desc")
  private String desc;




  public Food(int id, String food_image, String restaurant_name, String restaurant_kind, int rank, String desc) {
    this.id = id;
    this.food_image = food_image;
    this.restaurant_name = restaurant_name;
    this.restaurant_kind = restaurant_kind;
    this.rank = rank;
    this.desc = desc;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFood_image() {
    return food_image;
  }

  public void setFood_image(String food_image) {
    this.food_image = food_image;
  }

  public String getRestaurant_name() {
    return restaurant_name;
  }

  public void setRestaurant_name(String restaurant_name) {
    this.restaurant_name = restaurant_name;
  }

  public String getRestaurant_kind() {
    return restaurant_kind;
  }

  public void setRestaurant_kind(String restaurant_kind) {
    this.restaurant_kind = restaurant_kind;
  }

  public int getRank() {
    return rank;
  }

  public void setRank(int rank) {
    this.rank = rank;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }
}
