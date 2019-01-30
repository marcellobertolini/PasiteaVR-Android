package it.aui20182019.emp.pasiteavr;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    private EditText ipSocket;
    private RadioGroup radioGroup;
    private RadioButton radioSelf, radioTherapist;

    private Button startButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    protected void onStart() {
        super.onStart();
        VideoView videoView = findViewById(R.id.videoViewUI);
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.video_ui;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        videoView.start();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

        ipSocket = findViewById(R.id.ip_socket);
        ipSocket.setEnabled(false);

        radioGroup = findViewById(R.id.radioGroup);
        radioSelf = findViewById(R.id.radiobutton_self);
        radioTherapist = findViewById(R.id.radiobutton_therapist);
        startButton = findViewById(R.id.start_button);

        // Get checked radio button
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // find which radio button is selected
                if(checkedId == R.id.radiobutton_self) {
                    ipSocket.setEnabled(false);
                } else {
                    ipSocket.setEnabled(true);
                }
            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start();
            }
        });
    }

    public void start() {
        if ("".contentEquals(ipSocket.getText())) {
            Intent intent = new Intent(this, UnityLauncher.class);
            startActivity(intent);
        } else {

            Intent intent = new Intent(this, UnityLauncher.class);
            startActivity(intent);
        }


    }
}
