package com.levibostian.pantrypirate.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.levibostian.pantrypirate.R;
import com.levibostian.pantrypirate.model.LicensesModel;
import com.levibostian.pantrypirate.vo.License;

public class LicenseAdapter extends ArrayAdapter {
    private Activity mContext;
    private LicensesModel mLicensesModel;

    public LicenseAdapter(Activity context, LicensesModel model) {
        super(context, R.layout.licenses_listview_row, model.getLicenses());

        mContext = context;
        mLicensesModel = model;
    }

    static class ViewHolder {
        public TextView licenseTitle;
        public TextView licenseUrl;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;

        if (rowView == null) {
            LayoutInflater inflater = mContext.getLayoutInflater();
            rowView = inflater.inflate(R.layout.licenses_listview_row, null);

            ViewHolder holder = new ViewHolder();
            holder.licenseTitle = (TextView) rowView.findViewById(R.id.project_name);
            holder.licenseUrl = (TextView) rowView.findViewById(R.id.project_url);
            rowView.setTag(holder);
        }

        ViewHolder holder = (ViewHolder) rowView.getTag();
        License license = mLicensesModel.getLicense(position);
        holder.licenseTitle.setText(license.getTitle());
        holder.licenseUrl.setText(license.getUrl());

        return rowView;
    }
}
