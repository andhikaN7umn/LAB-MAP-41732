package umn.ac.id.andhikanugrahawp_41732_uts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    private Button btnNext;
    private EditText namaTextBox;
    private String value, getNameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        btnNext = findViewById(R.id.btnNext);
        namaTextBox = findViewById(R.id.namaTextBox);

        Bundle getPages = getIntent().getExtras();

        if (getPages != null) {
            value = getPages.getString("pageGet");
        }

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (namaTextBox.getText().length() == 0) {
                    namaTextBox.setError("Harap di isi!");
                } else {
                    if (value.equals("pageGetProfile")) {
                        Intent profilePage = new Intent(Login.this, Profile.class);
                        startActivity(profilePage);
                    } else if (value.equals("pageGetLibrary")) {
                        getNameText = namaTextBox.getText().toString();

                        Intent sfxLibrary = new Intent(Login.this, SFXLibrary.class);
                        sfxLibrary.putExtra("namaGueh", getNameText);
                        startActivity(sfxLibrary);
                    }
                }
            }
        });

    }
}
