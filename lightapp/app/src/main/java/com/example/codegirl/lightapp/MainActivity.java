package com.example.codegirl.lightapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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

        Context context = getApplicationContext();
        String status;
        String switchTag = tag_parts[1];
        if(tag_parts[2].equals("0")) {
            status = "OFF";
        }
        else {
            status = "ON";
        }
        CharSequence text = "Switch " + switchTag + " " + status;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
