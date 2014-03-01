package com.levibostian.pantrypirate.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.levibostian.pantrypirate.R;

public class NavigationDrawerAdapter extends ArrayAdapter<String> {
    private Activity mContext;
    private String[] mTitles;

    public NavigationDrawerAdapter(Activity context, String[] values) {
        super(context, R.layout.drawer_list_item, values);

        mContext = context;
        mTitles = values;
    }

    static class ViewHolder {
        public TextView text;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;

        if (rowView == null) {
            LayoutInflater inflater = mContext.getLayoutInflater();
            rowView = inflater.inflate(R.layout.drawer_list_item, null);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.text = (TextView) rowView.findViewById(R.id.drawer_list_item);
            rowView.setTag(viewHolder);
        }

        ViewHolder holder = (ViewHolder) rowView.getTag();
        holder.text.setText(mTitles[position]);

        return rowView;
    }
}
