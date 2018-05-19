package com.example.iram_sagor.radio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int playerOne=0,playerTwo=0;

    public void onRadioButtonClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()){
            case R.id.rumpa:
                if(checked){
                    playerOne=1;
                    break;
                }
            case R.id.lisan:
                if(checked){
                    playerOne=2;
                    break;
                }
            case R.id.misty:
                if(checked){
                    playerOne=3;
                    break;
                }
        }

    }
    public void onRadioButtonClicked1(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()){
            case R.id.rumpa:
                if(checked){
                    playerTwo=1;
                    break;
                }
            case R.id.lisan:
                if(checked){
                    playerTwo=2;
                    break;
                }
            case R.id.misty:
                if(checked){
                    playerTwo=3;
                    break;
                }
        }

    }

    public void play(View view){
        if(playerOne!=0 && playerTwo!=0 && playerOne!=playerTwo){


        Intent i  = new Intent(getApplicationContext(),Main2Activity.class);
        i.putExtra("playerone",playerOne);
        i.putExtra("playertwo",playerTwo);
        startActivity(i);
        }
        else{

            Toast.makeText(getApplicationContext(), "Click Option Properly!!!",
                    Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //playerOne=0;playerTwo=0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
