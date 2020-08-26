package com.example.revlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button button;

    EditText txtName;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.buttonok);

        txtName = findViewById(R.id.editText);
    }

    @Override
    protected void onResume() {
        super.onResume();

        name = txtName.getText().toString();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ReadingCollectionsActivity.class);
                i.putExtra("valueToPass",name);

                startActivity(i);
            }
        });
    }
}
