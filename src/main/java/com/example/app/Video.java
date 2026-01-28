package com.example.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class Video extends AppCompatActivity {

    public VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        EdgeToEdge.enable(this);

        videoView = findViewById(R.id.videoView);

        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.tutorial_video;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        // Video automatisch starten
        videoView.start();
        //videoView.setMediaController(null);
    }

    @Override
    public void onBackPressed() {
        // Erstelle einen Intent, um zu page1_Activity zu wechseln.
        super.onBackPressed();
        Intent intent = new Intent(Video.this, Settings.class);
        // Optionale Flags, um den Back-Stack zu leeren, falls gewünscht:
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish(); // Beendet die VideoActivity
    }

}
