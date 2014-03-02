package com.levibostian.pantrypirate.model;

import com.levibostian.pantrypirate.R;
import com.levibostian.pantrypirate.vo.FoodItem;

import java.util.ArrayList;

public class InventoryModel {
    private ArrayList<FoodItem> mInventory;

    public InventoryModel() {
        mInventory = new ArrayList<FoodItem>();

        setUpInventory();
    }

    private void setUpInventory() {
        mInventory.add(new FoodItem("Beets", R.drawable.beets));
        mInventory.add(new FoodItem("Chicken", R.drawable.chicken));
        mInventory.add(new FoodItem("Lettuce", R.drawable.lettuce));
        mInventory.add(new FoodItem("Pineapple", R.drawable.pineapple));
        mInventory.add(new FoodItem("Yogurt", R.drawable.yogurt));
        mInventory.add(new FoodItem("Apple Sauce", R.drawable.apple_sauce));
        mInventory.add(new FoodItem("Crackers", R.drawable.crackers));
        mInventory.add(new FoodItem("Spaghetti noodles", R.drawable.noodles));
        mInventory.add(new FoodItem("Can of Peas", R.drawable.peas));
        mInventory.add(new FoodItem("Cream corn", R.drawable.corn));
    }

    public ArrayList<FoodItem> getInventory() {
        return mInventory;
    }

    public FoodItem getFoodItem(int position) {
        return mInventory.get(position);
    }
}
