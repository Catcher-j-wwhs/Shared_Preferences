package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText Username, HighScore ;
    private CheckBox Enrolled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Username = findViewById(R.id.edit1);
        HighScore = findViewById(R.id.edit2);
        Enrolled = findViewById(R.id.enrolled);
    }

    // Fetch the stored data in onResume()
    // Because this is what will be called
    // when the app opens again
    @Override
    protected void onResume() {
        super.onResume();

        // Fetching the stored data
        // from the SharedPreference
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        String s1 = sh.getString("Username", "");
        int a = sh.getInt("High score", 0);
        boolean B_Enrolled = sh.getBoolean("Enrolled",false);

        // Setting the fetched data
        // in the EditTexts
        Username.setText(s1);
        HighScore.setText(String.valueOf(a));
        Enrolled.setChecked(B_Enrolled);
    }

    // Store the data in the SharedPreference
    // in the onPause() method
    // When the user closes the application
    // onPause() will be called
    // and data will be stored
    @Override
    protected void onPause() {
        super.onPause();

        // Creating a shared pref object
        // with a file name "MySharedPref"
        // in private mode
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        // write all the data entered by the user in SharedPreference and apply
        myEdit.putString("Username", Username.getText().toString());
        myEdit.putInt("High score", Integer.parseInt(HighScore.getText().toString()));
        myEdit.putBoolean("Enrolled", Boolean.parseBoolean(Enrolled.getText().toString()));
        myEdit.apply();
    }

}

