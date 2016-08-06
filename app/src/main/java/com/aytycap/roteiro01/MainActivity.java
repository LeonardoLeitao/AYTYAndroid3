package com.aytycap.roteiro01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView greetings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.greetings = (TextView) findViewById(R.id.greetings);
        Bundle b = getIntent().getExtras();
        String text = b.getString("username");
        this.greetings.setText("WELCOME\nWE'RE GLAD YOU'RE HERE, " + text);
    }
}
