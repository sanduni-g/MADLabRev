package com.example.revlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ReadingCollectionsActivity extends AppCompatActivity {

    String nameSent;
    Toast toast;
    Button book,paper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading_collections);

        Intent intent = getIntent();

        nameSent =  intent.getStringExtra("valueToPass");
        book = findViewById(R.id.buttonBook);
        paper = findViewById(R.id.buttonPaper);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Context context = getApplicationContext();
        CharSequence text = "Welcome " + nameSent + "\n" + "Pleas Enter What You Need";
        Integer duration = Toast.LENGTH_SHORT;

        toast = Toast.makeText(context, text, duration);
        toast.setGravity(Gravity.BOTTOM, Gravity.CENTER,0);
        toast.show();

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ReadingCollectionsActivity.this, AddReading.class);
                int temp1 = 1;
                intent1.putExtra("toAddReaidng", temp1);
                startActivity(intent1);
            }
        });
        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(ReadingCollectionsActivity.this, AddReading.class);
                int temp2 = 2;
                intent2.putExtra("toAddReaidng", temp2);
                startActivity(intent2);
            }
        });
    }
}
