package itesm.mx.mindset;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jibril on 11/9/17.
 */

public class EventAdapter extends ArrayAdapter<Event> {

    private Context context;

    public EventAdapter (Context context, ArrayList<Event> events) {
        super(context, 0, events);
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_event, parent, false);
        }

        TextView tvName = (TextView) convertView.findViewById(R.id.tv_name_event);
        TextView tvDate = (TextView) convertView.findViewById(R.id.text_dateEvent);

        Event event = getItem(position);
        tvName.setText(event.getName());
        tvDate.setText(event.getDate());

        if (event.getCompleted()){
            ImageView ivImageEvent = (ImageView) convertView.findViewById(R.id.image_event);
            ivImageEvent.setImageResource(R.mipmap.ic_check_circle_black_24dp);
        }

        return convertView;
    }
}
