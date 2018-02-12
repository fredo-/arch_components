package com.example.alfredo.archcomponents.view;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.alfredo.archcomponents.R;
import com.example.alfredo.archcomponents.model.SessionViewModel;
import com.example.alfredo.archcomponents.model.ZoneViewModel;
import com.example.alfredo.archcomponents.pojos.DisplayItem;
import com.example.alfredo.archcomponents.pojos.Session;
import com.example.alfredo.archcomponents.pojos.SessionZone;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SessionViewModel sessionViewModel;
    ZoneViewModel zoneViewModel;
    SessionsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessionViewModel  = ViewModelProviders.of(this).get(SessionViewModel.class);
        zoneViewModel  = ViewModelProviders.of(this).get(ZoneViewModel.class);

        sessionViewModel.init(this);
        zoneViewModel.init(this);

        RecyclerView recView = findViewById(R.id.recView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recView.setLayoutManager(layoutManager);
        adapter = new SessionsAdapter();
        recView.setAdapter(adapter);

        sessionViewModel.getSessionZones().observe(this, sessionZones -> {
            Log.i("sessionZones", "sessionZones: -------------------");
            for(SessionZone sz: sessionZones) {
                Log.i("sessionZones", "sessionZone: " + sz.toString());
            }
            List<DisplayItem> displayList = new ArrayList<>();
            for (SessionZone sz: sessionZones) {
                displayList.add(new DisplayItem(sz.date, sz.address, sz.zone));
            }
            adapter.setItems(displayList);
        });
    }
}
