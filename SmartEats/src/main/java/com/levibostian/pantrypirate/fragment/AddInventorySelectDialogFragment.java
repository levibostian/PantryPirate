package com.levibostian.pantrypirate.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.levibostian.pantrypirate.R;

public class AddInventorySelectDialogFragment extends DialogFragment {
    private AddInventoryItemSelectMethodCallback mCallback;

    public static final int SCAN_BARCODE = 0;
    public static final int SPEECH_TO_TEXT = 1;

    public interface AddInventoryItemSelectMethodCallback {
        public void addInventoryItemMethodSelected(int pos);
    }

    public AddInventorySelectDialogFragment(AddInventoryItemSelectMethodCallback callback) {
        mCallback = callback;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.add_item)
                .setItems(R.array.add_inventory_methods, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mCallback.addInventoryItemMethodSelected(which);
                    }
                });

        return builder.create();
    }
}
