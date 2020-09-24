package com.example.calculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

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
            case R.id.left:
            case R.id.right:
            case R.id.divider:
            case R.id.multiply:
            case R.id.buttonAdd:
            case R.id.buttonSub:
                str+= ((Button)view).getText();
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
                    for(int i=0;(temp-i)>0;i++){
                        flag*=(temp-i);
                    }
                    result=Double.toString(flag);
                }else
                    result="0";
                text.setText(result);
                break;
            case R.id.sqrt:
                if(str.length()!=0){
                    double temp=Double.parseDouble(str);
                    result=Double.toString(Math.sqrt(temp));
                }else
                    result="0";
                text.setText(result);
                break;
            case R.id.ln:
                if(str.length()!=0){
                    double temp=Double.parseDouble(str);
                    result=Double.toString(Math.log(temp));
                }else{
                    result="0";
                }
                text.setText(result);
                break;
            case R.id.sin:
                if(str.length()!=0){
                    double temp=Double.parseDouble(str);
                    result=Double.toString(Math.sin(pi/180*temp));
                 }else{
                    result="0";
                }
                text.setText(result);
                break;
            case R.id.cos:
                if(str.length()!=0){
                    double temp=Double.parseDouble(str);
                    result=Double.toString(Math.cos(pi/180*temp));
                }else{
                    result="0";
                }
                text.setText(result);
                break;
            case R.id.tan:
                if(str.length()!=0){
                    double temp=Double.parseDouble(str);
                    result=Double.toString(Math.tan(pi/180*temp));
                }else{
                    result="0";
                }
                text.setText(result);
                break;
            case R.id.length:
                if(str.length()!=0){
                    double temp=Double.parseDouble(str);
                    result=Double.toString(temp/100);
                }else{
                    result="0";
                }
                text.setText(result);
                break;
            case R.id.cube:
                if(str.length()!=0){
                    double temp=Double.parseDouble(str);
                    result=Double.toString(temp/1000000);
                }else{
                    result="0";
                }
                text.setText(result);
                break;

            case R.id.help:
                AlertDialog alertDialog1 = new AlertDialog.Builder(this)
                        .setTitle("帮助")//标题
                        .setMessage("这是一个普通的计算器")//内容
                        .setIcon(R.mipmap.ic_launcher)//图标
                        .create();
                alertDialog1.show();
                break;

        }
    }

    private void getResult() {
        //查找是否存在符号，若有则运算，没有则直接返回
        if(str==null || str.equals("")){
            return;
        }
        if('-'==str.charAt(0))
            str=0+str;

        if(!MyUtils.check(str)){
            text.setText("表达式错误");
        }
        //处理表达式改为标准表达式
        str=MyUtils.change(str);

        //拆分字符和数字
        String []nums = str.split("[^.0-9]");
        ArrayList numlist = new ArrayList();
        for(int i=0;i<nums.length;i++){
            if(!"".equals(nums[i]))
                numlist.add(Double.parseDouble(nums[i]));
        }

        String symStr=str.replaceAll("[.0-9]","");

        Calculate(symStr,numlist);

    }

    private void Calculate(String symStr, ArrayList numlist) {
        LinkedList<Character> symstack=new LinkedList<>();//符号栈
        LinkedList<Double> numStack = new LinkedList<>();//数字栈
        double result=0;
        int i=0;//numlist的标志位
        int j=0;//symStr的标志位
        char symbol;
        double num1,num2;
        //符号前后两个数
        while(symstack.isEmpty() || !(symstack.getLast()=='=' && symStr.charAt(j)=='=')){
            if(symstack.isEmpty()){
                symstack.add('=');
                numStack.add((Double)numlist.get(i++));
            }
            if(MyUtils.map.get(symStr.charAt(j))> MyUtils.map.get(symstack.getLast())){
                if(symStr.charAt(j)=='('){
                    symstack.add(symStr.charAt(j++));
                    continue;
                }
                numStack.add((Double)numlist.get(i++));
                symstack.add(symStr.charAt(j++));
            }else{
                if(symStr.charAt(j)==')' && symstack.getLast()=='('){
                    j++;
                    symstack.removeLast();
                    continue;
                }
                if(symstack.getLast()=='('){
                    numStack.add((Double)numlist.get(i++));
                    symstack.add(symStr.charAt(j++));
                    continue;
                }
                num2=numStack.removeLast();
                num1=numStack.removeLast();
                symbol=symstack.removeLast();
                switch (symbol){
                    case '+':
                        numStack.add(num1+num2);
                        break;
                    case '-':
                        numStack.add(num1-num2);
                        break;
                    case '×':
                        numStack.add(num1*num2);
                        break;
                    case '÷':
                        if(num2==0){
                            text.setText("error!");
                            return;
                        }
                        numStack.add(num1/num2);
                        break;
                }
            }
        }
        String string  = numStack.removeLast()+"";
        text.setText(string);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // 这条表示加载菜单文件，第一个参数表示通过那个资源文件来创建菜单
        // 第二个表示将菜单传入那个对象中。这里我们用Menu传入menu
        // 这条语句一般系统帮我们创建好
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    // 菜单的监听方法
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int mCurrentOrientation = getResources().getConfiguration().orientation;
        switch (item.getItemId()) {
            case R.id.jinzhi:
                Toast.makeText(this, "进制转换", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,MainActivity_jinzhi.class);
                startActivity(intent);
                break;
            default:
                break;
        }
        return true;

    }


}
class MyUtils{
    public static final Map<Character,Integer> map = new HashMap<>();
    static {
        map.put('=',0);
        map.put('-',1);
        map.put('+',1);
        map.put('×',2);
        map.put('÷',2);
        map.put('(',3);
        map.put(')',1);
    }
    /*
   检查表达式格式
    */
    public static boolean check(String str){
        if(!(isCharNum(str.charAt(0)) || str.charAt(0)=='(')){
            return false;
        }
        for(int i=1;i<str.length()-1;i++) {
            char c;
            c = str.charAt(i);
            if (!(isCharNum(c))) {
                if (c == '(' || c == '+' || c == '×' || c == '÷') {
                    if (c == '-' && str.charAt(i - 1) == '(') {
                        continue;
                    }
                    if (!(isCharNum(str.charAt(i - 1)) || str.charAt(i - 1) == ')')) {
                        return false;
                    }
                }
                if (c == '.') {
                    if (!isCharNum(str.charAt(i - 1)) || !isCharNum(str.charAt(i + 1))) {
                        return false;
                    }

                }
            }
        }
        return isCouple(str);
    }
    /*
    处理表达式格式为标准格式，2(-1+2)(3+4)改为2*(0-1+2)*(3+4)
     */
    public static String change(String str){
        StringBuilder sb = new StringBuilder();
        char c;
        for(int i=0;i<str.length();i++){
            c=str.charAt(i);
            if(i!=0&&c=='(' &&(isCharNum(str.charAt(i-1)) || str.charAt(i-1)==')')){
                sb.append("×(");
                continue;
            }
            if(c=='-'&&str.charAt(i-1)=='('){
                sb.append("0-");
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }
    /*
    判断括号是否配对
     */
    private static boolean isCouple(String str){
        LinkedList<Character> list = new LinkedList<>();
        for(char c:str.toCharArray()){
            if(c=='('){
                list.add(c);
            }else if(c==')'){
                if(list.isEmpty()){
                    return false;
                }
                list.removeLast();
            }
        }
        if(list.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    /*
    判断是否为数字
     */
    public static boolean isCharNum(Character c){
        if(c>='0' && c<=9){
            return true;
        }
        return false;
    }


}