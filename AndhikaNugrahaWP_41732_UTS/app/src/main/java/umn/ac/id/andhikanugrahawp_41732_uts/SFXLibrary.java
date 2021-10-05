package umn.ac.id.andhikanugrahawp_41732_uts;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SFXLibrary extends AppCompatActivity {

    private String value;
    private ArrayList<DataSFX> dataSFXs;
    private RecyclerView recyclerView;
    private SFXAdapter.RecyclerViewClickListener listener;
    private SFXAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sound_library);

        Bundle myNameTitle = getIntent().getExtras();

        if (myNameTitle != null) {
            value = myNameTitle.getString("namaGueh");
        }

        setTitle(value);
        Toast.makeText(SFXLibrary.this, "Selamat datang, " + value, Toast.LENGTH_SHORT).show();

        recyclerView = findViewById(R.id.recyclerView);
        dataSFXs = new ArrayList<>();

        setSFXInfo();
        setAdapter();
    }

    private void setAdapter() {
        setOnClickListener();
        adapter = new SFXAdapter(dataSFXs, listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setOnClickListener() {
        listener = new SFXAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int Position) {
                Intent sfx_details = new Intent(getApplicationContext(), SFXDetails.class);
                sfx_details.putExtra("theDetailName", dataSFXs.get(Position).getsfxName());
                sfx_details.putExtra("theDetailType", dataSFXs.get(Position).getsfxType());
                sfx_details.putExtra("theMusicFile", dataSFXs.get(Position).getMusicFile());

                startActivity(sfx_details);
            }

            @Override
            public void onDeleteClick(int Position) {
                removeSFXItem(Position);
            }
        };
    }

    private void setSFXInfo() {
        dataSFXs.add(new DataSFX("Bruh", "Meme", "bruh"));
        dataSFXs.add(new DataSFX("Sad Violin", "Meme", "sad_violin"));
        dataSFXs.add(new DataSFX("Minecraft Hurt", "Game", "minecraft_hurtt"));
        dataSFXs.add(new DataSFX("Windows Shutdown", "Meme", "windows_shutdown"));
        dataSFXs.add(new DataSFX("Roblox Death", "Meme", "roblox_death_sound_1"));
        dataSFXs.add(new DataSFX("Enemy Spotted", "Game", "enemy_spotted"));
        dataSFXs.add(new DataSFX("Kono Dio Da", "Anime", "kono_dio_da"));
    }

    private void removeSFXItem(int position) {
        dataSFXs.remove(position);
        adapter.notifyItemRemoved(position);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sfxlibrary, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menuProfile:
                changeIntent(1);
                return true;
            case R.id.menuAwal:
                changeIntent(2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void changeIntent(int pageSus) {
        if (pageSus == 1) {
            Intent intent = new Intent(SFXLibrary.this, Profile.class);
            startActivity(intent);
        } else if (pageSus == 2) {
            Intent intent = new Intent(SFXLibrary.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
