package com.geektech.calculator;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

public class SecondActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        button = findViewById(R.id.button);

        String text = getIntent().getStringExtra("key");
        if (findViewById(R.id.textView) instanceof TextView){
            ((TextView) findViewById(R.id.textView)).setText(text);
        }
    }

    public void destroy(View view) {
        finish();
        MainActivity.activity.finish();
    }
}