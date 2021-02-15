package no.hvl.dat153.troksiar_oblig_01;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.RoomDatabase;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import no.hvl.dat153.troksiar_oblig_01.activities.DatabaseActivity;
import no.hvl.dat153.troksiar_oblig_01.activities.MainActivity;
import no.hvl.dat153.troksiar_oblig_01.data.Item;
import no.hvl.dat153.troksiar_oblig_01.data.ItemRepository;
import no.hvl.dat153.troksiar_oblig_01.data.ItemRoomDatabase;
import no.hvl.dat153.troksiar_oblig_01.data.ItemViewModel;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private final Context mContext;
    private List<Item> itemList;
    //private ItemRoomDatabase database;


    ItemViewModel mItemViewModel;
    //ItemRepository itemRepository;

    public ImageAdapter(Context context, List<Item> items) {
        mContext = context;
        this.itemList = items;
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

        //mItemViewModel.getAllItems();
        //Item item = itemList.get(position);

        //database = ItemRoomDatabase.getDatabase(mContext);

        //holder.textViewName.setText(itemList.get(position).getPhotoName());

        //itemList.add(itemRepository.getAllItems().)

        /*holder.textViewName.setText(MainActivity.photoNames.get(position));
        //holder.imageView.setImageURI(photoUriList.get(position));
        Picasso.get()
                .load(MainActivity.photoUris.get(position))
                .placeholder(R.mipmap.ic_launcher)
                .fit()
                .centerCrop()
                .into(holder.imageView);*/
    }

    @Override
    public int getItemCount() {
        return itemList.size();         //itemList.size();
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

    public void setData(List<Item> items) {
        this.itemList = items;
        notifyDataSetChanged();
    }
}
