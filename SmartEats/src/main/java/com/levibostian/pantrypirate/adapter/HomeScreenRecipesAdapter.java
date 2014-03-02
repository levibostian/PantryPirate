package com.levibostian.pantrypirate.adapter;

import android.app.Activity;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.levibostian.pantrypirate.R;
import com.levibostian.pantrypirate.model.RecipesModel;
import org.w3c.dom.Text;

import java.util.Random;

public class HomeScreenRecipesAdapter extends ArrayAdapter {
    private Activity mContext;
    private RecipesModel mRecipesModel;

    private static final int MAX_LENGTH_RECIPE_TITLE = 45;

    public HomeScreenRecipesAdapter(Activity context, RecipesModel model) {
        super(context, R.layout.home_screen_recipes_list_item, model.getRecipes());

        mContext = context;
        mRecipesModel = model;
    }

    static class ViewHolder {
        public TextView recipeTitle;
        public ImageView recipeImage;
        public RatingBar recipeRating;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;

        if (rowView == null) {
            LayoutInflater inflater = mContext.getLayoutInflater();
            rowView = inflater.inflate(R.layout.home_screen_recipes_list_item, null);

            ViewHolder holder = new ViewHolder();
            holder.recipeTitle = (TextView) rowView.findViewById(R.id.recipe_title);
            holder.recipeImage = (ImageView) rowView.findViewById(R.id.recipe_image);
            holder.recipeRating = (RatingBar) rowView.findViewById(R.id.recipe_rating);
            rowView.setTag(holder);
        }

        ViewHolder holder = (ViewHolder) rowView.getTag();
        setRecipeText(holder.recipeTitle, mRecipesModel.getRecipeTitle(position));
        holder.recipeImage.setImageBitmap(mRecipesModel.getRecipeBitmap(position));
        setRandomRating(holder.recipeRating);

        return rowView;
    }

    private void setRecipeText(TextView recipeTitle, String text) {
        if (text.length() > MAX_LENGTH_RECIPE_TITLE) {
            text = text.substring(0, MAX_LENGTH_RECIPE_TITLE) + "...";
        }

        recipeTitle.setText(text);
    }

    private void setRandomRating(RatingBar ratingBar) {
        Random random = new Random();

        int randInt = random.nextInt(6);
        if (randInt >= 3) {
            ratingBar.setRating(randInt);
        } else {
            setRandomRating(ratingBar);
        }
    }
}
