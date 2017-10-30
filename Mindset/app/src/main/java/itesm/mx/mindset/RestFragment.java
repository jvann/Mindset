package itesm.mx.mindset;


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
//    public ImageView ytMed;

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

//        ytMed = (ImageView) container.findViewById(R.id.image_meditation);

        return inflater.inflate(R.layout.fragment_rest, container, false);
    }
}

