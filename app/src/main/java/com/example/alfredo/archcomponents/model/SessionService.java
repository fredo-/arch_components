package com.example.alfredo.archcomponents.model;

import com.example.alfredo.archcomponents.pojos.Session;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by alfredo on 2/11/18.
 */

public interface SessionService {

    @GET("5a80fe752f00006d00a4c1ab") //3 Sessions
    Call<List<Session>> getSessions();
}
