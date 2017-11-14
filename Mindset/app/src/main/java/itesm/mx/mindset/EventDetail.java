package itesm.mx.mindset;

/**
 * Created by Jibril on 11/9/17.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class EventDetail extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<Event> eventList;
    private EventsOperations dao;
    private int position;

    private ImageView ivImage;
    private TextView tvEvent;
    private TextView tvDate;
    private TextView tvDescription;
    private Button btnDone;

//    private EventsOperations dao;

    private static String DEBUG_TAG = "EVENT_DETAIL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);

        ivImage = (ImageView) findViewById(R.id.image_status);
        tvEvent = (TextView) findViewById(R.id.text_detail_event);
        tvDate = (TextView) findViewById(R.id.text_event_date);
        tvDescription = (TextView) findViewById(R.id.text_event_description);
        btnDone = (Button) findViewById(R.id.button_done_task);

        dao = new EventsOperations(this.getApplicationContext());
        dao.open();

        eventList = dao.getAllEvents();

        Bundle data = getIntent().getExtras();
        if (data != null) {
            position = data.getInt("position");
            setViewDetail(data.getInt("position"));
        }

        btnDone.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        dao.updateStatusTask(position);
        Toast.makeText(this, "Excelente!", Toast.LENGTH_SHORT).show();
        finish();
    }

    private void setViewDetail(int position) {

        if (eventList.get(position).getCompleted())
            ivImage.setImageResource(R.mipmap.ic_check_circle_black_24dp);

        tvEvent.setText(eventList.get(position).getName());
        tvDate.setText(eventList.get(position).getDate() + " - " + eventList.get(position).getHour());
        tvDescription.setText(eventList.get(position).getDescription());
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(DEBUG_TAG, "onStart() has been called.");
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
