package com.example.user.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by user on 2017-12-28.
 */

public class SplashActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        try{
            Thread.sleep(4000);

        }catch(InterruptedException e){
            e.printStackTrace();
        }
        startActivity(new Intent(this,Main.class));
        finish();
    }
}
