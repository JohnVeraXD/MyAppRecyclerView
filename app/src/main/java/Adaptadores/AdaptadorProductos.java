package Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapprecyclerview.R;

import java.util.List;

import Modelos.Productos;


public class AdaptadorProductos extends RecyclerView.Adapter<AdaptadorProductos.ProductoViewHolder>{
    private Context Ctx;
    private List<Productos> lstProductos;

    public AdaptadorProductos(Context mCtx, List<Productos> productos) {
        this.lstProductos = productos;
        Ctx=mCtx;
    }

    @NonNull
    @Override
    public ProductoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view = inflater.inflate(R.layout.layitemview, null);
        return new AdaptadorProductos.ProductoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductoViewHolder holder, int position) {
        Productos usuario = lstProductos.get(position);
        holder.textViewName.setText(usuario.getCategory());
        holder.textViewMail.setText(usuario.getPrice());
        holder.textViewURLAvatar.setText(usuario.getDescription());
        Glide.with(Ctx)
                .load(usuario.getImg())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {return lstProductos.size();}


    class ProductoViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName, textViewURLAvatar, textViewMail;
        ImageView imageView;
        public ProductoViewHolder(View itemView) {
            super(itemView);
            textViewName= itemView.findViewById(R.id.txtName);
            textViewURLAvatar = itemView.findViewById(R.id.txtAvatar);
            textViewMail = itemView.findViewById(R.id.txtMail);
            imageView = itemView.findViewById(R.id.imgAvatar);
        }
    }
}
