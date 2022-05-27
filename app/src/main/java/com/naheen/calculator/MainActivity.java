package com.naheen.calculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String oldNumber="";
    String op="+";
    boolean isNewOperator=true;
    EditText ed1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1=findViewById(R.id.ed1);
    }

    public void numberEvent(View view) {
        if(isNewOperator)
            ed1.setText("");
        isNewOperator=false;
        String number=ed1.getText().toString();
        switch (view.getId())
        {
            case R.id.btn1:
                number+=1;
                break;
            case R.id.btn2:
                number+=2;
                break;
            case R.id.btn3:
                number+=3;
                break;
            case R.id.btn4:
                number+=4;
                break;
            case R.id.btn5:
                number+=5;
                break;
            case R.id.btn6:
                number+=6;
                break;
            case R.id.btn7:
                number+=7;
                break;
            case R.id.btn8:
                number+=8;
                break;
            case R.id.btn9:
                number+=9;
                break;
            case R.id.btn0:
                number+=0;
                break;
            case R.id.btnDot:
                number+=".";
                break;
            case R.id.btnPlusMinus:
                number = "-"+number;
                break;

            case R.id.default_activity_button:
                Context context=getApplicationContext();
                Toast.makeText(context,"Please Enter Valid Input!",Toast.LENGTH_SHORT).show();
        }
        ed1.setText(number);
    }

    public void operatorEvent(View view) {
        //isNewOperator=true;
        oldNumber=ed1.getText().toString();
        switch (view.getId()){
            case R.id.btnDivide:
                ed1.setText(oldNumber+" / ");
                op="/";
                break;
            case R.id.btnMultiply:
                ed1.setText(oldNumber+" * ");
                op="*";
                break;
            case R.id.btnPlus:
                ed1.setText(oldNumber+" + ");
                op="+";
                break;
            case R.id.btnMinus:
                ed1.setText(oldNumber+" - ");
                op="-";
                break;
            case R.id.default_activity_button:
                Context context=getApplicationContext();
                Toast.makeText(context,"Please Enter Valid Input!",Toast.LENGTH_SHORT).show();
        }
    }

    public void equalEvent(View view) {
        String newNumber=ed1.getText().toString();
        int l=newNumber.indexOf(op);
        oldNumber=newNumber.substring(0,l);
        newNumber=newNumber.substring(l+1,newNumber.length());
        double result=0.0;
        switch (op){
            case "+":
                result=Double.parseDouble(oldNumber)+Double.parseDouble(newNumber);
                break;
            case "-":
                result=Double.parseDouble(oldNumber)-Double.parseDouble(newNumber);
                break;
            case "*":
                result=Double.parseDouble(oldNumber)*Double.parseDouble(newNumber);
                break;
            case "/":
                result=Double.parseDouble(oldNumber)/Double.parseDouble(newNumber);
                break;
        }
        ed1.setText(result+"");
    }

    public void acEvent(View view) {
        ed1.setText("0");
        isNewOperator=true;
    }

    public void perEvent(View view) {
        double no=Double.parseDouble(ed1.getText().toString())/100;
        ed1.setText(no+"");
        isNewOperator=true;
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Really Exit?")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, (arg0, arg1) -> {

                    MainActivity.super.onBackPressed();
                    finish();
                    System.exit(0);
                }).create().show();
    }
}