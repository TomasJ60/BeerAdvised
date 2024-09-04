package co.edu.unipiloto.beeradvised;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        spinner= findViewById(R.id.spinner);
        tv1=findViewById(R.id.tv1);

        String [] tiposCervezas= getResources().getStringArray(R.array.building_interactive_apps);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tiposCervezas);
        spinner.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void presionar(View v){
        String seleccion = spinner.getSelectedItem().toString();
        if (seleccion.equals("Lager")){
            tv1.setText("Puedes tomar cervesas como Pilsen, Club colombia dorada y BBC Premier Lager");
        }
        else if(seleccion.equals("negras")){
            tv1.setText("Puedes tomar cervesas como Club colombia negra y Coordillenar negra");
        }
        else if(seleccion.equals("Belgas")){
            tv1.setText("Puedes tomar cervesas como Estella Artois y Paulander");
        }
        else if(seleccion.equals("Alemanas")){
            tv1.setText("Puedes tomar cervesas como Becks, Weidmann, Weissbier");
        }
    }
}