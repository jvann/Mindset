package itesm.mx.mindset;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TipsFragment extends Fragment implements AdapterView.OnItemClickListener {

    private static final String DEBUG_TAG = "TIPS_FRAGMENT";
    private TipsAdapter adapter;
    private ListView list;

    public TipsFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance(){

        return new TipsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tips, container, false);

        list = (ListView) rootView.findViewById(R.id.list_tips);
        list.setOnItemClickListener(this);
        adapter = new TipsAdapter(getContext(), MasterData.getInstance().getAllTips());//HERE POSSIBLE PROBLEM
        list.setAdapter(adapter);

        return rootView;
    }

    //Adds elements to the list fragment.
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //simple_list_item_activated_1 allows the change of color in the background.
        // when the item from the list is selected(clicked).

        Log.d(DEBUG_TAG, "onActivityCreated() has been called.");
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        OnItemClickedListener listener = (OnItemClickedListener) getActivity();

        Log.d(DEBUG_TAG, "onListItemClick() has been called.");
        listener.onTipSelected(position);
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.d(DEBUG_TAG, "onStart() has been called.");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(DEBUG_TAG, "onResume() has been called.");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(DEBUG_TAG, "onPause() has been called.");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(DEBUG_TAG, "onStop() has been called.");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(DEBUG_TAG, "onDestroyView() has been called.");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(DEBUG_TAG, "onDestroy() has been called.");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(DEBUG_TAG, "onDetach() has been called.");
    }
}
