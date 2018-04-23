package hu.viktorkozma.issuereport;

import java.util.List;

import hu.viktorkozma.issuereport.Data.Issue;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IssuesApi {


    @DELETE("issues/del/{id}")
    Call<Void> deleteDamage(
            @Path("id") Long id
    );

    @PUT("issues/fix/{id}")
    Call<Void> modDamage(
            @Body Issue body
    );

    @GET("issues/")
    Call<List<Issue>> getAllDamage();
}
