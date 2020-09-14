package com.je1224.numberbaseball;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
    }

    public void howGame(View view) {
    AlertDialog.Builder builder=new AlertDialog.Builder(this);
    builder.setTitle("게임 방법");
    builder.setMessage(R.string.game);
    AlertDialog dialog=builder.create();
    dialog.show();
    }

    public void startGame(View view) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void endGame(View view) {
        finish();
    }
}
