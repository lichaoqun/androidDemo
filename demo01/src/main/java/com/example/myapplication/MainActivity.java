package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mLoginBtn;
    private EditText mUseNameET;
    private EditText mPasswordET;
    private int REQUEST_CODEO = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // - findViewById 方法调用, 必须写在需要查找的 view 的父视图上
        mUseNameET = findViewById(R.id.user_name);
        mPasswordET = findViewById(R.id.password);
        mLoginBtn = findViewById(R.id.loginBtn);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  - 使用  MainActivity.this 以为这个是是个匿名类, 我们需要传递的是 MainActivity 对象
                // - 使用 Intent [3 - 1]  的值的回传
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                Bundle bundle = new Bundle();
                bundle.putString("userName", mUseNameET.getText().toString());
                bundle.putString("password", mPasswordET.getText().toString());
                intent.putExtras(bundle);
                startActivityForResult(intent, REQUEST_CODEO);
                // - 如果不用回传值 可以直接用下边的方法
                // startActivity(intent);
            }
        });

    }


    @Override
    // - 使用 Intent [3 - 3]  的值的回传
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODEO){
            String msg = data.getStringExtra("msg");
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        }
    }
}
