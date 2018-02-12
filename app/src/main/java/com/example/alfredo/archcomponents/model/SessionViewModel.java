package com.example.alfredo.archcomponents.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.example.alfredo.archcomponents.pojos.Session;
import com.example.alfredo.archcomponents.pojos.SessionZone;

import java.util.List;

/**
 * Created by alfredo on 2/11/18.
 */

public class SessionViewModel extends ViewModel {
    SessionZoneRepository repo;
    LiveData<List<Session>> sessions;
    LiveData<List<SessionZone>> sessionZones;

    public void init(Context context) {
        repo = new SessionZoneRepository(context);
        if (sessions != null) {
            return;
        }
        sessions = repo.getSessions();
        sessionZones = repo.getSessionZones();
    }

    public LiveData<List<Session>> getSessions() {
        return sessions;
    }

    public LiveData<List<SessionZone>> getSessionZones() {
        return sessionZones;
    }
}
