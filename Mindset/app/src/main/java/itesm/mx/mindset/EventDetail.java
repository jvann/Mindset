package itesm.mx.mindset;

/**
 * Created by Jibril on 11/9/17.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class EventDetail extends AppCompatActivity {

    private ArrayList<Event> eventList;

    private ImageView ivPicture;
    private TextView tvNameElectro;
    private TextView tvDate;

//    private EventsOperations dao;

    private static String DEBUG_TAG = "EVENT_DETAIL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);

        ivPicture = (ImageView) findViewById(R.id.image_event_detail);
        tvNameElectro = (TextView) findViewById(R.id.text_detail_event);
        tvDate = (TextView) findViewById(R.id.text_event_date);

//        dao = new EventsOperations(this.getApplicationContext());
//        dao.open();

        eventList = MasterData.getInstance().getAllEvents();

        Bundle data = getIntent().getExtras();
        if (data != null) {
            setViewDetail(data.getInt("position"));
        }

    }

    private void setViewDetail(int position) {
        ivPicture.setImageResource(eventList.get(MasterData.getInstance().getEvent(eventList.get(position).getName())).getPicture());
        tvNameElectro.setText(eventList.get(position).getName());
        tvDate.setText(eventList.get(position).getDate() + "\n" + eventList.get(position).getHour());
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.d(DEBUG_TAG, "onStart() has been called.");
    }

    @Override
    public void onResume() {
//        dao.open();
        super.onResume();
        Log.d(DEBUG_TAG, "onResume() has been called.");
    }

    @Override
    public void onPause() {
//        dao.close();
        super.onPause();
        Log.d(DEBUG_TAG, "onPause() has been called.");
    }
}
