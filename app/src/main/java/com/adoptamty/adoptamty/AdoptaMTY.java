package com.adoptamty.adoptamty;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.RecoverySystem;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class AdoptaMTY extends AppCompatActivity implements View.OnClickListener {
private RelativeLayout iniciar;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adopta_mty);
        Toast.makeText(AdoptaMTY.this,"Versión 1.0.", Toast.LENGTH_SHORT).show();
        iniciar = (RelativeLayout)findViewById(R.id.ll);
        iniciar.setOnClickListener(this);
    }

    public void login() {
        Intent i = new Intent(this, Login.class);
        startActivity(i);
        finish();
    }
    @Override
    public void onClick(View v) {
        login();
    }

}