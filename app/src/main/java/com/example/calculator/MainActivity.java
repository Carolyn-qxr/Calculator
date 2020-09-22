package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    Button jia,jian,cheng,chu,delete,clear,point,percent,equal;
    Button left,right,ln,square,sin,cos,length,cube,tan,jiecheng,sqrt,help;
    TextView text;//用来显示输入的数据
    String input="";
    double num1,num2,num3;
    double sum1,sum2,sum3;
    String result;
    final double pi=3.1415926;
    private boolean clear_flag=false;
    private String str;

    StringBuilder stringBuilder = new StringBuilder();
    boolean isclick=false;
    int op=0;//运算符的标志

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //利用log视察横竖屏状态，并初始化组件
        //横竖屏组件个数不一样，不用同一个方法，避免空指针
        int orientation;
        orientation=getResources().getConfiguration().orientation;
        Log.d("----",""+orientation);
        int mcurrentOrientation=getResources().getConfiguration().orientation;
        //竖屏
        if(mcurrentOrientation==Configuration.ORIENTATION_PORTRAIT){
            Log.i("info","portrait");
            initView_por();
            initEvent_por();
        }else if(mcurrentOrientation==Configuration.ORIENTATION_LANDSCAPE){
            Log.i("info","landscape");
            initView_land();
            initEvent_land();
        }

    }
    private void initView_land() {
        btn1=(Button)findViewById(R.id.button1);
        btn2=(Button)findViewById(R.id.button2);
        btn3=(Button)findViewById(R.id.button3);
        btn4=(Button)findViewById(R.id.button4);
        btn5=(Button)findViewById(R.id.button5);
        btn6=(Button)findViewById(R.id.button6);
        btn7=(Button)findViewById(R.id.button7);
        btn8=(Button)findViewById(R.id.button8);
        btn9=(Button)findViewById(R.id.button9);
        //加减乘除
        jia=(Button)findViewById(R.id.buttonAdd);
        jian=(Button)findViewById(R.id.buttonSub);
        cheng=(Button)findViewById(R.id.multiply);
        chu=(Button)findViewById(R.id.divider);
        //横屏其他功能
        delete=(Button)findViewById(R.id.delete);
        clear=(Button)findViewById(R.id.C);
        equal=(Button)findViewById(R.id.equal);
        //横屏其他功能
        left=(Button)findViewById(R.id.left);
        right=(Button)findViewById(R.id.right);
        ln=(Button)findViewById(R.id.ln);
        square=(Button)findViewById(R.id.square);
        sin=(Button)findViewById(R.id.sin);
        cos=(Button)findViewById(R.id.cos);
        length=(Button)findViewById(R.id.length) ;
        cube=(Button)findViewById(R.id.cube);
        tan=(Button)findViewById(R.id.tan);
        jiecheng=(Button)findViewById(R.id.jiecheng);
        sqrt=(Button)findViewById(R.id.sqrt);
        help=(Button)findViewById(R.id.help);
        //显示框
        text=(TextView)findViewById(R.id.textView);
    }
    private void initEvent_land() {
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

        jia.setOnClickListener(this);
        jian.setOnClickListener(this);
        cheng.setOnClickListener(this);
        chu.setOnClickListener(this);

        delete.setOnClickListener(this);
        clear.setOnClickListener(this);
        equal.setOnClickListener(this);
        left.setOnClickListener(this);
        right.setOnClickListener(this);
        ln.setOnClickListener(this);
        square.setOnClickListener(this);
        sin.setOnClickListener(this);
        cos.setOnClickListener(this);
        length.setOnClickListener(this);
        cube.setOnClickListener(this);
        tan.setOnClickListener(this);
        jiecheng.setOnClickListener(this);
        sqrt.setOnClickListener(this);
        help.setOnClickListener(this);
    }

    //竖屏初始化
    private void initView_por() {
        btn0=(Button)findViewById(R.id.button0);
        btn1=(Button)findViewById(R.id.button1);
        btn2=(Button)findViewById(R.id.button2);
        btn3=(Button)findViewById(R.id.button3);
        btn4=(Button)findViewById(R.id.button4);
        btn5=(Button)findViewById(R.id.button5);
        btn6=(Button)findViewById(R.id.button6);
        btn7=(Button)findViewById(R.id.button7);
        btn8=(Button)findViewById(R.id.button8);
        btn9=(Button)findViewById(R.id.button9);
        //加减乘除
        jia=(Button)findViewById(R.id.buttonAdd);
        jian=(Button)findViewById(R.id.buttonSub);
        cheng=(Button)findViewById(R.id.multiply);
        chu=(Button)findViewById(R.id.divider);
        //竖屏其他功能
        delete=(Button)findViewById(R.id.delete);
        clear=(Button)findViewById(R.id.C);
        equal=(Button)findViewById(R.id.equal);
        point=(Button)findViewById(R.id.point);
        percent=(Button)findViewById(R.id.percent);
        //显示框
        text=(TextView)findViewById(R.id.textview);
    }

    private void initEvent_por() {
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        jia.setOnClickListener(this);
        jian.setOnClickListener(this);
        cheng.setOnClickListener(this);
        chu.setOnClickListener(this);
        delete.setOnClickListener(this);
        clear.setOnClickListener(this);
        equal.setOnClickListener(this);
        point.setOnClickListener(this);
        percent.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {

        str=text.getText().toString();
        Log.v("Tag","click");
        switch (view.getId()){
            case R.id.button0:
            case R.id.button1:
            case R.id.button2:
            case R.id.button3:
            case R.id.button4:
            case R.id.button5:
            case R.id.button6:
            case R.id.button7:
            case R.id.button8:
            case R.id.button9:
            case R.id.point:
                str+= ((Button)view).getText();
                text.setText(str);
                break;
            case R.id.divider:
            case R.id.multiply:
            case R.id.buttonAdd:
            case R.id.buttonSub:
                str+=((Button)view).getText();
                text.setText(str);
                break;
            //单个删除    
            case R.id.delete:
                if(str!=null && !str.equals("")){
                   text.setText(str.substring(0,str.length()-1));
                }
                break;
            //百分号    
            case R.id.percent:
                if(str.length()!=0){
                    result=Double.toString((Double.parseDouble(str))/100.0);
                }else if(str.length()==0){
                    result="error!";
                    text.setText(result);
                    return;

                }
                text.setText(result);
                break;
            //清零    
            case R.id.C:
                str="";
                text.setText(str);
                break;
            //等号
            case R.id.equal:
                str+=((Button)view).getText();
                getResult();
                break;
            case R.id.square:
                if(str.length()!=0){
                    Double temp=Double.parseDouble(str);
                    result=Double.toString(temp*temp);

                }else{
                    result="error!";
                }
                text.setText(result);
                break;
            case R.id.jiecheng:
                if(str.length()!=0){
                    double temp=Double.parseDouble(str);
                    double flag=1;
                    for(int i=0;(temp-flag)>0;i++){

                    }
                }
            case R.id.sqrt:
            case R.id.left:
            case R.id.right:
            case R.id.ln:
            case R.id.sin:
            case R.id.cos:
            case R.id.tan:
            case R.id.length:
            case R.id.cube:
            case R.id.help:
        }
    }

    private void getResult() {
    }

}