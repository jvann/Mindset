package itesm.mx.mindset;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class DailyQuestion extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btnHappy;
    private ImageButton btnIndifferent;
    private ImageButton btnSad;
    private ImageButton btnFrustrated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_question);

        btnHappy = (ImageButton) findViewById(R.id.imageButton_happy);
        btnIndifferent = (ImageButton) findViewById(R.id.imageButton_indifferent);
        btnSad = (ImageButton) findViewById(R.id.imageButton_sad);
        btnFrustrated = (ImageButton) findViewById(R.id.imageButton_frusrated);

        btnHappy.setOnClickListener(this);
        btnIndifferent.setOnClickListener(this);
        btnSad.setOnClickListener(this);
        btnFrustrated.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.imageButton_happy:
                Toast.makeText(this, "¡Me da mucho gusto! Sigue así", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageButton_indifferent:
                Toast.makeText(this, "¡Ánimo!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageButton_sad:
                Toast.makeText(this, "¡No te desanimes!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageButton_frusrated:
                Toast.makeText(this, "Respira profundo y exhala", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

        finish();
    }
}
