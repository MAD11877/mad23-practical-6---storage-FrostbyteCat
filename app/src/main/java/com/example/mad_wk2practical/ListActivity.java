package com.example.mad_wk2practical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.content.DialogInterface;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Random;


public class ListActivity extends AppCompatActivity {

    Boolean followed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //Creating the 20 users
        ArrayList<User> users = new ArrayList<>();
        int id = 1;
        for (int i = 0; i < 20; i++) {
            users.add(new User(randomName(), randomDescription(), id, randomFollowed()));
            id++;
        }

        RecyclerView rv = findViewById(R.id.recyclerview);
        Adapter adapter = new Adapter(this, users);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        lm.setOrientation(RecyclerView.VERTICAL);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(adapter);
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.item_spacing);
        rv.addItemDecoration(new SpaceItemDecoration(spacingInPixels));

    }

    public static String randomName() {
        Random rand = new Random();
        String name = "";
        int number = rand.nextInt(99999999) + 1;
        name = "Name" + " " + number;
        return name;
    }

    public static String randomDescription() {
        Random rand = new Random();
        long number = rand.nextLong() % 10000000000L;
        if (number < 0) {
            number = -number;
        }
        return String.format("%010d", number);
    }

    public static boolean randomFollowed() {
        Random rand = new Random();
        return rand.nextBoolean();
    }

    public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
        private final int verticalSpaceHeight;

        public SpaceItemDecoration(int verticalSpaceHeight) {
            this.verticalSpaceHeight = verticalSpaceHeight;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            outRect.bottom = verticalSpaceHeight;
        }
    }

}