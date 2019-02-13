package com.example.guszt.lab3finalproject;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class CryptoLogic extends AppCompatActivity {

    Random rand = new Random();

    private String word;
    private String letterGuess;
    private String shuffledWord;
    private int positionOfWord = 0;
    private int wordLength;
    private int incorrectTries = 0;
    private int correctTries = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crypto_logic);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ArrayList<String> secretWords = new ArrayList(Arrays.asList("APPLE", "BANANA", "CHERRY"));


        // CREATE AFTER YOUR SUPERCLASSS
        TextView shuffleTextView = (TextView) findViewById(R.id.scrambleText);

        int n = rand.nextInt(3) + 0;
        wordLength = 0;

        word = secretWords.get(n);

        shuffledWord = "";
        ArrayList<String> splitWord = new ArrayList(Arrays.asList(word.split("")));
        Collections.shuffle(splitWord);
        for (String c : splitWord) {
            shuffledWord += c;
            wordLength++;
        }

        shuffleTextView.setText(shuffledWord);
    }

    public void guessButtonClicked(View v){
        TextView guessTextView = (TextView) findViewById(R.id.editText);
        TextView letterGuess = (TextView) findViewById(R.id.guessView);
        String currentAnswer = "";


        TextView correctNum = (TextView) findViewById(R.id.correct);

        TextView incorrectNum = (TextView) findViewById(R.id.incorrect);

        char guessChar = guessTextView.getText().toString().charAt(0);

        if(word.charAt(positionOfWord) == guessChar){
            guessTextView.setText("");
            correctTries++;

            for (int i = 0; i <= positionOfWord; i++){
                currentAnswer += word.charAt(i);
                letterGuess.setText(currentAnswer);

            }
            positionOfWord++;


        }
        else {
            guessTextView.setText("");
            incorrectTries++;
        }
            correctNum.setText("Correct Tries: " + Integer.toString(correctTries));
            incorrectNum.setText("Incorrect Tries: " + Integer.toString(incorrectTries));


        if(correctTries == word.length()){
            guessTextView.setText("Game Over: " + word);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_crypto_logic, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
