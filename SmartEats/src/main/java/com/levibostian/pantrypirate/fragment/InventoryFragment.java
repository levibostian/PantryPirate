package com.levibostian.pantrypirate.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.levibostian.pantrypirate.R;
import com.levibostian.pantrypirate.adapter.InventoryListAdapter;
import com.levibostian.pantrypirate.model.InventoryModel;
import com.levibostian.pantrypirate.vo.FoodItem;
import de.timroes.android.listview.EnhancedListView;

public class InventoryFragment extends Fragment implements EnhancedListView.OnDismissCallback {
    private EnhancedListView mInventoryList;
    private InventoryListAdapter mAdapter;
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
        mInventoryList = (EnhancedListView) view.findViewById(R.id.inventory_list);
        mPantryBareView = (RelativeLayout) view.findViewById(R.id.pantry_bare_view);

        populateInventory();
        checkShowInventoryLowView();
    }

    private void populateInventory() {
        mAdapter = new InventoryListAdapter(getActivity(), new InventoryModel());
        mInventoryList.setAdapter(mAdapter);

        mInventoryList.setDismissCallback(this);
        mInventoryList.enableSwipeToDismiss();
    }

    private void checkShowInventoryLowView() {
        if (mAdapter.size() <= 5) {
            mPantryBareView.setVisibility(View.VISIBLE);
        } else {
            mPantryBareView.setVisibility(View.GONE);
        }
    }

    @Override
    public EnhancedListView.Undoable onDismiss(EnhancedListView enhancedListView, final int pos) {
        final FoodItem item = mAdapter.getItem(pos);
        mAdapter.remove(pos);

        return new EnhancedListView.Undoable() {
            @Override
            public void undo() {
                mAdapter.add(pos, item);
                checkShowInventoryLowView();
            }

            @Override
            public String getTitle() {
                checkShowInventoryLowView();
                return "Deleted " + item.getTitle();
            }
        };


    }
}
