package com.example.TwitterSearch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

/**
 * Created by mohit on 6/4/14.
 */
public class ShowTweets extends Activity{

    private EditText showTweetsEditText;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_tweets);

        Intent intent = getIntent();
        String tweets = intent.getExtras().getString("EXTRA_MESSAGE");

        showTweetsEditText = (EditText) findViewById(R.id.showTweetsEditText);
        showTweetsEditText.setText(tweets);

    }




}
