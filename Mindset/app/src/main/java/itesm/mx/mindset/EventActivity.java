package itesm.mx.mindset;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EventActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnAccept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        btnAccept = (Button) findViewById(R.id.button_accept_event);
        btnAccept.setOnClickListener(this);
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_add);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(EventActivity.this, "Actividad creada", Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, "Actividad creada", Toast.LENGTH_SHORT).show();
        finish();
    }
}
