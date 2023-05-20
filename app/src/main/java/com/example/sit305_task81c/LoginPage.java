package com.example.sit305_task81c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginPage extends AppCompatActivity {

    EditText youtubeURL;
    Button play, addToPlaylist, showPlaylist;

    String userInput;

    ArrayList<String> URL = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        youtubeURL = findViewById(R.id.youtubeURLEditText);
        play = findViewById(R.id.playBtn);
        addToPlaylist = findViewById(R.id.addToPlaylistBtn);
        showPlaylist = findViewById(R.id.showPlaylistBtn);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(LoginPage.this,youtubePlayerPage.class);
                userInput = String.valueOf(youtubeURL.getText());
                newIntent.putExtra("urlInput", userInput);
                startActivity(newIntent);
            }
        });

        addToPlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // add input data to the playlist
                userInput = String.valueOf(youtubeURL.getText());

                //Check the user input is valid or not
                if(TextUtils.isEmpty(userInput)){
                    Toast.makeText(LoginPage.this, "Please enter a valid URL", Toast.LENGTH_SHORT).show();
                }
                else {
                    URL.add(userInput);
                    Toast.makeText(LoginPage.this, "Insertion successful.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        showPlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent show = new Intent(LoginPage.this, playListPage.class);
                show.putExtra("inputValue", URL);
                startActivity(show);
            }
        });
    }
}