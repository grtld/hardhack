package com.example.codegirl.lightapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView myTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myTextView = (TextView)findViewById(R.id.textView);
    }

    public void sendRequest(View view) {
        String tag = view.getTag().toString();
        String[] tag_parts = tag.split("_");
        myTextView.setText("Switch: " + tag_parts[1] + "\nOn/Off: " + tag_parts[2]);
    }
}
