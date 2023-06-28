package com.example.mad_wk2practical;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final String TITLE = "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TITLE, "On Create!");

        Button followButton = (Button) findViewById(R.id.Follow);

        User a = new User("Tom", "Tom's Description", 1, false);

        TextView Title = (TextView) findViewById((R.id.Title));
        String greeting = "Hello " + a.name + "!";
        Title.setText(greeting);

        TextView Description = (TextView) findViewById((R.id.Description));
        Description.setText(a.description);

        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (a.followed == false){
                    followButton.setText("Unfollow");
                    a.followed = true;
                }

                else{
                    followButton.setText("Follow");
                    a.followed = false;
                }
            }
        });
    }
}