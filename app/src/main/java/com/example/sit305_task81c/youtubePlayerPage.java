package com.example.sit305_task81c;

import androidx.appcompat.app.AppCompatActivity;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.net.URI;

public class youtubePlayerPage extends AppCompatActivity {

    VideoView videoView;
    String URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_player_page);

        videoView = findViewById(R.id.videoView);

        Bundle extras = getIntent().getExtras();
        URL = "https://media.geeksforgeeks.org/wp-content/uploads/20201217192146/Screenrecorder-2020-12-17-19-17-36-828.mp4?_=1";

        // Uri object to refer the resource from the videoUrl
        Uri uri = Uri.parse(URL);

        // sets the resource from the videoUrl to the videoView
        videoView.setVideoURI(uri);

        // creating object of media controller class
        MediaController mediaController = new MediaController(this);

        // sets the anchor view anchor view for the videoView
        mediaController.setAnchorView(videoView);

        // sets the media player to the videoView
        mediaController.setMediaPlayer(videoView);

        // sets the media controller to the videoView
        videoView.setMediaController(mediaController);

        // starts the video
        videoView.start();


    }
}