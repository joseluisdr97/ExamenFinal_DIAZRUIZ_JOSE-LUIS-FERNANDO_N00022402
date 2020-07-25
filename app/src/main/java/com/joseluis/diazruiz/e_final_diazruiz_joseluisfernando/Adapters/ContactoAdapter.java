package com.joseluis.diazruiz.e_final_diazruiz_joseluisfernando.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.joseluis.diazruiz.e_final_diazruiz_joseluisfernando.DetalleContacto;
import com.joseluis.diazruiz.e_final_diazruiz_joseluisfernando.MainActivity;
import com.joseluis.diazruiz.e_final_diazruiz_joseluisfernando.Models.Contacto;
import com.joseluis.diazruiz.e_final_diazruiz_joseluisfernando.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.PokemonViewHolder> {
    private List<Contacto> mData;
    private MainActivity mainActivity;

    public ContactoAdapter(List<Contacto> data, MainActivity mainActivity){
        mData=data;
        this.mainActivity=mainActivity;

    }
    public ContactoAdapter(List<Contacto> data){
        mData=data;
    }
    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.item_contacto,parent,false);
        return new PokemonViewHolder(view,context);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        TextView tvNombreContacto =holder.mView.findViewById(R.id.tvNombreContactoLista);
        TextView tvPhoneContacto=holder.mView.findViewById(R.id.tvPhoneLista);
        ImageView ivContacto=holder.mView.findViewById(R.id.ivContactoLista);

        final Contacto contacto=mData.get(position);
        tvNombreContacto.setText(contacto.getNames());
        tvPhoneContacto.setText(contacto.getPhone());
        Picasso.get().load(contacto.getImage()).into(ivContacto);


        holder.mView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(holder.context, "Este mensaje de click "+ position,Toast.LENGTH_SHORT).show();
                Context context=view.getContext();
                Intent intent=new Intent(context, DetalleContacto.class);
                intent.putExtra("id",contacto.getId());
                intent.putExtra("name",contacto.getNames());
                intent.putExtra("email",contacto.getEmail());
                intent.putExtra("phone",contacto.getPhone());
                //intent.putExtra("imagen",contacto.getImage());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class PokemonViewHolder extends RecyclerView.ViewHolder {
        private View mView;
        public Context context ;
        public PokemonViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            mView=itemView;
            this.context=context;
        }
    }
}
