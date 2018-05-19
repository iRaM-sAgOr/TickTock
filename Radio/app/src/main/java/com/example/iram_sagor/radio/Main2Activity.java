package com.example.iram_sagor.radio;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.text.Layout;
import android.widget.TextView;
import android.content.Intent;

public class Main2Activity extends AppCompatActivity {

  int firstplayer,secondplayer;
    //0==yellow,1=red;
    int activePlayer = 0;
    boolean active =true;
    // 2 means unpalyed;
    int  gameState[]={2,2,2,2,2,2,2,2,2};
    int winnerPositions[][]={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void dropIn(View view){
        ImageView counter =(ImageView) view;
        //System.out.println(counter.getTag().toString());

        int tappedCounter=Integer.parseInt(counter.getTag().toString());

        if(gameState[tappedCounter]==2 && active)  {
            counter.setTranslationY(-1000f);

            if (activePlayer == 0 && firstplayer==1) {
                counter.setImageResource(R.drawable.rumpa);
                gameState[tappedCounter]=0;
                activePlayer = 1;
            }
            else if (activePlayer == 0 && firstplayer==2) {
                counter.setImageResource(R.drawable.lisan);
                gameState[tappedCounter]=0;
                activePlayer = 1;
            }
            else if (activePlayer == 0 && firstplayer==3) {
                counter.setImageResource(R.drawable.misty);
                gameState[tappedCounter]=0;
                activePlayer = 1;
            }

            else if(activePlayer == 1 && secondplayer==1) {
                counter.setImageResource(R.drawable.rumpa);
                gameState[tappedCounter]=1;
                activePlayer = 0;
            }
            else if (activePlayer == 1 && secondplayer==2){
                counter.setImageResource(R.drawable.lisan);
                gameState[tappedCounter]=1;
                activePlayer = 0;
            }


            else if(activePlayer == 1 && secondplayer==3) {
                counter.setImageResource(R.drawable.misty);
                gameState[tappedCounter]=1;
                activePlayer = 0;
            }

            counter.animate().translationYBy(1000f).setDuration(100);
            for(int winnerPosition[] : winnerPositions){
                if(gameState[winnerPosition[0]]==gameState[winnerPosition[1]]
                        && gameState[winnerPosition[1]]==gameState[winnerPosition[2]]
                        &&gameState[winnerPosition[0]]!=2){
                    //System.out.println();
                    String winnername="RUMPA";
                    if(gameState[winnerPosition[0]]==0){
                        if(firstplayer==2){
                            winnername="LISAN";
                        }
                        else if(firstplayer==3){
                            winnername="MISTY";
                        }

                    }
                   else if(gameState[winnerPosition[0]]==1){
                        if(secondplayer==2){
                            winnername="LISAN";
                        }
                        else if(secondplayer==3){
                            winnername="MISTY";
                        }

                    }
                    TextView winnermessage = (TextView)findViewById(R.id.winnermessage);
                    //winnermessage.setText();
                    winnermessage.setText("               " + winnername + "\n           Has Won!! ");


                    LinearLayout layout =(LinearLayout)findViewById(R.id.playagainlayout);
                    layout.setVisibility(View.VISIBLE);
                    active =false;

                }
                else{
                    boolean p=true;
                    for(int c : gameState){
                        if(c==2){
                            p=false;
                        }
                    }
                    if(p==true){
                        TextView winnermessage = (TextView)findViewById(R.id.winnermessage);
                        winnermessage.setText(" Draw Match!! ");


                        LinearLayout layout =(LinearLayout)findViewById(R.id.playagainlayout);
                        layout.setVisibility(View.VISIBLE);
                    }
                }
            }
        }
    }

    public void playagain(View view){
        LinearLayout layout =(LinearLayout)findViewById(R.id.playagainlayout);
        layout.setVisibility(View.INVISIBLE);
        activePlayer = 0;
        active =true;
        // 2 means unpalyed;

        for(int i=0;i<gameState.length;i++){
            gameState[i]=2;
        }
        GridLayout gridLayout = (GridLayout)findViewById(R.id.gridlayout);
        for(int i=0;i<gridLayout.getChildCount();i++){
            ((ImageView)gridLayout.getChildAt(i)).setImageResource(0);
        }

        Intent j  = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(j);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent i=getIntent();
        //Bundle bundle = mIntent.getExtras();
        firstplayer=i.getIntExtra("playerone",0);
        secondplayer=i.getIntExtra("playertwo",0);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
}
