package com.example.beethoven.siteadmin.webserveces;

import android.util.Log;

import com.example.beethoven.siteadmin.component.UserData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by beethoven on 10.07.2017.
 */
public class MainWebServicesClass {
    UserData us=new UserData();
    public void getUserFromSite()
    {
        try {
            Retrofit r = new Retrofit.Builder().baseUrl("http://favorit-3.biz.ua/work/").addConverterFactory(GsonConverterFactory.create()).build();
            GetUserServer intDelNews = r.create(GetUserServer.class);
            Call<UserData> call = intDelNews.getUserData();

                Response<UserData> response=call.execute();
                us=response.body();
                Log.d("user data","not error1");

//            call.enqueue(new Callback<UserData>(){
//
//                public void onResponse(Call<UserData> call, Response<UserData> rspns) {
//                    Log.d("User Data","Фаил загружен");
//                    us=rspns.body();
//                    Log.d("data first","name user"+us.getNameUser());
//                    Log.d("User data","dota puta");
//                }
//
//                public void onFailure(Call<UserData> call, Throwable thrwbl) {
//                    Log.e("User Data","фаил не загружен");
//                }
//
//            });
        }
        catch(Exception e)
        {
            Log.d("Error user","error (((((((");
        }
    }
    public UserData getUserData()
    {
        return this.us;
    }
}
