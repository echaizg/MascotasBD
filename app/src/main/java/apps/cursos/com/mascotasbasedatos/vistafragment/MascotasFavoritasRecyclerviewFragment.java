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
import apps.cursos.com.mascotasbasedatos.adapter.MascotaFavoritasAdaptador;
import apps.cursos.com.mascotasbasedatos.pojo.Mascota;
import apps.cursos.com.mascotasbasedatos.presentador.IMascotasFavoritasRecyclerviewFragmentPresenter;
import apps.cursos.com.mascotasbasedatos.presentador.MascotasFavoritasRecyclerviewFragmentPresenter;

/**
 * Created by Usuario on 03/11/2017.
 */
public class MascotasFavoritasRecyclerviewFragment extends Fragment implements IMascotasFavoritasRecyclerviewFragment {

    public ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private RecyclerView rvMascotas;
    private IMascotasFavoritasRecyclerviewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview_mascotas,container,false);
        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas) ;
        presenter = new MascotasFavoritasRecyclerviewFragmentPresenter(this,getContext());


        return v;

    }




    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaFavoritasAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {

        MascotaFavoritasAdaptador adaptador = new MascotaFavoritasAdaptador(mascotas,getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaFavoritasAdaptador adaptador) {
        rvMascotas.setAdapter(adaptador);
    }
}
