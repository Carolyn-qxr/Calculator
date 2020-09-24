package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity_jinzhi extends AppCompatActivity implements View.OnClickListener {

    private Spinner spinner;
    private TextView num1;
    private TextView num2;
    private TextView num3;
    private EditText input;
    Button change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_jinzhi2);
        //界面控件初始化
        num1 = (TextView) findViewById(R.id.num1);
        num2 = (TextView) findViewById(R.id.num2);
        num3 = (TextView) findViewById(R.id.num3);
        input = (EditText) findViewById(R.id.input);
        change = (Button) findViewById(R.id.change);
        change.setOnClickListener(this);

        spinner = findViewById(R.id.spinner);
    }

    @Override
    public void onClick(View view) {
        String temp = "0";
        temp = input.getText().toString();
        int ten = 0;
        String two = "0", eight = "0", sixteen = "0";
        String info = (String) spinner.getSelectedItem();
        if (info.equals("二进制")) {
            ten = Integer.parseInt(temp, 2);
            eight=Integer.toOctalString(ten);
            sixteen=Integer.toHexString(ten);
            num1.setText("八进制："+eight);
            num2.setText("十进制："+ten+"");
            num3.setText("十六进制："+sixteen);
        }else if(info.equals("八进制")){
            ten=Integer.parseInt(temp,8);
            two=Integer.toBinaryString(ten);
            sixteen=Integer.toHexString(ten);
            num1.setText("二进制："+two);
            num2.setText("十进制："+ten+"");
            num3.setText("十六进制："+sixteen);
        }else if(info.equals("十进制")){
            ten=Integer.parseInt(temp);
            two=Integer.toBinaryString(ten);
            eight=Integer.toOctalString(ten);
            sixteen=Integer.toHexString(ten);
            num1.setText("二进制："+two);
            num2.setText("八进制："+eight);
            num3.setText("十六进制："+sixteen);
        }else{
            ten=Integer.parseInt(temp,16);
            two=Integer.toBinaryString(ten);
            eight=Integer.toOctalString(ten);
            num1.setText("二进制："+two);
            num2.setText("八进制："+eight);
            num3.setText("十进制："+ten);
        }

    }
}
