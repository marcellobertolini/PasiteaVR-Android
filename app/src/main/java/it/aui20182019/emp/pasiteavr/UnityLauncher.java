package it.aui20182019.emp.pasiteavr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import it.aui20182019.pasitea.UnityPlayerActivity;
public class UnityLauncher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, UnityPlayerActivity.class);
        startActivity(intent);
    }
}
