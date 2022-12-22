package com.ricardo_rivera_beltran.sprintcuatro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.ricardo_rivera_beltran.sprintcuatro.Adaptadores.ProductoAdapter;
import com.ricardo_rivera_beltran.sprintcuatro.DB.DBFirebase;
import com.ricardo_rivera_beltran.sprintcuatro.Entidades.Producto;

import java.util.ArrayList;

public class Catalogo extends AppCompatActivity {

    private DBFirebase dbFirebase;
    private ListView listViewProducts;
    private ArrayList<Producto> arrayProductos;
    private ProductoAdapter productoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);

        listViewProducts = (ListView) findViewById(R.id.ListViewProductos);
        arrayProductos = new ArrayList<>();
        dbFirebase = new DBFirebase();
    /*
        // **** PRODUCTOS
        Producto producto1 = new Producto("Producto1", "Desc1", 10000, "", "", "");
        Producto producto2 = new Producto("Producto2", "Desc2", 10000, "", "", "");
        Producto producto3 = new Producto("Producto3", "Desc3", 10000, "", "", "");
        Producto producto4 = new Producto("Producto4", "Desc4", 10000, "", "", "");
        Producto producto5 = new Producto("Producto5", "Desc5", 10000, "", "", "");
        Producto producto6 = new Producto("Producto6", "Desc6", 10000, "", "", "");

        arrayProductos.add(producto1);
        arrayProductos.add(producto2);
        arrayProductos.add(producto3);
        arrayProductos.add(producto4);
        arrayProductos.add(producto5);
        arrayProductos.add(producto6);

        // **** **** ****
    */
        productoAdapter = new ProductoAdapter(this, arrayProductos);
        listViewProducts.setAdapter(productoAdapter);

        dbFirebase.getData(productoAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        Intent intent;
        switch (item.getItemId()){
            case R.id.itemAdd:
                intent = new Intent(getApplicationContext(), Form.class);
                startActivity(intent);
                return true;
            case R.id.itemMap:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}