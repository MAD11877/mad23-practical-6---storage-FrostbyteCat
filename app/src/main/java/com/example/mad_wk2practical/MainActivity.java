package com.example.mad_wk2practical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final String TITLE = "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TITLE, "On Create!");

        Button followButton = (Button) findViewById(R.id.Follow);
        Button messageButton = (Button) findViewById(R.id.Message);

        User a = new User("MAD", "Tom's Description", 1, false);

        TextView Title = (TextView) findViewById((R.id.Title));
        String greeting = "Hello " + a.name + "!";
        Title.setText(greeting);

        TextView Description = (TextView) findViewById((R.id.Description));
        Description.setText(a.description);

        Intent intent = getIntent();
        int randomInteger = intent.getIntExtra("randomInteger", 0);
        greeting = a.name + " " + randomInteger;
        Title.setText(greeting);

        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (a.followed == false){
                    followButton.setText("Unfollow");
                    a.followed = true;
                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();
                }

                else{
                    followButton.setText("Follow");
                    a.followed = false;
                    Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(intent);
            }
        });
    }
}