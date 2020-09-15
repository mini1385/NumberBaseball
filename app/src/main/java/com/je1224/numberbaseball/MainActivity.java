package com.je1224.numberbaseball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    EditText et1,et2,et3;
    Button btn_retry, btn_in;

    // 스트라이크 볼
    int strike;
    int ball;

    // 랜덤값
    int com1,com2,com3;

    // 유저값 배열 생성
    int[] user=new int[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        et3=findViewById(R.id.et3);
        btn_retry = findViewById(R.id.btn_retry);
        btn_in = findViewById(R.id.btn_in);

        // 랜덤값 지정
        Random rnd= new Random();
        do{
            com1=rnd.nextInt(10);
            com2=rnd.nextInt(10);
            com3=rnd.nextInt(10);
        }while(com1==com2 || com1==com3 || com2==com3);

        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strike=0;
                ball=0;
                String buf="";

                // EditText값 불러오기, int형 변환
                String str1 = et1.getText().toString();
                int user1=Integer.parseInt(str1);
                String str2 = et2.getText().toString();
                int user2=Integer.parseInt(str2);
                String str3 = et3.getText().toString();
                int user3=Integer.parseInt(str3);

                user[0]=user1;
                user[1]=user2;
                user[2]=user3;

                if(user1==com1) strike++;
                else if(user1==com2 || user1==com3) ball++;

                if(user2==com2) strike++;
                else if(user2==com1 || user2==com3) ball++;

                if(user3==com3) strike++;
                else if(user3==com1 || user3==com2) ball++;

                buf=String.format("%d%d%d  : %d Strike, %d Ball\n",user1,user2,user3,strike, ball);
                tv.append(buf);

                if(strike==3){
                    tv.append("정답입니다!");
                    btn_in.setEnabled(false);
                }
            }
        };
        btn_in.setOnClickListener(listener);

        View.OnClickListener listener2=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rnd= new Random();
                do{
                    com1=rnd.nextInt(10);
                    com2=rnd.nextInt(10);
                    com3=rnd.nextInt(10);
                }while(com1==com2 || com1==com3 || com2==com3);

                tv.setText("");
                et1.setText("");
                et2.setText("");
                et3.setText("");
                btn_in.setEnabled(true);
            }
        };
        btn_retry.setOnClickListener(listener2);
    }
}
