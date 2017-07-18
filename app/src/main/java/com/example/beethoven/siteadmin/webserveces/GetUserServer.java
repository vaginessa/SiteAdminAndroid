package com.example.beethoven.siteadmin.webserveces;

import com.example.beethoven.siteadmin.component.UserData;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by beethoven on 10.07.2017.
 */

public interface GetUserServer {

    @GET("webserveses21.php")
    Call<UserData> getUserData();
}
