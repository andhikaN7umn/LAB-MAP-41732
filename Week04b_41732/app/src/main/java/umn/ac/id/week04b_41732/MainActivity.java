package umn.ac.id.week04b_41732;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText eTinput;
    private Button btnOne, btnTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eTinput = findViewById(R.id.fragment_first_edittext_tulisan);
        btnOne = findViewById(R.id.main_button_change_1);
        btnTwo = findViewById(R.id.main_button_change_2);

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(newIntent, 1);
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(MainActivity.this, ThirdActivity.class);
                startActivityForResult(newIntent, 1);
            }
        });
    }
}