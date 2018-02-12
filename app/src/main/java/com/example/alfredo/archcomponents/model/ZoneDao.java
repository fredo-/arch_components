package com.example.alfredo.archcomponents.model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.alfredo.archcomponents.pojos.Zone;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by alfredo on 2/11/18.
 */

@Dao
public interface ZoneDao {
    @Insert(onConflict = REPLACE)
    void save(Zone zone);

    @Query("SELECT * FROM zone")
    LiveData<List<Zone>> getAll();

}
