package com.example.step05fragment;
/*
    [Fragment]

    - 액티비티의 제어하에 존재하는 mini Controller
    - 재활용을 염두에 두고 만드는 경우가 많다
    - 재활용이라는 것은 여러개의 액티비티에서 활용된다는 의미

    [ Fragment 만드는 방법 ]
    1. Fragment 클래스를 상속 받는다
    2. 프레그먼트의 Layout mxl 문서를 만든다.
    3. onCreateView() 메소드를 오버라이딩

 */

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

public class MyFragment extends Fragment implements View.OnClickListener {
    // 해당 프레그먼트가 제어할 View 객체 만들어서 리턴
    TextView textView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 1. fragment_my.xml 문서를 전개해서 View 만들고
        View view = inflater.inflate(R.layout.fragment_my,container,false);
        textView = view.findViewById(R.id.textView);
        textView.setOnClickListener(this);
        // 2. 해당 View 리턴
        return view;

    }

    @Override
    public void onClick(View view) {
        // TextView 에 출력한 문자열을 숫자로 바꿔서 얻어내고 +1 시켜서 textView 에 입력
        int count = Integer.parseInt(textView.getText().toString());
        count ++ ;

        if( count % 2 == 0){
            textView.setBackgroundColor(Color.RED);
        } else {
            textView.setBackgroundColor(Color.GREEN);
        }
        textView.setText(Integer.toString(count));

        FragmentActivity fa = getActivity();
        //혹시 액티비티가 MyFragmentListener 인터페이스를 구현하지 않았을수도 있기 때문에 type 을 확인해서 casting 한다.
        if(count%10 == 0 && fa instanceof MyFragmentListener){
            MyFragmentListener ma=(MyFragmentListener)fa;
            ma.sendMsg(count+" 입니다. 액티비티님!");
        }

//        if(fa instanceof MyFragmentListener )

    }
    //이 fragment 에서 전달하는 메세지를 받을 액티비티에서 구현할 인터페이스를 클래스 안에 정의 하기
    public interface MyFragmentListener{
        public void sendMsg(String msg);
    }

    public void reset(){
        textView.setText("0");
    }
}

