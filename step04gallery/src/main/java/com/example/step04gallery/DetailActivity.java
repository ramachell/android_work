package com.example.step04gallery;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        GalleryDto dto = (GalleryDto) intent.getSerializableExtra("dto");
        TextView writer = findViewById(R.id.writer);
        writer.setText(dto.getWriter());
        TextView caption = findViewById(R.id.caption);
        caption.setText(dto.getCaption());
        TextView regdate = findViewById(R.id.regdate);
        regdate.setText(dto.getRegdate());
        ImageView imageView = findViewById(R.id.imageView);
        Glide.with(this)
                .load(dto.getImagePath())
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageView);
    }
}
