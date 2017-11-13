package apps.cursos.com.mascotasbasedatos.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import apps.cursos.com.mascotasbasedatos.R;
import apps.cursos.com.mascotasbasedatos.db.ConstructorMascotas;
import apps.cursos.com.mascotasbasedatos.pojo.Mascota;

/**
 * Created by Usuario on 27/10/2017.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
    ArrayList<Mascota> mascotas;
    Activity activity;
    Context context ;
    private static final int LIKE = 1;

    public MascotaAdaptador(ArrayList<Mascota> mascotas , Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }




    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewholder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewholder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewholder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewholder.tvLikes.setText(String.valueOf(mascota.getLikes()));

        mascotaViewholder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + mascota.getNombre() + "\n" + "Almacenado en Favoritos",
                        Toast.LENGTH_SHORT).show();

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.insertarNuevaMascota(mascota);
                constructorMascotas.darLikeMascota(mascota);

            }
        });




    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvLikes;
        private ImageButton btnLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvLikes = (TextView) itemView.findViewById(R.id.tvLikes);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);


        }
    }
}
