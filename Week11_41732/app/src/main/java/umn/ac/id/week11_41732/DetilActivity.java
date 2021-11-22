package umn.ac.id.week11_41732;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class DetilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detil);
        etNim       = findViewById(R.id.etNim);
        etNama      = findViewById(R.id.etNama);
        etEmail     = findViewById(R.id.etEmail);
        etNomorHp   = findViewById(R.id.etNomorHp);
    }
    public void simpanData(View view) {}

    public void batal (View view) {}
}