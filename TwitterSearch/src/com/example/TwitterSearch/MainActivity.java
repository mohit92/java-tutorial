package com.example.TwitterSearch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
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


        searchButton = (Button) findViewById(R.id.searchButton);
        queryEditText =(EditText) findViewById(R.id.searchQueryEditText);



    }




    public void processQuery(View view)
    {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(queryEditText.getWindowToken(), 0);
        String query = queryEditText.getText().toString();
        if(query!=null && !query.isEmpty()) {

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
                List<Status> tweets = queryResult.getTweets();
                String resultString = "";
                for (Status tweet : tweets) {
                    resultString += tweet.getUser().getScreenName() + "-" + tweet.getText() + "\n\n";
                    //System.out.println(tweet.getUser().getScreenName()+"-"+tweet.getText());


                }
                if (resultString != null && !resultString.isEmpty()) {

                    Intent intent = new Intent(this, ShowTweets.class);
                    intent.putExtra("EXTRA_MESSAGE", resultString);
                    startActivity(intent);
                }
                else
                {
                        Toast.makeText(getApplicationContext(),"No tweets found, Please Enter a relevent query",Toast.LENGTH_LONG).show();
                        queryEditText.setText("");
                        imm.showSoftInput(queryEditText,0);
                }

                //System.exit(0);
            } catch (TwitterException te) {
                te.printStackTrace();
                // System.out.println("Failed to search tweets: "+ te.getMessage());
                System.exit(-1);
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Query could not be empty", Toast.LENGTH_LONG).show();
            imm.showSoftInput(queryEditText,0);
        }
    }


}
