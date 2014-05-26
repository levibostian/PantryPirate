package com.levibostian.pantrypirate.task;

import com.levibostian.pantrypirate.vo.UpcProduct;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface SearchUpcTask {
    @GET("/handlers/upcsearch.ashx")
    UpcProduct upcProduct(@Query("request_type") String request_type,
                          @Query("access_token") String access_token,
                          @Query("upc") String upc);

    @GET("/handlers/upcsearch.ashx")
    Response upcProductResponse(@Query("request_type") String request_type,
                          @Query("access_token") String access_token,
                          @Query("upc") String upc);
}
