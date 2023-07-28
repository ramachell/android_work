package com.example.step05fragment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.step05fragment.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements MyFragment.MyFragmentListener {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Fragment 객체
        FragmentManager fm = getSupportFragmentManager();
        MyFragment fragment1 = (MyFragment) fm.findFragmentById(R.id.fragment0);

        // Button resetBtn = findViewById(R.id.resetBtn);
        Button resetBtn = binding.resetBtn;
        resetBtn.setOnClickListener(view -> {
            fragment1.reset();
        });

        // Button moveBtn = findViewById(R.id.moveBtn);
        Button moveBtn = binding.moveBtn;

        moveBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this,SubActivity.class);
            startActivity(intent);
        });
    }


    @Override
    public void sendMsg(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}