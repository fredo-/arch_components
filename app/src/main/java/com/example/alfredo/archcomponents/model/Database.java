package com.example.alfredo.archcomponents.model;

import android.arch.persistence.room.RoomDatabase;

import com.example.alfredo.archcomponents.pojos.Session;
import com.example.alfredo.archcomponents.pojos.Zone;

/**
 * Created by alfredo on 2/11/18.
 */

@android.arch.persistence.room.Database(entities = {Session.class, Zone.class }, version = 2)
public abstract class Database extends RoomDatabase {
    public abstract SessionDao sessionDao();

    public abstract ZoneDao zoneDao();

}
