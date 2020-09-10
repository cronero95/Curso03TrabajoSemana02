package com.cronero.curso03trabajosemana02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText campoNombre;
    private TextInputEditText campoFecha;
    private TextInputEditText campoTelefono;
    private TextInputEditText campoCorreo;
    private TextInputEditText campoDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoNombre = findViewById(R.id.campoNombre);
        campoFecha = findViewById(R.id.campoFecha);
        campoTelefono =  findViewById(R.id.campoTelefono);
        campoCorreo = findViewById(R.id.campoCorreo);
        campoDescripcion = findViewById(R.id.campoDescripcion);

        Bundle datos = getIntent().getExtras();

        if (datos!=null){
            String nombre = datos.getString("Nombre");
            String fecha = datos.getString("Fecha");
            String telefono = datos.getString("Telefono");
            String correo = datos.getString("Correo");
            String descripcion = datos.getString("Descripcion");

            campoNombre.setText(nombre);
            campoFecha.setText(fecha);
            campoTelefono.setText(telefono);
            campoCorreo.setText(correo);
            campoDescripcion.setText(descripcion);
        }
    }

    public void showDatePickerDialog(View v) {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                final String selectedDate = day + " / " + (month+1) + " / " + year;
                campoFecha.setText(selectedDate);
            }
        });
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void irConfirmarDatos(View view){
        Intent intent = new Intent(MainActivity.this, ConfirmarDatos.class);

        intent.putExtra("Nombre", campoNombre.getText().toString());
        intent.putExtra("Fecha", campoFecha.getText().toString());
        intent.putExtra("Telefono", campoTelefono.getText().toString());
        intent.putExtra("Correo", campoCorreo.getText().toString());
        intent.putExtra("Descripcion", campoDescripcion.getText().toString());

        startActivity(intent);
    }
}