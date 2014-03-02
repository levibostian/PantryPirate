package com.levibostian.pantrypirate.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.levibostian.pantrypirate.adapter.LicenseAdapter;
import com.levibostian.pantrypirate.model.LicensesModel;

public class LicensesFragment extends ListFragment {
    private LicensesModel mLicensesModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mLicensesModel = new LicensesModel();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        setListAdapter(new LicenseAdapter(getActivity(), mLicensesModel));

        return view;
    }

    @Override
    public void onListItemClick(ListView listView, View view, int position, long id) {
        super.onListItemClick(listView, view, position, id);

        openUrlLink(mLicensesModel.getLicense(position).getUrl());
    }

    private void openUrlLink(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}
