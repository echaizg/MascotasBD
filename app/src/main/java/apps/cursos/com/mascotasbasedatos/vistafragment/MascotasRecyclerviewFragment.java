package apps.cursos.com.mascotasbasedatos.vistafragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import apps.cursos.com.mascotasbasedatos.R;
import apps.cursos.com.mascotasbasedatos.adapter.MascotaAdaptador;
import apps.cursos.com.mascotasbasedatos.pojo.Mascota;

/**
 * Created by Usuario on 03/11/2017.
 */
public class MascotasRecyclerviewFragment extends Fragment {

    public ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private RecyclerView rvMascotas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview_mascotas,container,false);

        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas) ;

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        inicializarListaMascotas();
        rvMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
        return v;

    }
    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,getActivity());
        rvMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){

        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Mascota 1", 5 , R.drawable.dog1 ));
        mascotas.add(new Mascota("Mascota 2", 3 , R.drawable.dog2 ));
        mascotas.add(new Mascota("Mascota 3", 2 , R.drawable.dog3 ));
        mascotas.add(new Mascota("Mascota 4", 3 , R.drawable.dog4 ));
        mascotas.add(new Mascota("Mascota 5", 2 , R.drawable.dog5 ));
    }


}
