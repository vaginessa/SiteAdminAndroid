package com.example.beethoven.siteadmin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import com.example.beethoven.siteadmin.component.Product;
import com.example.beethoven.siteadmin.component.SendInfo;
import com.example.beethoven.siteadmin.webserveces.ImplDeleteProduct;
import com.example.beethoven.siteadmin.webserveces.ImplEditProduct;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WorkProductActivite extends AppCompatActivity {
    Product p;
    EditText contentProduct,priceProduct,countProduct;
    CheckBox avalProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_product_activite);

        TextView textView4=(TextView) findViewById(R.id.nameProduct);

        contentProduct=(EditText) findViewById(R.id.contentProduct);
        priceProduct=(EditText) findViewById(R.id.priceProduct);
        countProduct=(EditText) findViewById(R.id.countProduct);
        avalProduct=(CheckBox) findViewById(R.id.avalProduct);

        Button buttonDeleteProduct=(Button) findViewById(R.id.buttonDeleteProduct);
        Button buttonEditProduct=(Button) findViewById(R.id.buttonEditProduct);

        Intent intent=getIntent();

        p=(Product)intent.getSerializableExtra("prod");

        textView4.setText(p.getNameProduct());
        contentProduct.setText(""+p.getContent());
        priceProduct.setText(""+p.getPrice());
        countProduct.setText(""+p.getCountP());
        if(p.getAvailability().equals("yes"))
        {
            avalProduct.setChecked(true);
        }
        else
        {
            avalProduct.setChecked(false);
        }


        buttonDeleteProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    Retrofit retrofit = new Retrofit.Builder().baseUrl("http://favorit-3.biz.ua/work/").addConverterFactory(GsonConverterFactory.create()).build();
                    ImplDeleteProduct dp=retrofit.create(ImplDeleteProduct.class);
                    Call<SendInfo> delet=dp.deleteDataProduct(p.getId());
                    delet.enqueue(new Callback<SendInfo>() {
                        @Override
                        public void onResponse(Call<SendInfo> call, Response<SendInfo> response) {
                            SendInfo send=response.body();
                            Log.e("eeeeeeee","status info delete = "+send.getStatus());
                        }

                        @Override
                        public void onFailure(Call<SendInfo> call, Throwable t) {

                        }
                    });
                    Intent i1=new Intent(WorkProductActivite.this,ProductActivite.class);
                    i1.putExtra("typeProduct",p.getTypeProduct());
                    startActivity(i1);
                }
                catch(Exception e)
                {

                }
            }
        });

        buttonEditProduct.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try
                {
                    Retrofit retrofit = new Retrofit.Builder().baseUrl("http://favorit-3.biz.ua/work/").addConverterFactory(GsonConverterFactory.create()).build();
                    ImplEditProduct ep=retrofit.create(ImplEditProduct.class);
                    Call<SendInfo> infEdit=ep.editDataProduct(p.getId(),p.getNameProduct(),p.getTypeProduct(),contentProduct.getText().toString(),p.getTitleImage(),p.getImage1(),p.getImage2(),
                            p.getImage3(),p.getImage4(),Integer.parseInt(priceProduct.getText().toString()),p.getAvailability(),Integer.parseInt(countProduct.getText().toString()));

                    infEdit.enqueue(new Callback<SendInfo>() {
                        @Override
                        public void onResponse(Call<SendInfo> call, Response<SendInfo> response) {
                            SendInfo info=response.body();
                           Log.e("server edit product","edit product status = "+info.getStatus());
                        }

                        @Override
                        public void onFailure(Call<SendInfo> call, Throwable t) {
                            Log.e("server edit product","error for server from edit product");
                        }
                    });
                    Intent i2=new Intent(WorkProductActivite.this,ProductActivite.class);
                    i2.putExtra("typeProduct",p.getTypeProduct());
                    startActivity(i2);

                }catch(Exception expe)
                {
                        Log.e("eeeeeeeeeeeee","error name = "+expe);
                }
            }
        });


    }
}
