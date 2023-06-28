package com.example.mad_wk2practical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;


public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ImageView Icon = (ImageView) findViewById(R.id.imageView2);

        Icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
                builder.setTitle("Profile");
                builder.setMessage("MADness");
                builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ListActivity.this, "You clicked OK", Toast.LENGTH_SHORT).show();
                        int randomInteger = (int) (Math.random() * 100) + 1;
                        Intent intent = new Intent(ListActivity.this, MainActivity.class);
                        intent.putExtra("randomInteger", randomInteger);
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ListActivity.this, "You clicked Cancel", Toast.LENGTH_SHORT).show();
                    }
                });

                ImageView iconCopy = new ImageView(ListActivity.this); // create a new ImageView
                iconCopy.setImageDrawable(Icon.getDrawable());
                //builder.setView(iconCopy);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}