package com.example.youngtec.flashlight;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //宣告boolean IsOpen為false
    protected boolean IsOpen = false;
    //Cameea flashlight
    private CameraManager manager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     //call SystemService:CAMERA
        manager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        //setting ClickListener for button
        Button Button1 = (Button) findViewById(R.id.btn_give_me_a_light);//get layout/activity_main.xml,btn id
        Button1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if(!IsOpen)//IsOpen==false
                {
                    try
                    {
                    manager.setTorchMode("0", true);//true=open

                    }
                    catch (CameraAccessException e)
                    {
                    e.printStackTrace();
                    } IsOpen=true;//Change boolean
                }
                else
                {
                    try
                    {
                        manager.setTorchMode("0", false);//false=close
                    }
                    catch (CameraAccessException e)
                    {
                        e.printStackTrace();
                    }
                    IsOpen=false;//Change boolean
                }
            }
        });
    }
}
