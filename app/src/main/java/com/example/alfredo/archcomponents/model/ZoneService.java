package com.example.alfredo.archcomponents.model;

import com.example.alfredo.archcomponents.pojos.Zone;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by alfredo on 2/11/18.
 */

public interface ZoneService {
    @GET("5a80ff2e2f00006e00a4c1ad")//zone0 in an array
    Call<List<Zone>> getZone();

    @GET("5a81b3d52f00005e00718d58")//zone1 in an array
    Call<List<Zone>> getZone1();

    @GET("5a81b3ff2f00006300718d59")//zone2 in an array
    Call<List<Zone>> getZone2();
}

