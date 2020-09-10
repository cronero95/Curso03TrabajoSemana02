package com.cronero.curso03trabajosemana02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    private TextView contactoNombre;
    private TextView contactoFecha;
    private TextView contactoTelefono;
    private TextView contactoCorreo;
    private TextView contactoDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datos_confirmar);

        Bundle datos = getIntent().getExtras();
        String nombre = datos.getString("Nombre");
        String fecha = datos.getString("Fecha");
        String telefono = datos.getString("Telefono");
        String correo = datos.getString("Correo");
        String descripcion = datos.getString("Descripcion");

        contactoNombre = findViewById(R.id.confirmarNombre);
        contactoFecha = findViewById(R.id.confirmarFecha);
        contactoTelefono = findViewById(R.id.confirmarTelefono);
        contactoCorreo = findViewById(R.id.confirmarCorreo);
        contactoDescripcion = findViewById(R.id.confirmarDescripcion);

        contactoNombre.setText(nombre);
        contactoFecha.setText(fecha);
        contactoTelefono.setText(telefono);
        contactoCorreo.setText(correo);
        contactoDescripcion.setText(descripcion);
    }

    public void irEditarDatos(View view){
        Intent intent = new Intent(this, MainActivity.class);

        intent.putExtra("Nombre", contactoNombre.getText().toString());
        intent.putExtra("Fecha", contactoFecha.getText().toString());
        intent.putExtra("Telefono", contactoTelefono.getText().toString());
        intent.putExtra("Correo", contactoCorreo.getText().toString());
        intent.putExtra("Descripcion", contactoDescripcion.getText().toString());

        startActivity(intent);
        finish();
    }
}