package apps.cursos.com.mascotasbasedatos.presentador;

import android.content.Context;

import java.util.ArrayList;

import apps.cursos.com.mascotasbasedatos.db.ConstructorMascotas;
import apps.cursos.com.mascotasbasedatos.pojo.Mascota;
import apps.cursos.com.mascotasbasedatos.vistafragment.IMascotasFavoritasRecyclerviewFragment;

/**
 * Created by Usuario on 11/11/2017.
 */
public class MascotasFavoritasRecyclerviewFragmentPresenter implements IMascotasFavoritasRecyclerviewFragmentPresenter {

    private IMascotasFavoritasRecyclerviewFragment iMascotasFavoritasRecyclerviewFragment;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public MascotasFavoritasRecyclerviewFragmentPresenter( IMascotasFavoritasRecyclerviewFragment iMascotasFavoritasRecyclerviewFragment , Context context) {
        this.iMascotasFavoritasRecyclerviewFragment = iMascotasFavoritasRecyclerviewFragment;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iMascotasFavoritasRecyclerviewFragment.inicializarAdaptadorRV(iMascotasFavoritasRecyclerviewFragment.crearAdaptador(mascotas));
        iMascotasFavoritasRecyclerviewFragment.generarLinearLayoutVertical();
    }
}
