package com.example.timetable;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ResourceActivity extends AppCompatActivity {
    Button button;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource);
        button = findViewById(R.id.but);
        editText = findViewById(R.id.et);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String url = editText.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(url));
                startActivity(intent);
            }
        });
    }
}
