package com.example.lab81;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btndangnhap,btndangky;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btndangnhap=findViewById(R.id.btnDangNhap);
        btndangky=findViewById(R.id.btnDangKy);
        final Intent intentdn=new Intent(this,frmDangNhap.class);
        final Intent intentdk=new Intent(this,frmDangKy.class);
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentdn);
            }
        });
        btndangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentdk);
            }
        });
    }
}