package apps.cursos.com.mascotasbasedatos.vistafragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import apps.cursos.com.mascotasbasedatos.R;
import apps.cursos.com.mascotasbasedatos.adapter.PerfilAdaptador;
import apps.cursos.com.mascotasbasedatos.pojo.Mascota;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {
    public ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private RecyclerView rvMascotas;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_perfil, container, false);

        rvMascotas = (RecyclerView) v.findViewById(R.id.rvPerfilMascota) ;

        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);


        inicializarListaMascotas();
        rvMascotas.setLayoutManager(glm);
        inicializarListaMascotas();
        inicializarAdaptador();
        return v;

    }
    public void inicializarAdaptador(){
        PerfilAdaptador adaptador = new PerfilAdaptador(mascotas,getActivity());
        rvMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){

        mascotas = new ArrayList<Mascota>();



        mascotas.add(new Mascota("Mascota 2", 3 , R.drawable.dog2 ));
        mascotas.add(new Mascota("Mascota 2", 2 , R.drawable.dog2 ));
        mascotas.add(new Mascota("Mascota 2", 5 , R.drawable.dog2 ));
        mascotas.add(new Mascota("Mascota 2", 6 , R.drawable.dog2 ));
        mascotas.add(new Mascota("Mascota 2", 4 , R.drawable.dog2 ));
        mascotas.add(new Mascota("Mascota 2", 1 , R.drawable.dog2 ));
        mascotas.add(new Mascota("Mascota 2", 0 , R.drawable.dog2 ));
        mascotas.add(new Mascota("Mascota 2", 2 , R.drawable.dog2 ));
        mascotas.add(new Mascota("Mascota 2", 6 , R.drawable.dog2 ));
        mascotas.add(new Mascota("Mascota 2", 3 , R.drawable.dog2 ));

    }


}
