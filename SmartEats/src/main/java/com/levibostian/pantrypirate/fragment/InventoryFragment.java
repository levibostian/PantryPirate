package com.levibostian.pantrypirate.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.levibostian.pantrypirate.R;
import com.levibostian.pantrypirate.adapter.InventoryListAdapter;
import com.levibostian.pantrypirate.model.InventoryModel;
import com.levibostian.pantrypirate.vo.FoodItem;
import de.timroes.android.listview.EnhancedListView;

import static com.levibostian.pantrypirate.fragment.AddInventorySelectDialogFragment.*;

public class InventoryFragment extends BaseFragment implements EnhancedListView.OnDismissCallback,
                                                               AddInventorySelectDialogFragment.AddInventoryItemSelectMethodCallback {
    private EnhancedListView mInventoryList;
    private InventoryListAdapter mAdapter;
    private RelativeLayout mPantryBareView;

    private static final String ADD_ITEM_DIALOG = "addItemDialog";

    private static final int BARCODE_SCAN_INTENT = 0;

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

        Button addButton = (Button) view.findViewById(R.id.add_inventory_item);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                promptInventoryAddMethod();
            }
        });

        populateInventory();
        checkShowInventoryLowView();
    }

    private void promptInventoryAddMethod() {
        DialogFragment dialog = new AddInventorySelectDialogFragment(this);
        dialog.show(getFragmentManager(), ADD_ITEM_DIALOG);
    }

    private void populateInventory() {
        populateInventoryList();

        mInventoryList.setDismissCallback(this);
        mInventoryList.enableSwipeToDismiss();
    }

    private void populateInventoryList() {
        mAdapter = new InventoryListAdapter(getActivity(), new InventoryModel());
        mInventoryList.setAdapter(mAdapter);
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

    @Override
    public void resetFragmentContent() {
        populateInventoryList();
    }

    @Override
    public void addInventoryItemMethodSelected(int pos) {
        switch (pos) {
            case SCAN_BARCODE:
                scanBarcodeIntent();
                break;
            case SPEECH_TO_TEXT:
                speechToTextIntent();
                break;
        }
    }

    private void scanBarcodeIntent() {
        Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        intent.putExtra("SCAN_MODE", "PRODUCT_MODE");
        startActivityForResult(intent, BARCODE_SCAN_INTENT);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == BARCODE_SCAN_INTENT) {
            if (resultCode == Activity.RESULT_OK) {
                String contents = data.getStringExtra("SCAN_RESULT");
            }
        }
    }

    private void speechToTextIntent() {

    }
}
