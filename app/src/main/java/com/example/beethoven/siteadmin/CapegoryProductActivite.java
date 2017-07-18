package com.example.beethoven.siteadmin;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.beethoven.siteadmin.component.CategoryProduct;
import com.example.beethoven.siteadmin.component.ListCategoryProduct;
import com.example.beethoven.siteadmin.webserveces.ImplListCategoryProduct;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CapegoryProductActivite extends AppCompatActivity {

    List<String> arm = new ArrayList<String>();
    ArrayAdapter<String> listType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capegory_product_activite);


//        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//        StrictMode.setThreadPolicy(policy);

        ListView listCategoryProduct=(ListView) findViewById(R.id.listViewCategoryProduct);

        listType=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arm);

        listCategoryProduct.setAdapter(listType);
        try {
            Retrofit r = new Retrofit.Builder().baseUrl("http://favorit-3.biz.ua/work/").addConverterFactory(GsonConverterFactory.create()).build();
            ImplListCategoryProduct categorProd = r.create(ImplListCategoryProduct.class);
            Call<ListCategoryProduct> call = categorProd.getListCategoryProduct();

//            Response<ListCategoryProduct> response=call.execute();
//            ListCategoryProduct lists=response.body();
//            for(CategoryProduct cp:lists.getListCategory())
//            {
//                arm.add(cp.getNameCategory());
//            }

            call.enqueue(new Callback<ListCategoryProduct>(){
                public void onResponse(Call<ListCategoryProduct> call, Response<ListCategoryProduct> rspns) {
                    ListCategoryProduct listPr=rspns.body();

                    for(CategoryProduct cp:listPr.getListCategory())
                    {
                        arm.add(cp.getNameCategory());
                    }
                    listType.notifyDataSetChanged();
                }
                public void onFailure(Call<ListCategoryProduct> call, Throwable thrwbl) {
                }
            });

        }catch(Exception e)
        {
            Log.e("user error","error server"+e.toString());
        }


        listCategoryProduct.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent3=new Intent(CapegoryProductActivite.this,TypeProductActivite.class);
                intent3.putExtra("pupu",((TextView) view).getText());
                startActivity(intent3);
            }
        });


    }
}
