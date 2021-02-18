package no.hvl.dat153.troksiar_oblig_01;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import no.hvl.dat153.troksiar_oblig_01.data.Item;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private final Context mContext;
    private List<Item> itemList;

    public ImageAdapter(Context context) {
        mContext = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.image_item, parent, false);
        return new ImageViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        String photoName = itemList.get(position).getPhotoName();
        Bitmap photo = itemList.get(position).getPhoto();

        holder.textViewName.setText(photoName);
        holder.imageView.setImageBitmap(photo);

        /*Picasso.get()
                .load()
                .placeholder(R.mipmap.ic_launcher)
                .fit()
                .centerCrop()
                .into(holder.imageView);*/
    }

    @Override
    public int getItemCount() {
        return itemList == null ? 0 : itemList.size();
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {       //TODO DIFF
        public TextView textViewName;
        public ImageView imageView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.text_view_name);
            imageView = itemView.findViewById(R.id.image_view_stored);
        }
    }

    public void setData(List<Item> items) {
        this.itemList = items;
        notifyDataSetChanged();
    }
}
