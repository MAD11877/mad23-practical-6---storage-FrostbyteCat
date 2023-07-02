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
    private boolean followed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHandler db = new dbHandler(this, null, null, 1);
        Log.v(TITLE, "On Create!");
        Intent i = getIntent();

        String name = i.getStringExtra("name");
        String description = i.getStringExtra("des");
        followed = i.getBooleanExtra("followed",false);

        Button followButton = (Button) findViewById(R.id.Follow);
        Button messageButton = (Button) findViewById(R.id.Message);


        TextView Title = (TextView) findViewById((R.id.Title));
        Title.setText(name);

        TextView Description = (TextView) findViewById((R.id.Description));
        Description.setText(description);
        User user =(User) i.getSerializableExtra("UserID");


        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.followed = !user.followed;
                db.updateUser(user);

                if (followButton.getText() == "Follow"){
                    followButton.setText("Unfollow");
                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();
                }

                else{
                    followButton.setText("Follow");
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