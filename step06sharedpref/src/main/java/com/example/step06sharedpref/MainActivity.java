package com.example.step06sharedpref;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.step06sharedpref.databinding.ActivityMainBinding;
/*
    App 에서 문자열을 영구 저장하는 방법 (영구 저장이란 앱을 종료하고 다시 시작해도 불러올수 있는 문자열 )

    1. 파일 입출력을 이용해서 저장
    2. android 내장 data base 를 이용해서 저장  => SQLite DataBase
    3. SharedPreference 를 이용해서 저장 (느리지만 간단히 저장하고 불러 올수 있다)
       내부적으로 xml 문서를 만들어서 문자열을 저장하고 불러온다.
       저장된 문자열을 boolean, int, double, String type 으로 변환해서 불러 올수 있다.

 */
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.saveBtn.setOnClickListener(view -> {
            // 메시지 읽어와서
            String msg = binding.editText.getText().toString();
            // pref 만들고
            SharedPreferences pref = getSharedPreferences("info", Context.MODE_PRIVATE);
            // 에디터 객체
            SharedPreferences.Editor editor = pref.edit();
            // 저장
            editor.putString("msg",msg);
            editor.commit();

            new AlertDialog.Builder(this)
                    .setTitle("알림")
                    .setMessage("저장했습니다.")
                    .setNegativeButton("확인", null)
                    .create()
                    .show();
        });

        binding.readBtn.setOnClickListener(view -> {

        });

    }
}