package com.example.alfredo.archcomponents.pojos;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by alfredo on 2/11/18.
 */

@Entity
public class Session {
    @PrimaryKey
    public long id;
    public long zoneId;
    public String date;
}
