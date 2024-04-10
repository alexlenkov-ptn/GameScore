package com.lnkov.gamescore;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private int score1 = 0;
    private int score2 = 0;
    private TextView textViewPointTeam1;
    private TextView textViewPointTeam2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Log.d("MainActivity", "Method onCreate");


        if (savedInstanceState != null) {
            score1 = savedInstanceState.getInt("score1");
            score2 = savedInstanceState.getInt("score2");
        }

        textViewPointTeam1 = findViewById(R.id.textViewPointTeam1);
        textViewPointTeam2 = findViewById(R.id.textViewPointTeam2);

        updateScore1();
        updateScore2();


        textViewPointTeam1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "Clicked textViewScore1");
                score1++;
                updateScore1();
            }
        });
        textViewPointTeam2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "Clicked textViewScore2");
                score2++;
                updateScore2();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "onStop");
    }

    private void updateScore1() {
        textViewPointTeam1.setText(String.valueOf(score1));
    }

    private void updateScore2() {
        textViewPointTeam2.setText(String.valueOf(score2));
    }


    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d("MainActivity", "Method onSaveInstanceState");
        super.onSaveInstanceState(outState);
        outState.putInt("score1", score1);
        outState.putInt("score2", score2);
    }

    protected void onDestroy() {
        Log.d("MainActivity", "Method onDestroy");
        super.onDestroy();
    }
}