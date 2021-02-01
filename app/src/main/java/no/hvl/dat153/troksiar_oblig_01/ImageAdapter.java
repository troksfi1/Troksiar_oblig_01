package no.hvl.dat153.troksiar_oblig_01;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private final Context mContext;
    private final List<Uri> photoUriList;
    private final List<String> photoNameList;

    public ImageAdapter(Context context, List<Uri> photoUris, List<String> photoNames) {
        mContext = context;
        photoUriList = photoUris;
        photoNameList = photoNames;
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
        holder.textViewName.setText(photoNameList.get(position));
        holder.imageView.setImageURI(photoUriList.get(position));      //tady bych se nemel brat list z addActivity ale tehle tridy pres constukro naplnenej
        /*Picasso.get()
                .load(photoUriList.get(position))
                .placeholder(R.mipmap.ic_launcher)
                .fit()
                .centerCrop()
                .into(holder.imageView);*/
    }

    @Override
    public int getItemCount() {
        return photoUriList.size();
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName;
        public ImageView imageView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.text_view_name);
            imageView = itemView.findViewById(R.id.image_view_stored);
        }
    }
}
