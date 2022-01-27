package com.geektech.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private Double firstVar;
    private Double secondVar;
    private Boolean isOperationClick;
    private String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = findViewById(R.id.tv_result);
    }

    public void onNumberClick(View view) {
        switch (view.getId()){
            case R.id.btn_one:
                setNumber("1");
                break;
            case R.id.btn_two:
                setNumber("2");
                break;
            case R.id.btn_three:
                setNumber("3");
                break;
            case R.id.btn_four:
                setNumber("4");
                break;
            case R.id.btn_five:
                setNumber("5");
                break;
            case R.id.btn_six:
                setNumber("6");
                break;
            case R.id.btn_seven:
                setNumber("7");
                break;
            case R.id.btn_eight:
                setNumber("8");
                break;
            case R.id.btn_nine:
                setNumber("9");
                break;
            case R.id.btn_dot:
                if (tvResult.toString().endsWith(".")){
                    break;
                }
                else{
                    tvResult.append(".");
                }
                break;
            case R.id.btn_zero:
                if (tvResult.getText().toString().equals("0")){
                    break;
                }
                else if (isOperationClick){
                    tvResult.setText("0");
                }
                else {
                    tvResult.append("0");
                }
                break;
            case R.id.btn_clear:
                tvResult.setText("0");
                firstVar = 0.0;
                secondVar = 0.0;
                break;
        }
    }

    private void setNumber(String number){
        if (tvResult.getText().toString().equals("0")){
            tvResult.setText(number);
        }else if (isOperationClick) {
            tvResult.setText(number);
        }
        else {
            tvResult.append(number);
        }
        isOperationClick = false;
    }

    public void onOperationClick(View view) {
        switch (view.getId()){
            case R.id.btn_plus:
                //11
                firstVar = Double.parseDouble(tvResult.getText().toString());
                isOperationClick = true;
                operation = "+";
                break;
            case R.id.btn_minus:
                firstVar = Double.parseDouble(tvResult.getText().toString());
                isOperationClick = true;
                operation = "-";
                break;
            case R.id.btn_multiply:
                firstVar = Double.parseDouble(tvResult.getText().toString());
                isOperationClick = true;
                operation = "*";
                break;
            case R.id.btn_divide:
                firstVar = Double.parseDouble(tvResult.getText().toString());
                isOperationClick = true;
                operation = "/";
                break;
            case R.id.btn_equal:
                secondVar = Double.parseDouble(tvResult.getText().toString());
                Double result = 0.0;
                switch (operation){
                    case "+":
                        result = firstVar + secondVar;
                        break;
                    case "-":
                        result = firstVar - secondVar;
                        break;
                    case "*":
                        result = firstVar * secondVar;
                        break;
                    case "/":
                        result = firstVar / secondVar;
                        break;
                }
                if (result.toString().endsWith(".0")){
                    tvResult.setText(result.toString().replace(".0", ""));
                }
                else {
                    tvResult.setText(result.toString());
                }
                firstVar = 0.0;
                secondVar = 0.0;
                isOperationClick = true;
                break;
        }
    }
}