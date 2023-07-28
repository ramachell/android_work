package com.example.step04example;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
/*
    문자열을 입력하고 전송 누르면 Util 클래스 이용해서
    Get http://192.168.0.68:9000/boot07/android/tweet에 요청
    msg를 파라미터로 그리고 서버가 응답한문자 출력
 */

public class MainActivity extends AppCompatActivity implements Util.RequestListener{
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        EditText inputMsg = findViewById(R.id.inputMsg);
        Button sendBtn = findViewById(R.id.sendBtn);

        sendBtn.setOnClickListener(view -> {
            String msg = inputMsg.getText().toString();
            Map<String,String> map = new HashMap<>();
            map.put("msg",msg);
            Util.sendGetRequest(0,"http://192.168.0.68:9000/boot07/android/tweet",map,this);
        });

        //두번째 버튼도 리스너 등록하기
        Button sendBtn2=(Button) findViewById(R.id.sendBtn2);
        sendBtn2.setOnClickListener(view->{
            //입력한 문자열
            String msg=inputMsg.getText().toString();
            //요청 파라미터로 전달하기 위해 "msg" 라는 키값으로 Map 에 담는다.
            Map<String, String> map=new HashMap<>();
            map.put("msg", msg);
            Util.sendPostRequest(1,
                    "http://192.168.0.68:9000/boot07/android/tweet2",
                    map,
                    this);
        });

        Button sendBtn3 = (Button) findViewById(R.id.sendBtn3);
        sendBtn3.setOnClickListener(view -> {
            String msg = inputMsg.getText().toString();
            Map<String,String> map = new HashMap<>();
            map.put("msg",msg);
            Util.sendGetRequest(2,"http://192.168.0.68:9000/boot07/android/tweet3",map,this);
        });

        Button listBtn = findViewById(R.id.listBtn);
        listBtn.setOnClickListener(view -> {
            Util.sendGetRequest(3,"http://192.168.0.68:9000/boot07/android/list",null,this);
        });

    }

    @Override
    public void onSuccess(int requestId, Map<String, Object> result) {
        if(requestId==0){
            String data = (String) result.get("data");
            editText.setText(data);
        } else if (requestId==1) {
            String data=(String) result.get("data");

            // json 문자열은 JSONObject 객체 사용해서 원하는 데이터 추출
            try{
                JSONObject obj = new JSONObject(data);
                boolean isSuccess = obj.getBoolean("isSuccess");
                editText.setText(Boolean.toString(isSuccess));

            } catch (JSONException e) {
                editText.setText(e.getMessage());
            }

        } else if (requestId == 2){
            String data = (String) result.get("data");
            // data는 []형식의 문자열 (List를 보냈으므로)
            try {
                JSONArray arr = new JSONArray(data);
                for(int i = 0 ; i < arr.length() ; i ++){
                    editText.append(arr.getString(i)+"\n");
                }
            } catch (JSONException e) {
                editText.setText(e.getMessage());
            }
        } else if (requestId == 3) {
            String data =(String) result.get("data");
            try {
                JSONArray arr = new JSONArray(data);
                for(int i = 0 ; i< arr.length() ; i ++){
                    JSONObject obj = arr.getJSONObject(i);
                    int num = obj.getInt("num");
                    String writer = obj.getString("writer");
                    String title = obj.getString("title");
                    editText.append(num + " -  " +writer + " -  "+title+"\n");
                }
            } catch (JSONException e) {
                editText.setText(e.getMessage());
            }

        }
    }

    @Override
    public void onFail(int requestId, Map<String, Object> result) {
        if(requestId==0){
            String data = (String) result.get("data");
            editText.setText(data);
        } else if (requestId == 1){
            String data = (String) result.get("data");
            editText.setText(data);
        }
    }
}