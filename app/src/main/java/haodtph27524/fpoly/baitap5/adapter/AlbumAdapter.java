package haodtph27524.fpoly.baitap5.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import haodtph27524.fpoly.baitap5.R;
import haodtph27524.fpoly.baitap5.model.AlbumModel;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {
    private final List<AlbumModel> mListAlbum;

    public AlbumAdapter(List<AlbumModel> mListAlbum) {
        this.mListAlbum = mListAlbum;
    }

    @NonNull
    @Override
    public AlbumAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_album,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumAdapter.ViewHolder holder, int position) {
        AlbumModel album = mListAlbum.get(position);
        if(album == null){
            return;
        }
        holder.tvId.setText(String.valueOf(album.getId()));
        holder.tvTitle.setText(album.getTitle());
        Picasso.get().load(album.getUrl()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return mListAlbum==null?0: mListAlbum.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView  tvId,tvTitle;
        private final ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tv_id);
            tvTitle = itemView.findViewById(R.id.tv_title);
            img = itemView.findViewById(R.id.img_contact);
        }
    }
}
