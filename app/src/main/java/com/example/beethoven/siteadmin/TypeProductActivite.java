package com.example.beethoven.siteadmin;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.beethoven.siteadmin.component.ListTypeProduct;
import com.example.beethoven.siteadmin.component.TypeProduct;
import com.example.beethoven.siteadmin.webserveces.ImplTypeProduct;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TypeProductActivite extends AppCompatActivity {
    List<String> listP=new ArrayList<String>();
    ArrayAdapter<String> l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_product_activite);
        Intent ints=getIntent();
        String catProd=ints.getStringExtra("pupu");

//        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//        StrictMode.setThreadPolicy(policy);

        ListView listProduct=(ListView) findViewById(R.id.listViewTypeProduct);
        l=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,listP);

        listProduct.setAdapter(l);
        try
        {
            Retrofit r = new Retrofit.Builder().baseUrl("http://favorit-3.biz.ua/work/").addConverterFactory(GsonConverterFactory.create()).build();
            ImplTypeProduct categorProd = r.create(ImplTypeProduct.class);
            Call<ListTypeProduct> call = categorProd.getListTypeProduct(catProd);
            

            call.enqueue(new Callback<ListTypeProduct>(){
                public void onResponse(Call<ListTypeProduct> call, Response<ListTypeProduct> rspns) {
                    ListTypeProduct listPr=rspns.body();
                    if(listPr.getListType()!=null) {
                        for (TypeProduct tpp : listPr.getListType()) {
                            listP.add(tpp.getTypeName());
                        }
                    }
                    else
                    {
                        listP.add("not data in site");
                    }
                    l.notifyDataSetChanged();
                }
                public void onFailure(Call<ListTypeProduct> call, Throwable thrwbl) {
                }
            });
        }catch(Exception e)
        {

        }


        listProduct.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 Intent intent=new Intent(TypeProductActivite.this,ProductActivite.class);
                 intent.putExtra("typeProduct",((TextView) view).getText());
                 startActivity(intent);
            }
        });
    }
}
