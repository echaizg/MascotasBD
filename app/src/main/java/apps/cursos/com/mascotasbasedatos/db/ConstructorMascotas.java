package apps.cursos.com.mascotasbasedatos.db;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import apps.cursos.com.mascotasbasedatos.R;
import apps.cursos.com.mascotasbasedatos.pojo.Mascota;

/**
 * Created by Usuario on 11/11/2017.
 */
public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){

      ArrayList<Mascota >  mascotas = new ArrayList<Mascota>();
/*
        mascotas.add(new Mascota("Mascota 5", 2 , R.drawable.dog5 ));
        mascotas.add(new Mascota("Mascota 4", 3 , R.drawable.dog4 ));
        mascotas.add(new Mascota("Mascota 3", 2 , R.drawable.dog3 ));
        mascotas.add(new Mascota("Mascota 2", 3 , R.drawable.dog2 ));
        mascotas.add(new Mascota("Mascota 1", 5 , R.drawable.dog1 ));
        return mascotas;*/

        BaseDatos db = new BaseDatos(context);
       // insertarCincoMascotas(db);
        db.obtenerTodasLasMascotas();
        return db.obtenerTodasLasMascotas();
    }


    public  void insertarNuevaMascota(Mascota mascota) {
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, mascota.getNombre());
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,mascota.getFoto());
        db.insertarMascota(contentValues);
        darLikeMascota(mascota);

    }

    public  void insertarCincoMascotas(BaseDatos db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Mascota 3");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.dog3);
        db.insertarMascota(contentValues);


        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Mascota 2");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.dog2);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Mascota 1");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.dog1);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Mascota 4");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.dog4);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Mascota 5");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.dog5);
        db.insertarMascota(contentValues);

    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES, LIKE);

        db.insertarLikeMacota(contentValues);
    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }
}
