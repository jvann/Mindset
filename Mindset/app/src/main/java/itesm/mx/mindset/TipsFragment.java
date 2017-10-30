package itesm.mx.mindset;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebViewFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class TipsFragment extends Fragment {

    private WebView myWebView;
    private String url = "http://www.who.int/topics/nutrition/es/";
//    private String url = "https://www.youtube.com/watch?v=StkLx0e4f6c";
    private WebSettings myWebSettings;

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

        myWebView = (WebView) rootView.findViewById(R.id.webview);

        myWebSettings = myWebView.getSettings();
        myWebSettings.setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new MyWebViewClient());
        myWebView.loadUrl(url);

        return rootView;
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return true;
        }
    }

}
