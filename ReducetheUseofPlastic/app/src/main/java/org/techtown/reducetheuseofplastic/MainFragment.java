package org.techtown.reducetheuseofplastic;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;

public class MainFragment extends Fragment {

    String userEmail;
    MainActivity mainActivity;
    Context context;
    float MyCupPoint= 0.0f;
    Button btn_test;
    TextView tv_cuppoint;
    int cuppoint=0;
    private ImageButton btn_point_alarm, btn_mypage;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity=(MainActivity)getActivity();
        System.out.println("프래그먼트 홈");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mainActivity=null;
        System.out.println("프래그먼트 홈 떨어졌다");

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView=(ViewGroup)inflater.inflate(R.layout.main_fragment, container, false);

        btn_test=(Button)rootView.findViewById(R.id.btn_test);
        btn_mypage=(ImageButton)rootView.findViewById((R.id.btn_mypage));
        btn_point_alarm=(ImageButton)rootView.findViewById(R.id.btn_alarm);
        tv_cuppoint=(TextView)rootView.findViewById(R.id.tv_cuppoint);

        context=container.getContext();

        btn_mypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), MyPageActivity.class);
                startActivity(intent);
            }
        });
/*
        btn_point_alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("toast","1");
                LayoutInflater layoutInflater=getLayoutInflater();
                View view_l=inflater.inflate(R.layout.point_save, (ViewGroup)getView().findViewById(R.id.toast_layout));
                Log.d("toast","2");
                TextView tv_toast_point=view_l.findViewById(R.id.tv_toast_point);
                Toast toast=new Toast(context);
                Log.d("toast","3");
                tv_toast_point.setText("??점이 적립되었습니다.");
                tv_toast_point.setTextSize(15);
                tv_toast_point.setTextColor(Color.BLACK);
                toast.setGravity(Gravity.CENTER_HORIZONTAL,0,0);
                toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(view_l);
                toast.show();
            }
        });

 */

        LottieAnimationView animationView=(LottieAnimationView) rootView.findViewById(R.id.like_btn);
        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyCupPoint+=0.05f;
                cuppoint+=1;//*(나중에설정)파이어베이스에서 값 불러와야함
                tv_cuppoint.setText("cuppoint:"+cuppoint);


                //animationView.setProgress(0.5f);
                ValueAnimator animator=ValueAnimator.ofFloat(0f,MyCupPoint).setDuration(1000);
                animator.addUpdateListener(animation -> {
                    animationView.setProgress((Float) animation.getAnimatedValue());
                });
                animator.start();
            }
        });






        if(getArguments()!=null){
            userEmail=getArguments().getString("userEmail");
            System.out.println(userEmail);

        }
        return rootView;
    }
}