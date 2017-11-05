package com.example.fubin.gmt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class secondactivity extends AppCompatActivity {

    int min = 1;
    int max = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Random r = new Random();

        final int curnum = r.nextInt(100) + 1;

        TextView tv = (TextView) findViewById(R.id.numMin);
        String text = (Integer.toString(min));
        tv.setText(text);

        TextView tv1 = (TextView) findViewById(R.id.numMax);
        String text1 = (Integer.toString(max));
        tv1.setText(text1);

        Button guessbut = (Button) findViewById(R.id.guess);
        guessbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              int numin = 0;

                EditText Numin = (EditText) findViewById(R.id.typinNum);

                String nummin = Numin.getText().toString();

                if(nummin.matches("")){
                    TextView tv3 = (TextView) findViewById(R.id.note);
                    String text3 ="Note: \nNo input! ";
                    tv3.setText(text3);
                }
                else
                {
                    numin = Integer.parseInt(nummin);
                }

                if (numin == 0)
                {
                   // continue;
                }
                else if((numin >= max) || (numin <= min))
                {
                    TextView tv2 = (TextView) findViewById(R.id.note);
                    String text2 ="Note: \ndo not include the range!";
                    tv2.setText(text2);
                }
                else if(numin> curnum)
                {
                    max = numin;
                    TextView tv1 = (TextView) findViewById(R.id.numMax);
                    String text1 = (Integer.toString(max));
                    tv1.setText(text1);
                    TextView tv3 = (TextView) findViewById(R.id.note);
                    String text3 ="";
                    tv3.setText(text3);
                }
                else if (numin < curnum)
                {
                    min = numin;
                    TextView tv = (TextView) findViewById(R.id.numMin);
                    String text = (Integer.toString(min));
                    tv.setText(text);
                    TextView tv3 = (TextView) findViewById(R.id.note);
                    String text3 ="";
                    tv3.setText(text3);
                }
                else
                {
                    Intent startIntent = new Intent(getApplicationContext(), thirdactivity.class);
                    startIntent.putExtra("my thought",(Integer.toString(curnum)));
                    startActivity(startIntent);
                }


                Numin.setText("");

            }
        });

    }
}
