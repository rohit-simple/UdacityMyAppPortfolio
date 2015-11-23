package com.app.rohit.myappportfolio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button_spotifyStreamer, button_scoresApp, button_libraryApp, button_buildItBigger, button_xyzReader, button_capstoneMyOwnApp;
    private boolean sizeDecided;
    String start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = "This button will launch my ";

        //alloting Button variables to their respective UI elements
        button_spotifyStreamer = (Button) this.findViewById(R.id.button_spotify_streamer);
        button_scoresApp = (Button) this.findViewById(R.id.button_scores_app);
        button_libraryApp = (Button) this.findViewById(R.id.button_library_app);
        button_buildItBigger = (Button) this.findViewById(R.id.button_build_it_bigger);
        button_xyzReader = (Button) this.findViewById(R.id.button_xyz_reader);
        button_capstoneMyOwnApp = (Button) this.findViewById(R.id.button_capstone_my_own_app);

        sizeDecided = false;

    }

    //used this method as other methods were giving getWidth() as 0
    //got to know about this method at http://stackoverflow.com/questions/3591784/getwidth-and-getheight-of-view-returns-0
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

    public void buttonSpotifyStreamerClicked(View view){
        Toast.makeText(this, start + " Spotify Streamer app!", Toast.LENGTH_SHORT).show();
    }

    public void buttonScoresAppClicked(View view){
        Toast.makeText(this, start + " Scores app!", Toast.LENGTH_SHORT).show();
    }

    public void buttonLibraryAppClicked(View view){
        Toast.makeText(this, start + " Library app!", Toast.LENGTH_SHORT).show();
    }

    public void buttonBuildItBiggerClicked(View view){
        Toast.makeText(this, start + " Build It Bigger app!", Toast.LENGTH_SHORT).show();
    }

    public void buttonXyzReaderClicked(View view){
        Toast.makeText(this, start + " Xyz Reader app!", Toast.LENGTH_SHORT).show();
    }

    public void buttonCapstoneMyOwnAppClicked(View view){
        Toast.makeText(this, start + " Capstone app!", Toast.LENGTH_SHORT).show();
    }

}
