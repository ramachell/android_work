package com.example.step01activity2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //이동 버튼의 참조값 얻어오기
        Button moveBtn=findViewById(R.id.moveBtn);
        //버튼을 눌렀을때 동작하기 위한 리스너 등록
//        moveBtn.setOnClickListener(this);

//        View.OnClickListener listener=new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//
//            }
//        };

        moveBtn.setOnClickListener(view->{
            //SubActivity 를 활성화 시키겠다는 의도(Intent) 객체 생성하기
            Intent intent=new Intent(this, SubActivity.class);
            //startActivity() 메소드를 호출하면서 Intent 객체를 전달하기
            startActivity(intent);
        });
    }

//    @Override
//    public void onClick(View view) {
//        //SubActivity 를 활성화 시키겠다는 의도(Intent) 객체 생성하기
//        Intent intent=new Intent(this, SubActivity2.class);
//        //startActivity() 메소드를 호출하면서 Intent 객체를 전달하기
//        startActivity(intent);
//    }
}













