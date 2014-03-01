package com.levibostian.pantrypirate.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.levibostian.pantrypirate.R;
import com.levibostian.pantrypirate.adapter.HomeScreenRecipesAdapter;
import com.levibostian.pantrypirate.model.RecipesModel;

public class MainFragment extends Fragment {
    private ListView mRecipeList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);

        mRecipeList = (ListView) view.findViewById(R.id.recipe_list);
        mRecipeList.setDivider(null);
        mRecipeList.setAdapter(new HomeScreenRecipesAdapter(getActivity(), new RecipesModel(getActivity())));

        return view;
    }
}
