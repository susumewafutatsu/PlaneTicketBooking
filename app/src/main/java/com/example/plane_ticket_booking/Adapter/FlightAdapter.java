package com.example.plane_ticket_booking.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.plane_ticket_booking.Model.Flight;
import com.example.plane_ticket_booking.databinding.ViewholderFlightaBinding;

import java.util.ArrayList;

public class FlightAdapter extends RecyclerView.Adapter<FlightAdapter.Viewholder> {
    private final ArrayList<Flight> flights;
    private Context context;
    public FlightAdapter(ArrayList<Flight> flights){
        this.flights = flights;
    }


    @NonNull
    @Override
    public FlightAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        ViewholderFlightaBinding binding = ViewholderFlightaBinding.inflate(LayoutInflater.from(context),parent,false);

        return new Viewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FlightAdapter.Viewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return flights.size();
    }
    public class Viewholder extends RecyclerView.ViewHolder{
        private final ViewholderFlightaBinding binding;
        public Viewholder(Viewholder binding){
            super(binding.getRoot());
        }
    }
}
