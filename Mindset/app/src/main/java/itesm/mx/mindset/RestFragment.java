package itesm.mx.mindset;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestFragment extends Fragment {

//    public static final String DEVELOPER_KEY = "AIzaSyAy0CvwCL4O1yHH682zdFQBX2Z3gWra6kI";
    public ImageView ivMed;

    public RestFragment() {
        // Required empty public constructor
    }

    public static RestFragment newInstance(){

        return new RestFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_rest, container, false);

        ivMed = (ImageView) rootView.findViewById(R.id.image_meditation);
        Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.samplemeditation);
        image = Bitmap.createScaledBitmap(image, 200, 200, true);
        ivMed.setImageBitmap(image);

        return rootView;
    }
}

