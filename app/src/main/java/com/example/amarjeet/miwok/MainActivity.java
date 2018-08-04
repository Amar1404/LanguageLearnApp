package com.example.amarjeet.miwok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

        Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Find the view
        TextView numbers = (TextView) findViewById(R.id.numbers);
        TextView family = (TextView) findViewById(R.id.family);
        TextView colors = (TextView) findViewById(R.id.colors);
        TextView phrases = (TextView) findViewById(R.id.phrases);
        //Set on Click Listner on that view
        //onclick method editing
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, NumberActivity.class);
                startActivity(intent);
            }


        });
        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, PhraseActivity.class);
                startActivity(intent);
            }


        } );
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, FamilyActivity.class);
                startActivity(intent);
            }


        });
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, ColorActivity.class);
                startActivity(intent);
            }


        });
    }
//    public void openFamilyActivity(View view){
//
//        intent = new Intent(this,FamilyActivity.class);
//        startActivity(intent);
//    }
//    public void openColorActivity(View view){
//        intent = new Intent(this,ColorActivity.class);
//        startActivity(intent);
//    }
//    public void openPhraseActivity(View view){
//        intent = new Intent(this,PhraseActivity.class);
//        startActivity(intent);
//    }
}
