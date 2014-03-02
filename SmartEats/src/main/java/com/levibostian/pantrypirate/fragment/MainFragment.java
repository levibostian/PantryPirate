package com.levibostian.pantrypirate.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.levibostian.pantrypirate.R;
import com.levibostian.pantrypirate.adapter.HomeScreenRecipesAdapter;
import com.levibostian.pantrypirate.model.RecipesModel;
import com.nhaarman.listviewanimations.swinginadapters.prepared.SwingBottomInAnimationAdapter;

public class MainFragment extends BaseFragment {
    private ListView mRecipeList;
    private HomeScreenRecipesAdapter mRecipesAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);

        setViewItems(view);

        return view;
    }

    private void setViewItems(View view) {
        mRecipeList = (ListView) view.findViewById(R.id.recipe_list);
        mRecipeList.setDivider(null);

        populateRecipesList();
    }

    private void populateRecipesList() {
        mRecipesAdapter = new HomeScreenRecipesAdapter(getActivity(), new RecipesModel(getActivity()));

        SwingBottomInAnimationAdapter animBottomAdapter = new SwingBottomInAnimationAdapter(mRecipesAdapter);
        animBottomAdapter.setAbsListView(mRecipeList);
        mRecipeList.setAdapter(animBottomAdapter);
    }

    @Override
    public void resetFragmentContent() {
        populateRecipesList();
    }
}
