package apps.cursos.com.mascotasbasedatos.vistafragment;

import java.util.ArrayList;

import apps.cursos.com.mascotasbasedatos.adapter.MascotaFavoritasAdaptador;
import apps.cursos.com.mascotasbasedatos.pojo.Mascota;

/**
 * Created by Usuario on 11/11/2017.
 */
public interface IMascotasFavoritasRecyclerviewFragment {

    public void generarLinearLayoutVertical();
    public MascotaFavoritasAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(MascotaFavoritasAdaptador adaptador);



}
