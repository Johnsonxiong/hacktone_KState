package com.example.fubin.gmt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class thirdactivity extends AppCompatActivity {

    public String rs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdactivity);

        if(getIntent().hasExtra("my thought"))
        {
            String text = getIntent().getExtras().getString("my thought");

            rs = text;
        }
            TextView tv = (TextView) findViewById(R.id.mythought);

            tv.setText(rs);

        Button Yes = (Button)findViewById(R.id.yes);
        Yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), truthActivity.class);
                startIntent.putExtra("my thought",rs);
                startActivity(startIntent);
            }
        });

        Button No = (Button)findViewById(R.id.no);
        No.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), dareActivity.class);
                startIntent.putExtra("my thought",rs);
                startActivity(startIntent);
            }
        });



    }
}
