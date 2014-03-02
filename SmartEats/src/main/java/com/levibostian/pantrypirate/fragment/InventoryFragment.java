package com.levibostian.pantrypirate.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.levibostian.pantrypirate.R;

public class InventoryFragment extends Fragment {
    private ListView mInventoryList;
    private RelativeLayout mPantryBareView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.inventory_fragment, container, false);

        setViewItems(view);

        return view;
    }

    private void setViewItems(View view) {
        mInventoryList = (ListView) view.findViewById(R.id.inventory_list);
        mPantryBareView = (RelativeLayout) view.findViewById(R.id.pantry_bare_view);

        populateInventory();
        // TODO: Have listener watching length of listview. when below level, show pantry view.
    }

    private void populateInventory() {

    }
}
