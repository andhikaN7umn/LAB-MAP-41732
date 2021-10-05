package umn.ac.id.andhikanugrahawp_41732_uts;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SFXDetails extends AppCompatActivity {

    private String valueN, valueT, valueF;
    private TextView sfxNameDD, sfxTypeDD;
    private MediaPlayer playSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sfx_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sfxNameDD = findViewById(R.id.sfxNameDD);
        sfxTypeDD = findViewById(R.id.sfxTypeDD);

        Bundle getDatas = getIntent().getExtras();

        if (getDatas != null) {
            valueN = getDatas.getString("theDetailName");
            valueT = getDatas.getString("theDetailType");
            valueF = getDatas.getString("theMusicFile");
        }

        setTitle(valueN);

        sfxNameDD.setText(valueN);
        sfxTypeDD.setText(valueT);

        if(valueF.equals("bruh")){
            playSound = MediaPlayer.create(SFXDetails.this, R.raw.bruh);
        } else if(valueF.equals("enemy_spotted")){
            playSound = MediaPlayer.create(SFXDetails.this, R.raw.enemy_spotted);
        } else if(valueF.equals("kono_dio_da")){
            playSound = MediaPlayer.create(SFXDetails.this, R.raw.kono_dio_da);
        } else if(valueF.equals("minecraft_hurtt")){
            playSound = MediaPlayer.create(SFXDetails.this, R.raw.minecraft_hurtt);
        } else if(valueF.equals("roblox_death_sound_1")){
            playSound = MediaPlayer.create(SFXDetails.this, R.raw.roblox_death_sound_1);
        } else if(valueF.equals("sad_violin")){
            playSound = MediaPlayer.create(SFXDetails.this, R.raw.sad_violin);
        } else if(valueF.equals("windows_shutdown")){
            playSound = MediaPlayer.create(SFXDetails.this, R.raw.windows_shutdown);
        } else {
            playSound = null;
        }

    }

    public void btnPlay(View v) {
        playSound.start();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        stopSFX();
    }

    public void stopSFX() {
        if (playSound != null) {
            playSound.release();
            playSound = null;
        }
    }
}
