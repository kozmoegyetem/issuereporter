package com.kozmosz.issues.network;

import com.kozmosz.issues.model.DamageDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface DamagesApi {

    @POST("clientDamage/add")
    Call<Void> addDamage(
            @Body DamageDTO body
    );

    @DELETE("clientDamage/del/{id}")
    Call<Void> deleteDamage(
            @Path("id") Long id
    );

    @PUT("clientDamage/mod")
    Call<Void> modDamage(
            @Body DamageDTO body
    );

    @GET("clientDamage/get/{id}")
    Call<DamageDTO> getDamage(
            @Path("id") Long id
    );

    @GET("clientDamages")
    Call<List<DamageDTO>> getAllDamage();
}
