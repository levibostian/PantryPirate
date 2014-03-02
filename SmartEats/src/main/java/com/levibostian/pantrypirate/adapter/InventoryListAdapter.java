package com.levibostian.pantrypirate.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.levibostian.pantrypirate.R;
import com.levibostian.pantrypirate.model.InventoryModel;
import com.levibostian.pantrypirate.vo.FoodItem;
import com.nhaarman.listviewanimations.ArrayAdapter;

public class InventoryListAdapter extends ArrayAdapter {
    private Activity mContext;
    private InventoryModel mInventoryModel;

    public InventoryListAdapter(Activity context, InventoryModel model) {
        super(model.getInventory());

        mContext = context;
        mInventoryModel = model;
    }

    static class ViewHolder {
        public TextView inventoryItemTitle;
        public ImageView inventoryItemImage;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;

        if (rowView == null) {
            LayoutInflater inflater = mContext.getLayoutInflater();
            rowView = inflater.inflate(R.layout.inventory_list_item, null);

            ViewHolder holder = new ViewHolder();
            holder.inventoryItemTitle = (TextView) rowView.findViewById(R.id.food_title);
            holder.inventoryItemImage = (ImageView) rowView.findViewById(R.id.food_image);
            rowView.setTag(holder);
        }

        ViewHolder holder = (ViewHolder) rowView.getTag();
        FoodItem food = mInventoryModel.getFoodItem(position);
        holder.inventoryItemImage.setImageBitmap(food.getBitmap(mContext));
        holder.inventoryItemTitle.setText(food.getTitle());

        return rowView;
    }
}
