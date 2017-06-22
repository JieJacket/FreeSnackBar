package com.jekyll.wu.widget;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnOne, btnTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOne = (Button) findViewById(R.id.btn_one);
        btnTwo = (Button) findViewById(R.id.btn_two);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_one:
                FreeSnackBar
                        .make(btnOne, "this is a normal Snackbar", FreeSnackBar.LENGTH_SHORT)
                        .show();
                break;
            case R.id.btn_two:
                FreeSnackBar.make(btnTwo, "this is a customizated Snackbar", FreeSnackBar.LENGTH_INDEFINITE)
                        .setBackgroundColor(Color.parseColor("#345678"))
                        .setActionTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent))
                        .setAction("取消", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(getApplicationContext(), "你按了取消按钮", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .top()
                        .show();
                break;
            default:
                break;
        }
    }
}
