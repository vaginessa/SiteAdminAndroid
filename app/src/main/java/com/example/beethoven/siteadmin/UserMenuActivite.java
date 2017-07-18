package com.example.beethoven.siteadmin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.example.beethoven.siteadmin.R;
import com.example.beethoven.siteadmin.component.UserData;

public class UserMenuActivite extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_menu_activite);
        UserData u=(UserData)getIntent().getSerializableExtra("compos");
        TextView text5=(TextView) findViewById(R.id.textView2);
        TextView text6=(TextView) findViewById(R.id.textView3);
        Button buttonSuper=(Button) findViewById(R.id.buttonSuper);
        buttonSuper.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent2=new Intent(UserMenuActivite.this,CapegoryProductActivite.class);
                startActivity(intent2);
            }
        });
        text5.setText(u.getNameUser());
        text6.setText(u.getPassword());
    }
}
