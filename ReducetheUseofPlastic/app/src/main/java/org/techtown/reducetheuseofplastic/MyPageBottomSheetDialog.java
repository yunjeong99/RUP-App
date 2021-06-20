package org.techtown.reducetheuseofplastic;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class MyPageBottomSheetDialog extends BottomSheetDialogFragment implements View.OnClickListener{

    public static MyPageBottomSheetDialog getInstance() { return new MyPageBottomSheetDialog(); }

    private Button btn_modify, btn_point_return, btn_notice, btn_service, btn_logout;
    MyCustomDialogFragment myCustomDialogFragment;
    //private Dialog dialog1, dialog2, dialog3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.mypage_bottomsheet,container, false);

        btn_modify=(Button)view.findViewById(R.id.btn_modify);
        btn_point_return=(Button)view.findViewById(R.id.btn_point_return);
        btn_notice=(Button)view.findViewById(R.id.btn_notice);
        btn_service=(Button)view.findViewById(R.id.btn_service);
        btn_logout=(Button)view.findViewById(R.id.btn_logout);

        btn_modify.setOnClickListener(this);
        btn_point_return.setOnClickListener(this);
        btn_notice.setOnClickListener(this);
        btn_service.setOnClickListener(this);
        btn_logout.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_modify:
                Toast.makeText(getContext(),"개인정보수정", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_point_return:
                Toast.makeText(getContext(),"포인트 반환하기",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_notice:
                Toast.makeText(getContext(),"공지사항",Toast.LENGTH_SHORT).show();

                break;
            case R.id.btn_service:
                Toast.makeText(getContext(),"고객센터",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_logout:
                Toast.makeText(getContext(),"로그아웃",Toast.LENGTH_SHORT).show();
                break;
        }
    }




}



