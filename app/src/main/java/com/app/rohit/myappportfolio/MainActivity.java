package com.app.rohit.myappportfolio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button_spotifyStreamer, button_scoresApp, button_libraryApp, button_buildItBigger, button_xyzReader, button_capstoneMyOwnApp;
    private boolean sizeDecided;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //alloting Button variables to their respective UI elements
        button_spotifyStreamer = (Button) this.findViewById(R.id.button_spotify_streamer);
        button_scoresApp = (Button) this.findViewById(R.id.button_scores_app);
        button_libraryApp = (Button) this.findViewById(R.id.button_library_app);
        button_buildItBigger = (Button) this.findViewById(R.id.button_build_it_bigger);
        button_xyzReader = (Button) this.findViewById(R.id.button_xyz_reader);
        button_capstoneMyOwnApp = (Button) this.findViewById(R.id.button_capstone_my_own_app);

        button_spotifyStreamer.setOnClickListener(this);
        button_scoresApp.setOnClickListener(this);
        button_libraryApp.setOnClickListener(this);
        button_buildItBigger.setOnClickListener(this);
        button_xyzReader.setOnClickListener(this);
        button_capstoneMyOwnApp.setOnClickListener(this);

        sizeDecided = false;

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (!sizeDecided) {
            Button longestTextButton = getLongestTextButton(button_spotifyStreamer, button_scoresApp, button_libraryApp, button_buildItBigger, button_xyzReader, button_capstoneMyOwnApp);
            Integer widthOfLongestTextButton = longestTextButton.getWidth();
            widthOfLongestTextButton += 20; //to provide some space from button's border

            button_spotifyStreamer.setWidth(widthOfLongestTextButton);
            button_scoresApp.setWidth(widthOfLongestTextButton);
            button_libraryApp.setWidth(widthOfLongestTextButton);
            button_buildItBigger.setWidth(widthOfLongestTextButton);
            button_xyzReader.setWidth(widthOfLongestTextButton);
            button_capstoneMyOwnApp.setWidth(widthOfLongestTextButton);

            sizeDecided = true;
        }
    }

    private Integer getTextSizeForButton(Button b) {
        String text = b.getText().toString();
        if (text.length() != 0) {
            return text.length();
        }
        return -1;
    }

    private Button getLongestTextButton(Button... buttons) {
        Button resultButton = buttons[0];
        Integer longestTextSize = resultButton.getText().toString().length();
        for (int i = 1; i < buttons.length; i++) {
            Integer currentSize = getTextSizeForButton(buttons[i]);
            if (currentSize > longestTextSize) {
                longestTextSize = currentSize;
                resultButton = buttons[i];
            }
        }
        return resultButton;
    }

    @Override
    public void onClick(View view) {
        String start = "This button will launch my ";
        switch (view.getId()) {
            case R.id.button_spotify_streamer:
                Toast.makeText(this, start + " Spotify Streamer app!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_library_app:
                Toast.makeText(this, start + " Library app!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_scores_app:
                Toast.makeText(this, start + " Scores app!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_xyz_reader:
                Toast.makeText(this, start + " Xyz Reader app!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_build_it_bigger:
                Toast.makeText(this, start + " Build It Bigger app!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_capstone_my_own_app:
                Toast.makeText(this, start + " Capstone app!", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
