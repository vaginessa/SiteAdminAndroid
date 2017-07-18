package com.example.beethoven.siteadmin.webserveces;

import com.example.beethoven.siteadmin.component.ListTypeProduct;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by beethoven on 12.07.2017.
 */

public interface ImplTypeProduct {

    @GET("webserveses23.php")
    Call<ListTypeProduct> getListTypeProduct(@Query("nameCategory") String nameCategory);
}
