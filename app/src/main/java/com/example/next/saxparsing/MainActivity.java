package com.example.next.saxparsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener ,ISAXData{
Button button;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.data_txt);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
SAXController controller = new SAXController(this);
        controller.calTask();
    }

    @Override
    public void getData(String parseData) {
        textView.setText(parseData);
    }
}
