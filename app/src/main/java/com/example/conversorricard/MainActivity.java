package com.example.conversorricard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText edt1;
    private TextView tx1;
    private TextView tx2;
    private TextView tx3;
    private TextView tx4;
    private Button convert;
    String unitat;
    String conversio;
    String text;
    Spinner sp1;
    int valor10;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = (EditText)findViewById(R.id.valor_inicial);
        String valor = edt1.getText().toString();
        tx1 = (TextView)findViewById(R.id.valor_resultat);
        tx2 = (TextView)findViewById(R.id.valor_resultat2);
        tx3 = (TextView)findViewById(R.id.valor_resultat3);
        tx4 = (TextView)findViewById(R.id.valor_resultat4);


        sp1 = findViewById(R.id.unitatsspinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.unitats, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adapter);
        sp1.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        text = sp1.getSelectedItem().toString();
        if (text.equals("Minuts")){
            try {
                unitat = edt1.getText().toString();
                valor10 = Integer.parseInt(unitat);
                int divisor = 1400;
                int cocient = valor10 / divisor;
                tx4.setText("Dies: "+ cocient);
                int divisor2 = 60;
                int cocient2 = valor10 / divisor2;
                tx3.setText("Hores: "+ cocient2);
                tx2.setText("Minuts: "+ valor10);
                int cocient3 = valor10 * divisor2;
                tx1.setText("Segons: "+ cocient3);

            } catch (Exception e){

            }

        }
        if (text.equals("Segons")){
            try {
                unitat = edt1.getText().toString();
                valor10 = Integer.parseInt(unitat);
                int divisor = 60;
                int cocient = valor10 / divisor;
                tx2.setText("Minuts: "+ cocient);
                int divisor2 = 3600;
                int cocient2 = valor10 / divisor2;
                tx3.setText("Hores: "+ cocient2);
                int divisor3 = 86400;
                int cocient3 = valor10 / divisor3;
                tx4.setText("Dies: "+ cocient3);
                tx1.setText("Segons: " + valor10);

            } catch (Exception e){
            }

        }
        if (text.equals("Hores")){
            try {
                unitat = edt1.getText().toString();
                valor10 = Integer.parseInt(unitat);
                int divisor = 60;
                int cocient = valor10 * divisor;
                tx2.setText("Minuts: "+ cocient);
                int divisor2 = 3600;
                int cocient2 = valor10 * divisor2;
                tx1.setText("Segons: "+ cocient2);
                int divisor3 = 24;
                int cocient3 = valor10 / divisor3;
                tx4.setText("Dies: "+ cocient3);
                tx3.setText("Hores: "+ valor10);

            } catch (Exception e){
            }

        }
        if (text.equals("Dies")){
            try {
                unitat = edt1.getText().toString();
                valor10 = Integer.parseInt(unitat);
                int divisor = 24;
                int cocient = valor10 * divisor;
                tx3.setText( + cocient);
                int divisor2 = 1440;
                int cocient2 = valor10 * divisor2;
                tx2.setText("Minuts: "+ cocient2);
                int divisor3 = 86400;
                int cocient3 = valor10 * divisor3;
                tx4.setText("Dies: "+ valor10);
                tx1.setText("Segons: "+ cocient3);

            } catch (Exception e){
                tx4.setText("Dies: 0");
            }

        }
        conversio = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), conversio, Toast.LENGTH_SHORT).show();



    }



    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}