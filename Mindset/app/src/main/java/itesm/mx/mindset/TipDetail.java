package itesm.mx.mindset;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class TipDetail extends AppCompatActivity {

    private static final String DEBUG_TAG = "TIP_DETAIL";

    private TextView tvNameTip;
    private TextView tvDescriptionTip;
    private ImageView ivTip;
    private Tip tip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_detail);

        tvNameTip = (TextView) findViewById(R.id.text_tip_detail);
        tvDescriptionTip = (TextView) findViewById(R.id.text_tip_description);
        ivTip = (ImageView) findViewById(R.id.image_tip_detail);

        Bundle data = getIntent().getExtras();
        if (data != null) {
            tip = MasterData.getInstance().getTips(data.getInt("position"));
        }

        setViewDetail();
    }

    private void setViewDetail() {

        tvNameTip.setText(tip.getName());
        tvDescriptionTip.setText(tip.getDescription());
        ivTip.setImageResource(tip.getPicture());
    }
}
