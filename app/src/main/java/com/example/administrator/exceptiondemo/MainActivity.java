package com.example.administrator.exceptiondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import crashException.CrashHandler;

public class MainActivity extends AppCompatActivity {

    private String TAG=MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        throw new NullPointerException();
    }
}
