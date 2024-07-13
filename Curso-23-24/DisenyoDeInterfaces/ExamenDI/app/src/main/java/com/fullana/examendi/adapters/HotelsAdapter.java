package com.fullana.examendi.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fullana.examendi.Objects.Hotel;
import com.fullana.examendi.R;

import java.util.ArrayList;

public class HotelsAdapter extends RecyclerView.Adapter<HotelViewHolder> {

    ArrayList<Hotel> list = repo();
    Context context;

    private ArrayList<Hotel> repo() {
        ArrayList<Hotel> hotels = new ArrayList<>();
        hotels.add(new Hotel(R.drawable.hotel1, "Gamba", "Maiameee"));
        hotels.add(new Hotel(R.drawable.hotel2, "Perro", "Maiameee"));
        hotels.add(new Hotel(R.drawable.hotel3, "Gato", "Valeares"));
        hotels.add(new Hotel(R.drawable.hotel4, "Tuca", "CS.tttt"));
        hotels.add(new Hotel(R.drawable.hotel5, "Geto", "Hola"));
        return hotels;
    }

    @NonNull
    @Override
    public HotelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_hoteles, parent, false);
        context = parent.getContext();
        return new HotelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelViewHolder holder, int position) {
        creaView(list.get(position), holder);
    }

    private void creaView(Hotel hotel, HotelViewHolder holder) {
        holder.imageView.setImageResource(hotel.getSrc());
        holder.name.setText(hotel.getTitulo());
        holder.ubicaction.setText(hotel.getUbicacion());
        holder.button.setOnClickListener((l)-> {
            Toast.makeText(context,"Se ha añadido "+holder.name.getText().toString()+" a tus favoritos",Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}

class HotelViewHolder extends RecyclerView.ViewHolder {

    TextView name, ubicaction;
    ImageView imageView;
    ImageButton button;
    public HotelViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        ubicaction = itemView.findViewById(R.id.ubication);
        imageView = itemView.findViewById(R.id.imageView5);
        button = itemView.findViewById(R.id.imageButton);
    }
}
