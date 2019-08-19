package com.Btc.btcroadlinesprivateltd;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Booking_recview_Adapter extends RecyclerView.Adapter<Booking_recview_Adapter.Bookingholder> {
    ArrayList<Booking> bookings;
    static Booking booking;


    public Booking_recview_Adapter(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }

    @NonNull
    @Override
    public Bookingholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(viewGroup.getContext());
        View view =layoutInflater.inflate(R.layout.booking_listiew,viewGroup,false);
        Bookingholder bookingholder=new Bookingholder(view);
        return bookingholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Bookingholder bookingholder, int i) {
        String name=bookings.get(i).partyAdvance.partyname;
        char cc=name.charAt(0);
        if (cc>=97&&cc<=122) {
            int v = cc - 32;
            cc = (char) v;
        }
        bookingholder.partyname.setText(name);
        bookingholder.alphabet.setText(""+cc);
        bookingholder.alphabet.setBackgroundColor(Getcolour());
        bookingholder.dat.setText(bookings.get(i).date);
        bookingholder.tim.setText(bookings.get(i).time);
        bookingholder.booking=bookings.get(i);

    }
    public int Getcolour(){
        Random random=new Random();
        return Color.argb(255,random.nextInt(256),random.nextInt(256),random.nextInt(256));

    }

    @Override
    public int getItemCount() {
        return bookings.size();
    }

    public class Bookingholder extends RecyclerView.ViewHolder{
        TextView alphabet,dat,tim,partyname;
        Booking booking;


        public Bookingholder(@NonNull View itemView) {
            super(itemView);
            alphabet=(TextView)itemView.findViewById(R.id.partyalphabet);
            partyname=(TextView)itemView.findViewById(R.id.plistname);
            dat=(TextView)itemView.findViewById(R.id.date);
            tim=(TextView)itemView.findViewById(R.id.time);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Booking_recview_Adapter.booking=booking;
                    Intent intent=new Intent(v.getContext(),DisplayInfo.class);
                    v.getContext().startActivity(intent);
                }
            });

        }
    }
}
