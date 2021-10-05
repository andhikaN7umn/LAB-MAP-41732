package umn.ac.id.andhikanugrahawp_41732_uts;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonProfile, buttonLibrary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonProfile = findViewById(R.id.buttonProfile);
        buttonLibrary = findViewById(R.id.buttonLibrary);

        buttonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginbang = new Intent(MainActivity.this, Login.class);
                loginbang.putExtra("pageGet", "pageGetProfile");
                startActivity(loginbang);
            }
        });

        buttonLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginbang = new Intent(MainActivity.this, Login.class);
                loginbang.putExtra("pageGet", "pageGetLibrary");
                startActivity(loginbang);
            }
        });
    }
}