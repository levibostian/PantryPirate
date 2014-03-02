package com.levibostian.pantrypirate.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.levibostian.pantrypirate.R;
import com.levibostian.pantrypirate.util.ImageUtil;

import java.util.ArrayList;

public class RecipesModel {
    private ArrayList<String> mRecipeTitles;
    private ArrayList<Bitmap> mRecipeImages;

    private Context mContext;

    public RecipesModel(Context context) {
        mRecipeTitles = new ArrayList<String>();
        mRecipeImages = new ArrayList<Bitmap>();
        mContext = context;

        setUpRecipes();
    }

    private void setUpRecipes() {
        mRecipeTitles.add("Mushroom Pasta");
        mRecipeTitles.add("Sausage, Peppers, and Onions");
        mRecipeTitles.add("Stuffed Green Peppers with Brown Rice, Italian Sausage, and Parmesan");
        mRecipeTitles.add("Sausage with Sauteed Red Onions and Thyme");
        mRecipeTitles.add("Dinner Tonight: Linguine with Citrus-Roasted Shrimp");
        mRecipeTitles.add("Salt-Roasted Shrimp with Scampi Dip");
        mRecipeTitles.add("Garlic Shrimp");
        mRecipeTitles.add("Grilled Flat Iron Steak with Chimichurri Sauce");
        mRecipeTitles.add("Pan-Seared Steak with Onion and Worchesrshire");
        mRecipeTitles.add("Beer and Brown Sugar Ribeye Steak");
        mRecipeTitles.add("Baked Lemon Pasta");
        mRecipeTitles.add("Bacon and Parmesan Penne Pasta");
        mRecipeTitles.add("Asian-Marinated Baked Chicken");
        mRecipeTitles.add("Honey-Mustard Baked Chicken");
        mRecipeTitles.add("Sriracha-Glazed Chicken");

        mRecipeImages.add(createRecipeBitmap(R.drawable.mushroom_pasta));
        mRecipeImages.add(createRecipeBitmap(R.drawable.sausage_peppers_onions));
        mRecipeImages.add(createRecipeBitmap(R.drawable.stuffed_green_peppers));
        mRecipeImages.add(createRecipeBitmap(R.drawable.sausage_sauteed_onions));
        mRecipeImages.add(createRecipeBitmap(R.drawable.linguine_roasted_shrimp));
        mRecipeImages.add(createRecipeBitmap(R.drawable.salt_roasted_shrimp));
        mRecipeImages.add(createRecipeBitmap(R.drawable.garlic_shrimp));
        mRecipeImages.add(createRecipeBitmap(R.drawable.flat_iron_steak));
        mRecipeImages.add(createRecipeBitmap(R.drawable.pan_seared_steak));
        mRecipeImages.add(createRecipeBitmap(R.drawable.beer_brown_sugar_steak));
        mRecipeImages.add(createRecipeBitmap(R.drawable.baked_lemon_pasta));
        mRecipeImages.add(createRecipeBitmap(R.drawable.bacon_parmesan_pasta));
        mRecipeImages.add(createRecipeBitmap(R.drawable.asian_marinated_chicken));
        mRecipeImages.add(createRecipeBitmap(R.drawable.honey_mustard_chicken));
        mRecipeImages.add(createRecipeBitmap(R.drawable.sriracha_glazed_chicken));
    }

    public String getRecipeTitle(int position) {
        return mRecipeTitles.get(position);
    }

    public ArrayList<String> getRecipes() {
        return mRecipeTitles;
    }

    private Bitmap createRecipeBitmap(int resource) {
        return ImageUtil.createBitmap(resource, mContext);
    }

    public Bitmap getRecipeBitmap(int position) {
        return mRecipeImages.get(position);
    }
}
