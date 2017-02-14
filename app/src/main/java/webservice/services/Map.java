package webservice.services;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by KeeporderGO on 2/1/2017.
 */

public class Map {
    public interface getPolygon {
        @GET("maps/api/directions/json")
        //https://maps.googleapis.com/maps/api/directions/json?origin=11.5661763,104.8932169&destination=11.575766,104.8869783
        Call<JsonObject> getPolyLineStr(@Query("origin") String origin, @Query("destination") String destination, @Query("key") String key);
    }
}
