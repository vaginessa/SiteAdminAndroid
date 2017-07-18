package com.example.beethoven.siteadmin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import com.example.beethoven.siteadmin.component.UserData;
import com.example.beethoven.siteadmin.webserveces.GetUserServer;
import com.example.beethoven.siteadmin.webserveces.MainWebServicesClass;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    EditText nameUser,passwordUser;
    UserData u;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameUser=(EditText) findViewById(R.id.nameUser);
        passwordUser=(EditText) findViewById(R.id.passwordUser);
        Button buttonConnection=(Button) findViewById(R.id.buttonConnect);
        buttonConnection.setOnClickListener(new View.OnClickListener(){
           public void onClick(View v){


//               UserData u=new UserData("beethoven","mozart");
//               Intent intent1=new Intent(MainActivity.this,UserMenuActivite.class);
//               intent1.putExtra("compos",u);
//               startActivity(intent1);
//           }


           try {
               Retrofit r = new Retrofit.Builder().baseUrl("http://favorit-3.biz.ua/work/").addConverterFactory(GsonConverterFactory.create()).build();
               GetUserServer intDelNews = r.create(GetUserServer.class);
               Call<UserData> call = intDelNews.getUserData();


               call.enqueue(new Callback<UserData>(){
                    public void onResponse(Call<UserData> call, Response<UserData> rspns) {
                    Log.d("User Data","Фаил загружен");
                    UserData us=rspns.body();
                        Log.e("user data","passowrd = "+passwordUser.getText()+" password form server = "+us.getPassword());
                        Log.e("user data","passowrd = "+nameUser.getText()+" password form server = "+us.getNameUser());
                    if((us.getNameUser().equals(nameUser.getText().toString()))&&(passwordUser.getText().toString().equals(""+us.getPassword())))
                    {
                        Log.e("user data","load from inter whota a fack");
                        Intent intent1=new Intent(MainActivity.this,UserMenuActivite.class);
                        intent1.putExtra("compos",us);
                        startActivity(intent1);
                    }
                }
                public void onFailure(Call<UserData> call, Throwable thrwbl) {
                    Log.e("User Data","фаил не загружен");
                }
            });
               }catch(Exception e)
               {
                    Log.e("user error","error server"+e.toString());
               }
           }
        });
    }
}
