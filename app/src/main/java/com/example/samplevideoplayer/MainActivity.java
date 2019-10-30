package com.example.samplevideoplayer;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;


public class MainActivity extends AppCompatActivity {
    Intent videoFileIntent;
    Button buttonVideoSelect;
    Uri uri;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView = findViewById(R.id.vdVw);
        buttonVideoSelect = findViewById(R.id.button_video_select);

        setButtonVideoSelect();

        //Set MediaController  to enable play, pause, forward, etc options.
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        checkUri();
    }


    public void checkUri() {
        if (uri != null) {
            videoView.setVideoURI(uri);
            videoView.requestFocus();
            videoView.start();
        }
    }

    public void setButtonVideoSelect() {
        buttonVideoSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoFileIntent = new Intent(Intent.ACTION_GET_CONTENT);
                videoFileIntent.setType("video/mp4");
                startActivityForResult(videoFileIntent,10);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case 10:
                if (resultCode == RESULT_OK) {
                    uri = data.getData();
                    checkUri();
                }
                break;
        }
    }

}