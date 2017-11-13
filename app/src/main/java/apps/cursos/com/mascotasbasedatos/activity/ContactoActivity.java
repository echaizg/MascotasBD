package apps.cursos.com.mascotasbasedatos.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import apps.cursos.com.mascotasbasedatos.R;
import apps.cursos.com.mascotasbasedatos.email.SendMail;

public class ContactoActivity extends AppCompatActivity {

    Button btnEnviarComentario;
    TextView tvNombre ;
    TextView tvCorreo ;
    TextView tvMensaje ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        btnEnviarComentario = (Button) findViewById(R.id.btnEnviarComentario);
        btnEnviarComentario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarCorreo();
            }
        });

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvCorreo = (TextView) findViewById(R.id.tvCorreo);
        tvMensaje = (TextView) findViewById(R.id.tvMensaje);




    }

    private void enviarCorreo() {
        String nombre = tvNombre.getText().toString();
        String correo = tvCorreo.getText().toString();
        String mensaje = tvMensaje.getText().toString();

        SendMail sm = new SendMail(this ,  correo , nombre, mensaje);
        sm.execute();
    }


}
