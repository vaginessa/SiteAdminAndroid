package com.example.beethoven.siteadmin;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.util.Log;
import android.view.View;
import android.widget.*;


import com.example.beethoven.siteadmin.component.ListProduct;
import com.example.beethoven.siteadmin.component.Product;
import com.example.beethoven.siteadmin.webserveces.ImplListProductServer;

import java.util.*;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductActivite extends AppCompatActivity {
    List<Product> lP=new ArrayList<Product>();
    ArrayAdapter<Product> lPA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_product_activite);
        Intent intent1=getIntent();
        String typeP=intent1.getStringExtra("typeProduct");
        Log.e("user log","type product = "+typeP);
        Button addProductButton=(Button) findViewById(R.id.addProductButton);
        ListView listProduct=(ListView) findViewById(R.id.listProduct);

        //использовать синхронный поток для  обращения вк
        //StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
       // StrictMode.setThreadPolicy(policy);

        lPA=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,lP);
        listProduct.setAdapter(lPA);

        try {
            Retrofit retrofit = new Retrofit.Builder().baseUrl("http://favorit-3.biz.ua/work/").addConverterFactory(GsonConverterFactory.create()).build();
            ImplListProductServer intProdList = retrofit.create(ImplListProductServer.class);
            Call<ListProduct> lpe = intProdList.getProductList(typeP);
            Log.e("user log","not error 1");

//            Response<ListProduct> response=lpe.execute();
//            ListProduct lists=response.body();
//            for(Product p: lists.getProducts())
//            {
//                lP.add(p);
//                Log.e("user log","not error");
//            }

            lpe.enqueue(new Callback<ListProduct>(){

                @Override
                public void onResponse(Call<ListProduct> call, Response<ListProduct> response) {
                    Log.e("user log","not error 2");
                    ListProduct listProd=response.body();
                    Log.e("user log","not error 1");
                    for(Product p: listProd.getProducts())
                    {
                        lP.add(p);
                        Log.e("user log","not error");
                        lPA.notifyDataSetChanged();
                    }
                }

                @Override
                public void onFailure(Call<ListProduct> call, Throwable t) {
                    Log.e("eror error error","for server problems");
                }
            });
        }
        catch(Exception e)
        {
            Log.e("eeeeeeeeeeee","error e = "+e);
        }


        listProduct.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product p=(Product) parent.getAdapter().getItem(position);
                Intent intent=new Intent(ProductActivite.this,WorkProductActivite.class);
                intent.putExtra("prod",p);
                startActivity(intent);

            }
        });

        addProductButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(ProductActivite.this,AddProductActivite.class);
                startActivity(intent2);
            }
        });
    }
}
