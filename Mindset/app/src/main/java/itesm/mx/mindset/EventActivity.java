package itesm.mx.mindset;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class EventActivity extends AppCompatActivity implements View.OnClickListener {

    private String DEBUG_TAG = "CREATE_EVENT";

    private EventsOperations dao;

    private Button btnAccept;
    private EditText etName;
    private EditText etHours;
    private EditText etDescription;
    private DatePicker dpDate;
    private TimePicker tpTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        dao = new EventsOperations(this);
        dao.open();

        btnAccept = (Button) findViewById(R.id.button_accept_event);
        etName = (EditText) findViewById(R.id.edit_name);
        etHours = (EditText) findViewById(R.id.edit_hours);
        etDescription = (EditText) findViewById(R.id.edit_description);
        dpDate = (DatePicker) findViewById(R.id.datePicker_date);
        tpTime = (TimePicker) findViewById(R.id.timePicker_time);

        btnAccept.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (!etName.getText().toString().equals("") && !etHours.getText().toString().equals("") && !etDescription.getText().toString().equals("")) {
            String sInput = String.valueOf(dpDate.getDayOfMonth() + "/" + dpDate.getMonth() + "/" + dpDate.getYear()) + " - " + etName.getText().toString() +
                    " - " + String.valueOf(tpTime.getCurrentHour() + ":" + tpTime.getCurrentMinute()) + " - " +
                    etDescription.getText().toString() + " - " + Integer.parseInt(etHours.getText().toString());

            Event event = new Event( String.valueOf(dpDate.getDayOfMonth() + "/" + dpDate.getMonth() + "/" + dpDate.getYear()),
                    String.valueOf(tpTime.getCurrentHour() + ":" + tpTime.getCurrentMinute()),
                    etName.getText().toString(),
                    etDescription.getText().toString(),
                    Integer.parseInt(etHours.getText().toString()),
                    false
            );
            Log.d(DEBUG_TAG, sInput);
            dao.addEvent(event);
            Toast.makeText(this, "Actividad creada", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "Datos requeridos", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onResume() {
        dao.open();
        super.onResume();
        Log.d(DEBUG_TAG, "onResume() has been called.");
    }

    @Override
    public void onPause() {
        dao.close();
        super.onPause();
        Log.d(DEBUG_TAG, "onPause() has been called.");
    }
}
