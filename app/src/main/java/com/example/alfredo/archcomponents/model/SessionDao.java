package com.example.alfredo.archcomponents.model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.alfredo.archcomponents.pojos.Session;
import com.example.alfredo.archcomponents.pojos.SessionZone;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by alfredo on 2/11/18.
 */

@Dao
public interface SessionDao {
    @Insert(onConflict = REPLACE)
    void save(Session session);

    @Query("SELECT * FROM session")
    LiveData<List<Session>> getAll();

    @Query("SELECT session.date AS date, " +
            "zone.address AS address, " +
            "zone.zone AS zone " +
            "FROM session, zone " +
            "WHERE session.zoneId = zone.id")
    LiveData<List<SessionZone>> getSessionZones();
}
