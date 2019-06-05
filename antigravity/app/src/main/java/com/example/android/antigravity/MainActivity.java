package com.example.android.antigravity;

import android.graphics.Point;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;


import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private ImageView ruby;
    private ImageView emerald;
    private ImageView orangeStone;
    private ImageView purpleStone;
    private ImageView topaz;
    private ImageView sapphire;
    private LinearLayout layout;
    private Button button;

    //Position
    private int rubyposY;
    private int emeraldposY;
    private int orangeStoneposY;
    private int purpleStoneposY;
    private int topazposY;
    private int sapphireposY;
    private int rubyposX;
    private int emeraldposX;
    private int orangeStoneposX;
    private int purpleStoneposX;
    private int topazposX;
    private int sapphireposX;


    //Size
    private int frameHeight;
    private int rubyDiameter;
    private int emeraldDiameter;
    private int orangeStoneDiameter;
    private int purpleStoneDiameter;
    private int topazDiameter;
    private int sapphireDiameter;

    //Initialise the class
    private Handler handler = new Handler();
    private Timer timer = new Timer();
    
    //Status check
    private boolean action_flag = false;
    private boolean start_flag = false;
    private boolean generate_flag = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = (LinearLayout) findViewById(R.id.layout);
        ruby = (ImageView) findViewById(R.id.ruby);
        emerald = (ImageView) findViewById(R.id.emerald);
        purpleStone = (ImageView) findViewById(R.id.purple);
        orangeStone = (ImageView) findViewById(R.id.orange);
        topaz = (ImageView) findViewById(R.id.topaz);
        sapphire = (ImageView) findViewById(R.id.sapphire);
        button = (Button) findViewById(R.id.button);





    }

    public int changePos(int posY, int diameter){

        //Moving box
        if(start_flag == false || generate_flag == false){
            if(action_flag == true ){
                posY -= 20;
            }
            else{
                //Releasing
                posY += 20;
            }

            //Check box position
            if(posY<0)posY=0;
            if(posY > frameHeight - diameter)posY = frameHeight- diameter;


        }
        return posY;
    }

    public void generate(View view){
        generate_flag = true;
        Random rand = new Random();

        rubyposY = rand.nextInt(1600);
        emeraldposY = rand.nextInt(1600);
        orangeStoneposY = rand.nextInt(1600);
        purpleStoneposY = rand.nextInt(1600);
        topazposY = rand.nextInt(1600);
        sapphireposY = rand.nextInt(1600);
        rubyposX = rand.nextInt(400);
        emeraldposX = rand.nextInt(400);
        orangeStoneposX = rand.nextInt(400);
        purpleStoneposX = rand.nextInt(400);
        topazposX = rand.nextInt(400);
        sapphireposX = rand.nextInt(400);

        ruby.setY(rubyposY);
        ruby.setX(rubyposX);
        emerald.setY(emeraldposY);
        emerald.setX(emeraldposX);
        orangeStone.setX(orangeStoneposX);
        purpleStone.setY(purpleStoneposY);
        purpleStone.setX(purpleStoneposX);
        topaz.setY(topazposY);
        topaz.setX(topazposX);
        sapphire.setY(sapphireposY);
        sapphire.setX(sapphireposX);
    }


    public boolean onTouchEvent(MotionEvent me){

       if(start_flag == false){



            frameHeight = layout.getHeight();

            rubyDiameter = ruby.getHeight();
            emeraldDiameter = emerald.getHeight();
            purpleStoneDiameter = purpleStone.getHeight();
            orangeStoneDiameter = orangeStone.getHeight();
            topazDiameter = topaz.getHeight();
            sapphireDiameter = sapphire.getHeight();


            rubyposY = (int)ruby.getY();
            emeraldposY = (int)emerald.getY();
            purpleStoneposY = (int)purpleStone.getY();
            orangeStoneposY = (int)orangeStone.getY();
            topazposY = (int)topaz.getY();
            sapphireposY = (int)sapphire.getY();

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            rubyposY = changePos(rubyposY, rubyDiameter);
                            ruby.setY(rubyposY);
                            emeraldposY = changePos(emeraldposY, emeraldDiameter);
                            emerald.setY(emeraldposY);
                            orangeStoneposY = changePos(orangeStoneposY, orangeStoneDiameter);
                            orangeStone.setY(orangeStoneposY);
                            purpleStoneposY = changePos(purpleStoneposY, purpleStoneDiameter);
                            purpleStone.setY(purpleStoneposY);
                            topazposY = changePos(topazposY, topazDiameter);
                            topaz.setY(rubyposY);
                            sapphireposY = changePos(sapphireposY, sapphireDiameter);
                            sapphire.setY(sapphireposY);
                        }
                    });
                }
            },0, 25);
            start_flag = true;
       }
       else{




            if(me.getAction() == MotionEvent.ACTION_DOWN){
                action_flag = !action_flag;
                generate_flag = false;
            }
            else if(me.getAction() == MotionEvent.ACTION_UP){
                if(!generate_flag){

                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    rubyposY = changePos(rubyposY, rubyDiameter);
                                    ruby.setY(rubyposY);
                                    emeraldposY = changePos(emeraldposY, emeraldDiameter);
                                    emerald.setY(emeraldposY);
                                    orangeStoneposY = changePos(orangeStoneposY, orangeStoneDiameter);
                                    orangeStone.setY(orangeStoneposY);
                                    purpleStoneposY = changePos(purpleStoneposY, purpleStoneDiameter);
                                    purpleStone.setY(purpleStoneposY);
                                    topazposY = changePos(topazposY, topazDiameter);
                                    topaz.setY(rubyposY);
                                    sapphireposY = changePos(sapphireposY, sapphireDiameter);
                                    sapphire.setY(sapphireposY);
                                }
                            });
                        }
                    },0, 25);
//                    rubyposY = changePos(rubyposY, rubyDiameter);
//                    ruby.setY(rubyposY);
//                    emeraldposY = changePos(emeraldposY, emeraldDiameter);
//                    emerald.setY(emeraldposY);
//                    orangeStoneposY = changePos(orangeStoneposY, orangeStoneDiameter);
//                    orangeStone.setY(orangeStoneposY);
//                    purpleStoneposY = changePos(purpleStoneposY, purpleStoneDiameter);
//                    purpleStone.setY(purpleStoneposY);
//                    topazposY = changePos(topazposY, topazDiameter);
//                    topaz.setY(rubyposY);
//                    sapphireposY = changePos(sapphireposY, sapphireDiameter);
//                    sapphire.setY(sapphireposY);
                }

           }

       }

        return true;
    }
}
