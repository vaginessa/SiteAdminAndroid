package com.example.beethoven.siteadmin.webserveces;

import com.example.beethoven.siteadmin.component.ListProduct;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by beethoven on 14.07.2017.
 */

public interface ImplListProductServer {
    @GET("webserveses24.php")
    Call<ListProduct> getProductList(@Query("product") String typeProduct);
}
