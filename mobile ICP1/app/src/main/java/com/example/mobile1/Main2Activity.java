package com.example.mobile1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private Button Logout;
    private TextView Message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Logout = (Button)findViewById(R.id.btnLogout);
        Message = (TextView)findViewById(R.id.tvText);

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent redirect = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(redirect);

            }
        });
    }
}