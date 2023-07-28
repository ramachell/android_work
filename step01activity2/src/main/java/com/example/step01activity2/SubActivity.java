package com.example.step01activity2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("subActivity","onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("subActivity","onResume()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("subActivity","onRestart()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("subActivity","onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("subActivity","onStart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("subActivity","onDestroy()");
    }
}






