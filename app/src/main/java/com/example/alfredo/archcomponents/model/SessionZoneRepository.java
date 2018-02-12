package com.example.alfredo.archcomponents.model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.alfredo.archcomponents.pojos.Session;
import com.example.alfredo.archcomponents.pojos.SessionZone;
import com.example.alfredo.archcomponents.pojos.Zone;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by alfredo on 2/11/18.
 */

public class SessionZoneRepository {
    private final SessionService sessionService;
    private final ZoneService zoneService;
    private final SessionDao sessionDao;
    private final ZoneDao zoneDao;
    private final Executor executor;

    SessionZoneRepository (Context context) {
        //todo: move this to static class to make as singleton
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://www.mocky.io/v2/")
                .build();

        sessionService = retrofit.create(SessionService.class);
        zoneService = retrofit.create(ZoneService.class);
        //todo put this in static class provider to make singleton
        Database db = Room.databaseBuilder(context, Database.class, "parking.db").fallbackToDestructiveMigration().build();
        sessionDao = db.sessionDao();
        zoneDao = db.zoneDao();
        executor = Executors.newCachedThreadPool();

    }



    public LiveData<List<Session>> getSessions() {
        refreshSessions();

        return sessionDao.getAll();
    }

    public LiveData<List<SessionZone>> getSessionZones() {
        return sessionDao.getSessionZones();
    }

    private void refreshSessions() {
        executor.execute(() -> {
            //Todo: check if you got something in the database for sessions
            Response response = null;
            try {
                response = sessionService.getSessions().execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (Session s: (List<Session>)response.body()) {
                //----------------------------------------------------------
                //fire off the requests to get zones right here from the ids
                //----------------------------------------------------------
                //In Session Dao, you can now access exact data you want from
                //the Session and Zone and tie that up to paging library!
                sessionDao.save(s);
                try {
                    response = zoneService.getZone().execute();
                    zoneDao.save( ((List<Zone>)response.body()).get(0));

                    response = zoneService.getZone1().execute();
                    zoneDao.save( ((List<Zone>)response.body()).get(0));

                    response = zoneService.getZone2().execute();
                    zoneDao.save( ((List<Zone>)response.body()).get(0));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
