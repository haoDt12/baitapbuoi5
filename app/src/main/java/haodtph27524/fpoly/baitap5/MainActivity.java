package haodtph27524.fpoly.baitap5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import haodtph27524.fpoly.baitap5.adapter.AlbumAdapter;
import haodtph27524.fpoly.baitap5.api.ApiService;
import haodtph27524.fpoly.baitap5.model.AlbumModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcvAlbum;
    private List<AlbumModel> mListAlbum;
    private ProgressBar progressBar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvAlbum = (RecyclerView) findViewById(R.id.rcv_album);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvAlbum.setLayoutManager(linearLayoutManager);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        rcvAlbum.addItemDecoration(itemDecoration);

        mListAlbum = new ArrayList<>();
        callApiGetAlbum();

    }
    private void callApiGetAlbum(){
        ApiService.apiService.getListAlbum(1).enqueue(new Callback<List<AlbumModel>>() {
            @Override
            public void onResponse(Call<List<AlbumModel>> call, Response<List<AlbumModel>> response) {
                mListAlbum = response.body();
                AlbumAdapter adapter = new AlbumAdapter(mListAlbum);
                rcvAlbum.setAdapter(adapter);
                rcvAlbum.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<List<AlbumModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_SHORT).show();
            }
        });
    }
}