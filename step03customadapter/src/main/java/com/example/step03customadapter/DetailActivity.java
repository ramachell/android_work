package com.example.step03customadapter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        CountryDto dto = (CountryDto) intent.getSerializableExtra("dto");
        TextView textView = findViewById(R.id.textView);
        textView.setText(dto.getName());
        TextView textView2 = findViewById(R.id.textView2);
        textView2.setText(dto.getResId());
        ImageView iv = findViewById(R.id.imageView2);
        iv.setImageResource(dto.getResId());



    }
}
