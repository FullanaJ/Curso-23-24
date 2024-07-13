package com.example.examenfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.fragment.NavHostFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.navigation.NavController;

import com.example.examenfinal.models.MoveListItem;
import com.example.examenfinal.pokeapi.PokeAPI;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MutableLiveData<List<MoveListItem>> moveList = new MutableLiveData<>();
        PokeAPI.getMoveList(moveList);


    }

    /**
     * Inflo menú
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drawer_menu, menu);
        return true;
    }

    /**
     * Según el id del itmes selecionado se iniciara una Actividad correspondiente
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.movimientos:
                startActivity(new Intent(this,MainActivity.class));
                return true;
            case R.id.items:
                // inicia Actividad items
                //startActivity(new Intent(this,ListadoDeItems.class));
                return true;
            case R.id.Alazar:
                //inicia actividad item alazar
                startActivity(new Intent(this,ItemAlazar.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}