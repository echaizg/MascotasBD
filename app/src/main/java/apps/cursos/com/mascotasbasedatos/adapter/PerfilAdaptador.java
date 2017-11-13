package apps.cursos.com.mascotasbasedatos.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import apps.cursos.com.mascotasbasedatos.R;
import apps.cursos.com.mascotasbasedatos.pojo.Mascota;

/**
 * Created by Usuario on 03/11/2017.
 */
public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.MascotaViewHolder> {
    ArrayList<Mascota> mascotas;
    Activity activity;

    public PerfilAdaptador(ArrayList<Mascota> mascotas , Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }




    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfilmascota,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewholder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewholder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewholder.tvLikes.setText(String.valueOf(mascota.getLikes()));


    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvLikes;


        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvLikes = (TextView) itemView.findViewById(R.id.tvLikes);


        }
    }
}
