package com.example.alfredo.archcomponents.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.example.alfredo.archcomponents.pojos.Zone;

import java.util.List;

/**
 * Created by alfredo on 2/11/18.
 */

public class ZoneViewModel extends ViewModel {
    ZoneRepository repo;
    LiveData<List<Zone>> zones;

    public void init(Context context) {
        repo = new ZoneRepository(context);
        if (zones != null) {
            return;
        }
        zones = repo.getZones();
    }

    public LiveData<List<Zone>> getZones() {
        return zones;
    }
}
