package com.example.beethoven.siteadmin.webserveces;

import com.example.beethoven.siteadmin.component.SendInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by beethoven on 16.07.2017.
 */

public interface ImplDeleteProduct {

    @GET("webserveses25.php")
    Call<SendInfo> deleteDataProduct(@Query("id") int id);
}
