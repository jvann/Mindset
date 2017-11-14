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
 * Created by Jibril on 11/14/17.
 */

public class TipsAdapter extends ArrayAdapter<Tip> {

    public TipsAdapter (Context context, ArrayList<Tip> tips) {
        super(context, 0, tips);
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_tip, parent, false);
        }

        TextView tvName = (TextView) convertView.findViewById(R.id.text_name_tip);
        ImageView ivTip = (ImageView) convertView.findViewById(R.id.image_tip);

        Tip tip = getItem(position);

        tvName.setText(tip.getName());
        ivTip.setImageResource(tip.getPicture());

        return convertView;
    }
}
