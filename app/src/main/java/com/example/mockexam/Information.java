package com.example.mockexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Information extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        Intent in=getIntent();
        setTitle(in.getStringExtra("info1"));
        TextView tv=findViewById(R.id.textView4);
        tv.setText(in.getStringExtra("info"));


    }
}
