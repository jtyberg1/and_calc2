package com.example.user.myapp;

import android.content.Context;
import android.icu.util.LocaleData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context ctx = MainActivity.this; // 설정값. 즉 메모리상에서의 위치
        // .this indicates its location. MainActivity.this means this class's location.
        final EditText num = findViewById(R.id.num);

        final TextView result = findViewById(R.id.result);
        //inner class : 계산기 설정
        class Calc{
            private int num,res; // instance's variable;
            private String op;
            /*public void exe(){
                switch (op){
                    case "+": res = num1 + num2 ; break;
                    case "-": res = num1 - num2; break;
                    case "*": res = num1 * num2; break;
                    case "/": res = num1 / num2; break;
                }
            }*/
            public void setNum(int num){this.num=num;}
            public int getNum(){return this.num;}
            public void setOp(String op){this.op=op;}
            public String getOp(){return op;}
            public void setRes(int res){this.res=res;}
            public int getRes(){return this.res;}
        } // end of Calc class

        final Calc calc = new Calc(); // calc instance


        findViewById(R.id.addBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int a = Integer.parseInt(num.getText().toString());
                Log.d("입력값1",a+"");
                calc.setNum(a);
                calc.setOp("+");
                //calc.exe();
            }
        });
        findViewById(R.id.subtractBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int a = Integer.parseInt(num.getText().toString());
                calc.setNum(a);
                calc.setOp("-");
                //calc.exe();
            }
        });
        findViewById(R.id.multiplyBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int a = Integer.parseInt(num.getText().toString());
                calc.setNum(a);
                calc.setOp("*");
                //calc.exe();
            }
        });
        findViewById(R.id.divideBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int a = Integer.parseInt(num.getText().toString());
                calc.setNum(a);
                calc.setOp("/");
                //calc.exe();
            }
        });
        findViewById(R.id.equalsBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx,"결과: "+calc.getRes(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}
