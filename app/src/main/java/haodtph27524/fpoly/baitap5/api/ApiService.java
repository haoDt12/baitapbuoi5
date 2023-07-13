package haodtph27524.fpoly.baitap5.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import haodtph27524.fpoly.baitap5.model.AlbumModel;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();

    ApiService apiService = new Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    @GET("photos")
    Call<List<AlbumModel>> getListAlbum(@Query("albumId") int albumId);
}
