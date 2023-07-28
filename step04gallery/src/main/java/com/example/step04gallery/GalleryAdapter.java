package com.example.step04gallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class GalleryAdapter extends BaseAdapter {
    
    // 전개자 객체
    private LayoutInflater inflater;
    // 모델
    private List<GalleryDto> list;
    // 레이아웃 리소스 id
    private int layoutRes;
    // 앱 컨텍스트
    private Context context;

    public GalleryAdapter(List<GalleryDto> list, int layoutRes, Context context) {
        this.list = list;
        this.layoutRes = layoutRes;
        this.context = context;
        // 레이아웃 전개자 객채 참조값
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    };


    @Override
    public long getItemId(int i) {
        return list.get(i).getNum();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if(convertView == null){
            convertView=inflater.inflate(layoutRes, viewGroup, false);
        }
        // position 에 해당하는 GalleryDto 를 얻어내서
        GalleryDto dto=list.get(position);
        ImageView imageView=convertView.findViewById(R.id.imageView);
        TextView textWriter=convertView.findViewById(R.id.writer);
        TextView textCaption=convertView.findViewById(R.id.caption);
        TextView textRegdate=convertView.findViewById(R.id.regdate);

        textWriter.setText(dto.getWriter());
        textCaption.setText(dto.getCaption());
        textRegdate.setText(dto.getRegdate());

        //  이미지 출력
        Glide.with(context)
                .load(dto.getImagePath())
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageView);
        return convertView;
    }

}
