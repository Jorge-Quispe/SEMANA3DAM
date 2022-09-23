package com.example.trabajo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        private EditText codigos, nombres,precios,stock;
        private SharedPreferences sp;
    public static final String SHARED_PREFS = "sharedPrefs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        codigos = (EditText)findViewById(R.id.txtcodigo);
       nombres = (EditText) findViewById(R.id.txtnombre);
        precios = (EditText) findViewById(R.id.txtprecio);
        stock = (EditText) findViewById(R.id.txtstock);
        sp = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
    }
    public void registrar(View view){
        String cod=  codigos.getText().toString();
        String nom = nombres.getText().toString();
        String prec = precios.getText().toString();
        String cant= stock.getText().toString();
        guardar(cod,nom,prec,cant);

        codigos.setText("");
        nombres.setText("");
        precios.setText("");
        stock.setText("");


    }
    public void buscar(View view){
        String aea1 =  codigos.getText().toString();



        sp =  getSharedPreferences(aea1, Context.MODE_PRIVATE);

        String nombre = sp.getString("nombre" , "");
        String precio = sp.getString("precio" , "");
        String cantidad = sp.getString("cantidad" , "");






        nombres.setText(nombre);
        precios.setText(precio);
        stock.setText(cantidad);


        Toast.makeText(this, nombre+"Nombre Guardado...", Toast.LENGTH_SHORT).show();






    }
    public void guardar(String codigo, String nombre, String precio, String cantidad ) {
        SharedPreferences preferences = getSharedPreferences(codigos.getText().toString(), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= preferences.edit();
        editor.putString("codigo", codigo);
        editor.putString("nombre", nombre);
        editor.putString("precio", precio);
        editor.putString("cantidad", cantidad);
        editor.commit();

        Toast.makeText(this, "Nombre Guardado...", Toast.LENGTH_SHORT).show();

    }

}