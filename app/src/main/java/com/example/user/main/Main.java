package com.example.user.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main extends AppCompatActivity implements View.OnClickListener {
    private Button btn1;
    private Button btn2;
    private Button btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btn1=(Button)findViewById(R.id.button);
        btn2=(Button)findViewById(R.id.button2);
        btn3=(Button)findViewById(R.id.button3);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.button:
                Intent intent=new Intent(v.getContext(),MainActivity.class);
                startActivity(intent);
                break;
            case R.id.button2:
                Intent intent2=new Intent(v.getContext(),ImageGridActivity.class);
                startActivity(intent2);
                break;
            case R.id.button3:
                Intent intent3=new Intent(v.getContext(),FActivity.class);
                startActivity(intent3);
                break;
        }
    }
}
