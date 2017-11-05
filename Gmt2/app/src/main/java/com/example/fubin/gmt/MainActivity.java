package com.example.fubin.gmt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button start = (Button)findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent (getApplicationContext(),secondactivity.class);
                startActivity(startIntent);
             }
        });

        TextView tv = (TextView) findViewById(R.id.textView);
        String text = "Welcome: \nGuess what I am thinking! ";
        tv.setText(text);

        TextView tv1 = (TextView) findViewById(R.id.textView2);
        String text1 = "hint: Number between 1~100.";
        tv1.setText(text1);


    }
}
