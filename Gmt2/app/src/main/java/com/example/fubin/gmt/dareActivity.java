package com.example.fubin.gmt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

public class dareActivity extends AppCompatActivity {
    String rs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dare);

        if(getIntent().hasExtra("my thought"))
        {
            String text = getIntent().getExtras().getString("my thought");

            rs = text;
        }

        Random r = new Random();

        //150
        int dar = r.nextInt(150) + 1;

        InputStream input = getResources().openRawResource(getResources().getIdentifier("dare","raw",getPackageName()));

        Scanner s = new Scanner(input);

        int count = 0;

        while(s.hasNext())
        {
            String Line = s.nextLine();
            if(count == dar)
            {
                TextView tv1 = (TextView) findViewById(R.id.randomdare);
                tv1.setText(Line);
            }
            count+=1;
        }

        Button change = (Button) findViewById(R.id.change1);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random r = new Random();

                int dar = r.nextInt(150) + 1;

                InputStream input = getResources().openRawResource(getResources().getIdentifier("dare","raw",getPackageName()));

                Scanner s = new Scanner(input);

                int count = 0;

                while(s.hasNext())
                {
                    String Line = s.nextLine();
                    if(count == dar)
                    {
                        TextView tv1 = (TextView) findViewById(R.id.randomdare);
                        tv1.setText(Line);
                    }
                    count+=1;
                }
            }
        });

         Button Yes = (Button)findViewById(R.id.back1);
        Yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), thirdactivity.class);
                startIntent.putExtra("my thought", rs);
                startActivity(startIntent);
            }
        });

        Button No = (Button)findViewById(R.id.finish1);
        No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), fourthActivity.class);
                startActivity(startIntent);
            }
        });
    }
}
