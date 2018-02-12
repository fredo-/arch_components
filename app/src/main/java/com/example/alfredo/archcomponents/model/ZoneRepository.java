package com.example.alfredo.archcomponents.model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.alfredo.archcomponents.pojos.Zone;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by alfredo on 2/11/18.
 */

class ZoneRepository {
    private final ZoneDao zoneDao;

    ZoneRepository (Context context) {
//        Retrofit retrofit = new Retrofit.Builder()
//                .addConverterFactory(GsonConverterFactory.create())
//                .baseUrl("http://www.mocky.io/v2/")
//                .build();
        Database db = Room.databaseBuilder(context, Database.class, "parking.db").fallbackToDestructiveMigration().build();
        zoneDao = db.zoneDao();
    }

    public LiveData<List<Zone>> getZones() {
        //zones are already fetched by session right now.. coupled and bad, but this is a PoC
        return zoneDao.getAll();
    }
}
