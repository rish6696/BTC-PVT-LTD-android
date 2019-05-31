package com.example.btcroadlinesprivateltd;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryHolder> {

    ArrayList<Booking> bookinglist;
    static Booking booking;

    public HistoryAdapter(ArrayList<Booking> bookinglist) {
        this.bookinglist = bookinglist;
    }

    @NonNull
    @Override
    public HistoryHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(viewGroup.getContext());
        View view =layoutInflater.inflate(R.layout.historylayout,viewGroup,false);
        HistoryHolder historyHolder=new HistoryHolder(view);
        return historyHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull HistoryHolder historyHolder, int i) {
        String name=bookinglist.get(i).party.partyname;
        char cc=name.charAt(0);
        if (cc>=97&&cc<=122) {
            int v = cc - 32;
            cc = (char) v;
        }
        historyHolder.alphabet.setText(cc+"");
        historyHolder.dat.setText(bookinglist.get(i).date);
        historyHolder.tim.setText(bookinglist.get(i).time);
        historyHolder.partyname.setText(bookinglist.get(i).party.partyname);
        historyHolder.booking=bookinglist.get(i);



        historyHolder.booking=bookinglist.get(i);
        if (bookinglist.get(i).status)
        {
            historyHolder.statusview.setImageResource(R.drawable.ic_stat_complete);
        }
        else{
            historyHolder.statusview.setImageResource(R.drawable.ic_stat_incomplete);

        }

    }

    @Override
    public int getItemCount() {
        return bookinglist.size();
    }

    public class HistoryHolder extends RecyclerView.ViewHolder{

        TextView alphabet,dat,tim,partyname;
        ImageView statusview;
         Truck t;
         Party p;
         TruckSecurity ts;
         PartySecurity ps;

         Booking booking;


        public HistoryHolder(@NonNull View itemView) {
            super(itemView);
            alphabet=(TextView)itemView.findViewById(R.id.partyalphabet);
            dat=(TextView)itemView.findViewById(R.id.date);
            tim=(TextView)itemView.findViewById(R.id.time);
            partyname=(TextView)itemView.findViewById(R.id.plistname);
            statusview=(ImageView)itemView.findViewById(R.id.statushistory);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {



                    HistoryAdapter.booking=booking;
                    Intent intent=new Intent(v.getContext(),HistoryDisplay.class);
                    v.getContext().startActivity(intent);
                }
            });


        }
    }
}
