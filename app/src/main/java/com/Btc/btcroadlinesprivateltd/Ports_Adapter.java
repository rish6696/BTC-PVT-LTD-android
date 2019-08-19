package com.Btc.btcroadlinesprivateltd;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Ports_Adapter extends RecyclerView.Adapter<Ports_Adapter.PortsHolder> {

    ArrayList<String> Portnames,uniqueid;

    public Ports_Adapter(ArrayList<String> portnames, ArrayList<String> uniqueid) {

        Portnames = portnames;
        this.uniqueid = uniqueid;
        Log.i("viratkohli",""+Portnames.size());
    }

    @NonNull
    @Override
    public PortsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(viewGroup.getContext());
        View view=layoutInflater.inflate(R.layout.ports_listview,viewGroup,false);
        PortsHolder portsHolder=new PortsHolder(view);
        return portsHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PortsHolder portsHolder, int i) {
        String name=Portnames.get(i);
        char cc=name.charAt(0);
        if (cc>=97&&cc<=122) {
            int v = cc - 32;
            cc = (char) v;
        }
        portsHolder.alphabet.setText(""+cc);
        portsHolder.alphabet.setBackgroundColor(Getcolour());
        portsHolder.portname.setText(name);
        portsHolder.username=Portnames.get(i);

    }

    @Override
    public int getItemCount() {
        return uniqueid.size();
    }
    public int Getcolour(){
        Random random=new Random();
        return Color.argb(255,random.nextInt(256),random.nextInt(256),random.nextInt(256));

    }

    public class PortsHolder extends RecyclerView.ViewHolder{

        TextView alphabet,portname;
        String username;

        public PortsHolder(@NonNull View itemView) {
            super(itemView);
            alphabet=(TextView)itemView.findViewById(R.id.portalphabet);
            portname=(TextView)itemView.findViewById(R.id.portname);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(v.getContext(),Booking_Recview.class);
                    intent.putExtra("username",username);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
