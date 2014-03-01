package com.levibostian.smarteats.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.levibostian.smarteats.R;
import com.levibostian.smarteats.model.RecipesModel;

public class HomeScreenRecipesAdapter extends ArrayAdapter {
    private Activity mContext;
    private RecipesModel mRecipesModel;

    public HomeScreenRecipesAdapter(Activity context, RecipesModel model) {
        super(context, R.layout.home_screen_recipes_list_item, model.getRecipes());

        mContext = context;
        mRecipesModel = model;
    }

    static class ViewHolder {
        public TextView recipeTitle;
        public ImageView recipeImage;
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
            rowView.setTag(holder);
        }

        ViewHolder holder = (ViewHolder) rowView.getTag();
        holder.recipeTitle.setText(mRecipesModel.getRecipeTitle(position));
        holder.recipeImage.setImageBitmap(mRecipesModel.getRecipeBitmap(position));

        return rowView;
    }
}
