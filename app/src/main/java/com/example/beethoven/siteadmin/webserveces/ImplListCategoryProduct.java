package com.example.beethoven.siteadmin.webserveces;

import com.example.beethoven.siteadmin.component.ListCategoryProduct;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by beethoven on 12.07.2017.
 */

public interface ImplListCategoryProduct {

    @GET("webserveses22.php")
    Call<ListCategoryProduct> getListCategoryProduct();
}
