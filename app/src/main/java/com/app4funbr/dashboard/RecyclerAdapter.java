package com.app4funbr.dashboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.LineHolder> {

    private final List<Cidade> cidades;

    public RecyclerAdapter(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    @NonNull
    @Override
    public LineHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LineHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LineHolder holder, int position) {
        holder.pais.setText(cidades.get(position).getPais());
        holder.cidade.setText(cidades.get(position).getCidade());

        Picasso.get().load(cidades.get(position).getUrlFoto()).into(holder.background_card);
    }

    @Override
    public int getItemCount() {
        return cidades != null ? cidades.size() : 0;
    }

    public void updateList(Cidade cidade) {
        insertItem(cidade);
    }

    // Método responsável por inserir um novo usuário na lista
    //e notificar que há novos itens.
    private void insertItem(Cidade cidade) {
        cidades.add(cidade);
        notifyItemInserted(getItemCount());
    }

    public class LineHolder extends RecyclerView.ViewHolder {

        public TextView pais;
        public TextView cidade;
        public ImageView background_card;

        public LineHolder(@NonNull View itemView) {
            super(itemView);

            pais = itemView.findViewById(R.id.pais);
            cidade = itemView.findViewById(R.id.cidade);
            background_card = itemView.findViewById(R.id.image_list);
        }
    }
}
