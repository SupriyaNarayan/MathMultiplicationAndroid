package com.example.supriya.mathmultiplication;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.os.CountDownTimer;


public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    private Bundle bun;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bun=savedInstanceState;
        setContentView(R.layout.activity_main);
        final Button btnBeginner = (Button) findViewById(R.id.buttonBeginner);
        final Button btnIntermediate = (Button) findViewById(R.id.buttonIntermediate);
        final Button btnAdvanced = (Button) findViewById(R.id.buttonAdvanced);
        btnBeginner.setText("Beginners Multiplication");
        btnIntermediate.setText("Intermediate Multiplication");
        btnAdvanced.setText("Advanced Multiplication");
        final Button btnExit = (Button) findViewById(R.id.buttonExit);
        btnExit.setVisibility(View.VISIBLE);

        btnExit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnBeginner.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                btnBeginner.setVisibility(View.GONE);
                btnIntermediate.setVisibility(View.GONE);
                btnAdvanced.setVisibility(View.GONE);
                btnExit.setVisibility(View.INVISIBLE);
                doMultiplication();
            }
        });
        btnIntermediate.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                btnBeginner.setVisibility(View.GONE);
                btnIntermediate.setVisibility(View.GONE);
                btnAdvanced.setVisibility(View.GONE);
                btnExit.setVisibility(View.INVISIBLE);
                doMultiplication_Intermediate();
            }
        });

        btnAdvanced.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                btnBeginner.setVisibility(View.GONE);
                btnIntermediate.setVisibility(View.GONE);
                btnAdvanced.setVisibility(View.GONE);
                btnExit.setVisibility(View.INVISIBLE);
                doMultiplication_Advance();
            }
        });

    }
    public void doMultiplication(){
        Random r = new Random();
        int min = 2;
        int max = 15;
        int max1 = 15;
        int num1 = r.nextInt(max - min + 1) + min;
        int num2 = r.nextInt(max - min + 1) + min;

//Create object
        Button btnoption1 = (Button) findViewById(R.id.buttonoption1);
        Button btnoption2 = (Button) findViewById(R.id.buttonoption2);
        Button btnoption3 = (Button) findViewById(R.id.buttonoption3);
        Button btnoption4 = (Button) findViewById(R.id.buttonoption4);
        final TextView question = (TextView) findViewById(R.id.textViewQuestion);
        final TextView result = (TextView) findViewById(R.id.textView1);
        final Button btnNext = (Button) findViewById(R.id.buttonoptionnext);
        final TextView counter = (TextView) findViewById(R.id.textViewCounter);
        final Button btnHome = (Button) findViewById(R.id.buttonHome);
        btnHome.setText("Back Home");
        btnHome.setVisibility(View.VISIBLE);
        counter.setVisibility(View.VISIBLE);
        final CountDownTimer timer =new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {
                counter.setText("seconds: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                counter.setText("Time Up! But you can still Try!");
            }
        };

        timer.start();
        question.setVisibility(View.VISIBLE);
        btnoption1.setVisibility(View.VISIBLE);
        btnoption2.setVisibility(View.VISIBLE);
        btnoption3.setVisibility(View.VISIBLE);
        btnoption4.setVisibility(View.VISIBLE);
        btnNext.setVisibility(View.INVISIBLE);
        result.setVisibility(View.INVISIBLE);


        question.setText(String.valueOf(num1) + " * " + String.valueOf(num2) );

        int answer = num1 * num2;
        int[] array = new int[4];
        final int index = r.nextInt(3 - 0 + 1) + 0;
        array[index] = answer;
        Set<Integer> mySet = new HashSet<>();
        mySet.add(answer);
        for(int i=0;i<array.length;i++){
            if(array[i]!=answer){
                int rand = r.nextInt((answer + max1) - (answer + 5) + 1) + (answer+6);
                while(mySet.contains(rand)){
                    rand = r.nextInt((answer + max1) - (answer+6) + 1) + (answer+8);
                }
                mySet.add(rand);
                array[i]=rand;
            }
        }
        btnoption1.setText(String.valueOf(array[0]));
        btnoption2.setText(String.valueOf(array[1]));
        btnoption3.setText(String.valueOf(array[2]));
        btnoption4.setText(String.valueOf(array[3]));
        btnHome.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                onCreate(bun);
            }
        });


        btnoption1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if(index==0){
                    result.setVisibility(View.VISIBLE);
                    timer.cancel();
                    result.setText("Correct");
                    btnNext.setVisibility(View.VISIBLE);
                    btnNext.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            doMultiplication();

                        }
                    });
                }
                else{
                    result.setVisibility(View.VISIBLE);
                    result.setText("InCorrect");
                }
            }
        });

        btnoption2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if(index==1){
                    result.setVisibility(View.VISIBLE);
                    timer.cancel();
                    result.setText("Correct");
                    btnNext.setVisibility(View.VISIBLE);
                    btnNext.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            doMultiplication();

                        }
                    });
                }
                else{
                    result.setVisibility(View.VISIBLE);
                    result.setText("InCorrect");
                }
            }
        });

        btnoption3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if(index==2){
                    result.setVisibility(View.VISIBLE);
                    timer.cancel();
                    result.setText("Correct");
                    btnNext.setVisibility(View.VISIBLE);
                    btnNext.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            doMultiplication();

                        }
                    });
                }
                else{
                    result.setVisibility(View.VISIBLE);
                    result.setText("InCorrect");
                }
            }
        });

        btnoption4.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if(index==3){
                    result.setVisibility(View.VISIBLE);
                    timer.cancel();
                    result.setText("Correct");
                    btnNext.setVisibility(View.VISIBLE);
                    btnNext.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            doMultiplication();

                        }
                    });
                }
                else{
                    result.setVisibility(View.VISIBLE);
                    result.setText("InCorrect");
                }
            }
        });
    }
    public void doMultiplication_Intermediate(){
        Random r = new Random();
        int min = 10;
        int max = 25;
        int max1 = 15;
        int num1 = r.nextInt(max - min + 1) + min;
        int num2 = r.nextInt(max - min + 1) + min;

//Create object
        Button btnoption1 = (Button) findViewById(R.id.buttonoption1);
        Button btnoption2 = (Button) findViewById(R.id.buttonoption2);
        Button btnoption3 = (Button) findViewById(R.id.buttonoption3);
        Button btnoption4 = (Button) findViewById(R.id.buttonoption4);
        final TextView question = (TextView) findViewById(R.id.textViewQuestion);
        final TextView result = (TextView) findViewById(R.id.textView1);
        final Button btnNext = (Button) findViewById(R.id.buttonoptionnext);
        final Button btnHome = (Button) findViewById(R.id.buttonHome);
        btnHome.setText("Back Home");
        btnHome.setVisibility(View.VISIBLE);
        final TextView counter = (TextView) findViewById(R.id.textViewCounter);
        counter.setVisibility(View.VISIBLE);
        final CountDownTimer timer =new CountDownTimer(15000, 1000) {

            public void onTick(long millisUntilFinished) {
                counter.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                counter.setText("Time Up! But you can still Try!");
            }
        };

        timer.start();

        question.setVisibility(View.VISIBLE);
        btnoption1.setVisibility(View.VISIBLE);
        btnoption2.setVisibility(View.VISIBLE);
        btnoption3.setVisibility(View.VISIBLE);
        btnoption4.setVisibility(View.VISIBLE);
        btnNext.setVisibility(View.INVISIBLE);
        result.setVisibility(View.INVISIBLE);

        question.setText(String.valueOf(num1) + " * " + String.valueOf(num2) );

        int answer = num1 * num2;
        int[] array = new int[4];
        final int index = r.nextInt(3 - 0 + 1) + 0;
        array[index] = answer;
        Set<Integer> mySet = new HashSet<>();
        mySet.add(answer);
        for(int i=0;i<array.length;i++){
            if(array[i]!=answer){
                int rand = r.nextInt((answer + max1) - (answer + 5) + 1) + (answer+6);
                while(mySet.contains(rand)){
                    rand = r.nextInt((answer + max1) - (answer+6) + 1) + (answer+8);
                }
                mySet.add(rand);
                array[i]=rand;
            }
        }
        btnoption1.setText(String.valueOf(array[0]));
        btnoption2.setText(String.valueOf(array[1]));
        btnoption3.setText(String.valueOf(array[2]));
        btnoption4.setText(String.valueOf(array[3]));
        btnHome.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                onCreate(bun);
            }
        });

        btnoption1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if(index==0){
                    result.setVisibility(View.VISIBLE);
                    timer.cancel();
                    result.setText("Correct");
                    btnNext.setVisibility(View.VISIBLE);
                    btnNext.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            doMultiplication_Intermediate();

                        }
                    });
                }
                else{
                    result.setVisibility(View.VISIBLE);
                    result.setText("InCorrect");
                }
            }
        });

        btnoption2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if(index==1){
                    result.setVisibility(View.VISIBLE);
                    timer.cancel();
                    result.setText("Correct");
                    btnNext.setVisibility(View.VISIBLE);
                    btnNext.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            doMultiplication_Intermediate();

                        }
                    });
                }
                else{
                    result.setVisibility(View.VISIBLE);
                    result.setText("InCorrect");
                }
            }
        });

        btnoption3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if(index==2){
                    result.setVisibility(View.VISIBLE);
                    timer.cancel();
                    result.setText("Correct");
                    btnNext.setVisibility(View.VISIBLE);
                    btnNext.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            doMultiplication_Intermediate();

                        }
                    });
                }
                else{
                    result.setVisibility(View.VISIBLE);
                    result.setText("InCorrect");
                }
            }
        });

        btnoption4.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if(index==3){
                    result.setVisibility(View.VISIBLE);
                    timer.cancel();
                    result.setText("Correct");
                    btnNext.setVisibility(View.VISIBLE);
                    btnNext.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            doMultiplication_Intermediate();

                        }
                    });
                }
                else{
                    result.setVisibility(View.VISIBLE);
                    result.setText("InCorrect");
                }
            }
        });
    }
    public void doMultiplication_Advance(){
        Random r = new Random();
        int min = 15;
        int max = 100;
        int max1 = 15;
        int num1 = r.nextInt(max - min + 1) + min;
        int num2 = r.nextInt(max - min + 1) + min;

//Create object
        Button btnoption1 = (Button) findViewById(R.id.buttonoption1);
        Button btnoption2 = (Button) findViewById(R.id.buttonoption2);
        Button btnoption3 = (Button) findViewById(R.id.buttonoption3);
        Button btnoption4 = (Button) findViewById(R.id.buttonoption4);
        final TextView question = (TextView) findViewById(R.id.textViewQuestion);
        final TextView result = (TextView) findViewById(R.id.textView1);
        final Button btnNext = (Button) findViewById(R.id.buttonoptionnext);
        final Button btnHome = (Button) findViewById(R.id.buttonHome);
        btnHome.setText("Back Home");
        btnHome.setVisibility(View.VISIBLE);
        final TextView counter = (TextView) findViewById(R.id.textViewCounter);
        counter.setVisibility(View.VISIBLE);
        final CountDownTimer timer =new CountDownTimer(20000, 1000) {

            public void onTick(long millisUntilFinished) {
                counter.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                counter.setText("Time Up! But you can still Try!");
            }
        };

        timer.start();

        question.setVisibility(View.VISIBLE);
        btnoption1.setVisibility(View.VISIBLE);
        btnoption2.setVisibility(View.VISIBLE);
        btnoption3.setVisibility(View.VISIBLE);
        btnoption4.setVisibility(View.VISIBLE);
        btnNext.setVisibility(View.INVISIBLE);
        result.setVisibility(View.INVISIBLE);

        question.setText(String.valueOf(num1) + " * " + String.valueOf(num2) );

        int answer = num1 * num2;
        int[] array = new int[4];
        final int index = r.nextInt(3 - 0 + 1) + 0;
        array[index] = answer;
        Set<Integer> mySet = new HashSet<>();
        mySet.add(answer);
        for(int i=0;i<array.length;i++){
            if(array[i]!=answer){
                int rand = r.nextInt((answer + max1) - (answer + 5) + 1) + (answer+6);
                while(mySet.contains(rand)){
                    rand = r.nextInt((answer + max1) - (answer+6) + 1) + (answer+8);
                }
                mySet.add(rand);
                array[i]=rand;
            }
        }
        btnoption1.setText(String.valueOf(array[0]));
        btnoption2.setText(String.valueOf(array[1]));
        btnoption3.setText(String.valueOf(array[2]));
        btnoption4.setText(String.valueOf(array[3]));
        btnHome.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                onCreate(bun);
            }
        });

        btnoption1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if(index==0){
                    result.setVisibility(View.VISIBLE);
                    timer.cancel();
                    result.setText("Correct");
                    btnNext.setVisibility(View.VISIBLE);
                    btnNext.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            doMultiplication_Advance();

                        }
                    });
                }
                else{
                    result.setVisibility(View.VISIBLE);
                    result.setText("InCorrect");
                }
            }
        });

        btnoption2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if(index==1){
                    result.setVisibility(View.VISIBLE);
                    timer.cancel();
                    result.setText("Correct");
                    btnNext.setVisibility(View.VISIBLE);
                    btnNext.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            doMultiplication_Advance();

                        }
                    });
                }
                else{
                    result.setVisibility(View.VISIBLE);
                    result.setText("InCorrect");
                }
            }
        });

        btnoption3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if(index==2){
                    result.setVisibility(View.VISIBLE);
                    timer.cancel();
                    result.setText("Correct");
                    btnNext.setVisibility(View.VISIBLE);
                    btnNext.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            doMultiplication_Advance();

                        }
                    });
                }
                else{
                    result.setVisibility(View.VISIBLE);
                    result.setText("InCorrect");
                }
            }
        });

        btnoption4.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if(index==3){
                    result.setVisibility(View.VISIBLE);
                    timer.cancel();
                    result.setText("Correct");
                    btnNext.setVisibility(View.VISIBLE);
                    btnNext.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            doMultiplication_Advance();

                        }
                    });
                }
                else{
                    result.setVisibility(View.VISIBLE);
                    result.setText("InCorrect");
                }
            }
        });
    }
}


