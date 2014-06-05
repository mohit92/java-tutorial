package com.example.TwitterSearch;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;


public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    //private EditText queryResultEditText;
    private EditText queryEditText;
    private Button searchButton;

    private String currentQuery;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        searchButton = (Button) findViewById(R.id.searchButton);
        queryEditText =(EditText) findViewById(R.id.searchQueryEditText);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void processQuery(View view)
    {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(queryEditText.getWindowToken(), 0);
        String query = queryEditText.getText().toString();
        if(query!=null && !query.isEmpty()) {
            new processQueryAsyncTask().execute(view);
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Query could not be empty", Toast.LENGTH_LONG).show();
            imm.showSoftInput(queryEditText, 0);
            //String resultString ="Query can not be empty";
            //return resultString;
        }

    }


    private class processQueryAsyncTask extends AsyncTask<View ,Integer , String>
    {

        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        //imm.hideSoftInputFromWindow(queryEditText.getWindowToken(), 0);
        String query = queryEditText.getText().toString();
        LinearLayout linlaHeaderProgress = (LinearLayout) findViewById(R.id.linlaHeaderProgress);
        @Override
        protected String doInBackground(View... views) {

                ConfigurationBuilder cb = new ConfigurationBuilder();

                cb.setDebugEnabled(true).setOAuthConsumerKey("NORzIPEvbq57JXD6oULfurSMv")
                        .setOAuthConsumerSecret("j0Nskqgrufxw2cDNXt2sTEAdmV4dOUaZcoy8vcGNUtJ5sKeMch")
                        .setOAuthAccessToken("417888841-0bb7y1461DKFX5pUUdSN07nFasfZWKzDInmdzFsB")
                        .setOAuthAccessTokenSecret("rJSDhSdtuzwJCbGdPgDR7BqxT2TYbTA2rHr7zGkLmCGmO");

                TwitterFactory tf = new TwitterFactory(cb.build());
                Twitter twitter = tf.getInstance();
                try {

                    QueryResult queryResult;
                    queryResult = twitter.search(new Query(query));
                    List<twitter4j.Status> tweets = queryResult.getTweets();
                    String resultString = "";
                    for (twitter4j.Status tweet : tweets) {
                        resultString += tweet.getUser().getScreenName() + "-" + tweet.getText() + "\n\n";
                        //System.out.println(tweet.getUser().getScreenName()+"-"+tweet.getText());


                    }
                    if (resultString != null && !resultString.isEmpty()) {

                        Intent intent;
                        intent = new Intent(getApplicationContext(), ShowTweets.class);
                        intent.putExtra("EXTRA_MESSAGE", resultString);
                        startActivity(intent);

                        return resultString;
                    }
                    else
                    {


                        return resultString;
                    }

                    //System.exit(0);
                } catch (TwitterException te) {
                    te.printStackTrace();
                    // System.out.println("Failed to search tweets: "+ te.getMessage());
                    System.exit(-1);
                }


            return null;

        }
        @Override
        protected void onPreExecute() {
            linlaHeaderProgress.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String resultString) {
            if(resultString!=null && !resultString.isEmpty())
            linlaHeaderProgress.setVisibility(View.GONE);
            else
            {
                //InputMethodManager imm = new
                Toast.makeText(getApplicationContext(),"No tweets found, Please Enter a relevent query",Toast.LENGTH_LONG).show();
                queryEditText.setText("");
                linlaHeaderProgress.setVisibility(View.GONE);
                imm.showSoftInput(queryEditText,0);
            }
        }
    }


}
