package com.rmkisancentre.rmc;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class BookingFragment extends Fragment  implements View.OnClickListener,View.OnKeyListener  {


    View v;

    WebView webView;

    SharedPreferences sharedPreferences;


    public BookingFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static BookingFragment newInstance(String param1, String param2) {
        BookingFragment fragment = new BookingFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_booking, container, false);
        webView=v.findViewById(R.id.webView);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);


        // Initialize SharedPreferences
        sharedPreferences = getActivity().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);

        String username = sharedPreferences.getString("username", "baba");

        String number = sharedPreferences.getString("number", "");


        String url="https://app.rmkisancentre.com/index2.php?username=".concat(username);

        // Load a web page in the WebView
        webView.loadUrl(url);

        // Set a WebViewClient to handle page navigation within the WebView
        webView.setWebViewClient(new WebViewClient());

        // Set a WebChromeClient for JavaScript dialogs and alerts
        webView.setWebChromeClient(new WebChromeClient());


        webView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        return v;
    }

    @Override
    public void onClick(View view) {

    }




    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        return false;
    }
}