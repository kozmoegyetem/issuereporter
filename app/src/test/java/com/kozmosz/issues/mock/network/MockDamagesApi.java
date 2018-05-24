package com.kozmosz.issues.mock.network;

import com.kozmosz.issues.model.DamageDTO;
import com.kozmosz.issues.network.DamagesApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MockDamagesApi implements DamagesApi {

    @Override
    public Call<Void> addDamage(DamageDTO body) {
        return successResponse;
    }

    @Override
    public Call<Void> deleteDamage(Long id) {
        return successResponse;
    }

    @Override
    public Call<Void> modDamage(DamageDTO body) {
        return successResponse;
    }

    @Override
    public Call<DamageDTO> getDamage(Long id) {
        return null;
    }

    @Override
    public Call<List<DamageDTO>> getAllDamage() {
        return null;
    }

    private Call<Void> successResponse = new Call<Void>() {
        @Override
        public Response<Void> execute() throws IOException {
            return Response.success(null);
        }

        @Override
        public void enqueue(Callback<Void> callback) {

        }

        @Override
        public boolean isExecuted() {
            return false;
        }

        @Override
        public void cancel() {

        }

        @Override
        public boolean isCanceled() {
            return false;
        }

        @Override
        public Call<Void> clone() {
            return null;
        }

        @Override
        public Request request() {
            return null;
        }
    };

    private Call<List<DamageDTO>> damagesReponse = new Call<List<DamageDTO>>() {
        @Override
        public Response<List<DamageDTO>> execute() throws IOException {
            DamageDTO damageDTO1 = new DamageDTO();
            damageDTO1.setId(0L);
            damageDTO1.setTitle("This is sample title for 0");
            DamageDTO damageDTO2 = new DamageDTO();
            damageDTO2.setId(1L);
            damageDTO2.setTitle("This is sample title for 1");
            List<DamageDTO> damageDTOS = new ArrayList<>();
            damageDTOS.add(damageDTO1);
            damageDTOS.add(damageDTO2);
            return Response.success(damageDTOS);
        }

        @Override
        public void enqueue(Callback<List<DamageDTO>> callback) {

        }

        @Override
        public boolean isExecuted() {
            return false;
        }

        @Override
        public void cancel() {

        }

        @Override
        public boolean isCanceled() {
            return false;
        }

        @Override
        public Call<List<DamageDTO>> clone() {
            return null;
        }

        @Override
        public Request request() {
            return null;
        }
    };
}
