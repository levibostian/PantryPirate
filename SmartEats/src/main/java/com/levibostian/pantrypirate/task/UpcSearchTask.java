package com.levibostian.pantrypirate.task;

import android.os.AsyncTask;
import com.levibostian.pantrypirate.vo.UpcProduct;
import retrofit.RestAdapter;
import retrofit.client.Header;
import retrofit.client.Response;

import java.util.List;

public class UpcSearchTask extends AsyncTask<String, Void, String> {
    private ProductFoundInterface mCallback;

    private static final String API_KEY = ""; // API key for searchupc.com here

    public interface ProductFoundInterface {
        public void productFoundFromUpc(String productName);
    }

    public UpcSearchTask(ProductFoundInterface callback) {
        mCallback = callback;
    }

    @Override
    protected String doInBackground(String... upc) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                                          .setServer("http://www.searchupc.com")
                                          .build();
        SearchUpcTask task = restAdapter.create(SearchUpcTask.class);

        UpcProduct product = task.upcProduct("3", API_KEY, upc[0]);

        // Not fully working. API call works correctly, but JSON
        // returned back from searchupc.com comes back with a base
        // object titled "0" so it must manually be deserialized
        // to a VO object instead of Retrofit doing it for me. 
        return product.productname;
    }

    @Override
    protected void onPostExecute(String result) {
        mCallback.productFoundFromUpc(result);
    }
}
