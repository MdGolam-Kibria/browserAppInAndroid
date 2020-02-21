package com.example.gk.brawapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    WebView forWeb;
    ImageButton forAccount, home;
    Intent intent;
    Uri uri;
    URL url;
    EditText forSearch;
    Button clickbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        forSearch = (EditText) findViewById(R.id.forsearch);
        forWeb = (WebView) findViewById(R.id.forWeb);
        clickbtn = (Button) findViewById(R.id.btnCLik);
        forAccount = (ImageButton) findViewById(R.id.forAccount);
        home = (ImageButton) findViewById(R.id.home);
        intent = getIntent();
        uri = intent.getData();
        if (uri == null) {

        } else {
            try {
                url = new URL(uri.getScheme(), uri.getHost(), uri.getPath());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            forWeb.setWebViewClient(new WebViewClient());//jano amer brawser ai run kora.
            forWeb.loadUrl(url.toString());
        }

        clickbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forWeb.setWebViewClient(new WebViewClient());
                WebSettings obj = forWeb.getSettings();//web view ar all setting control korta parbo ai object dara
                obj.setJavaScriptEnabled(true);
                forWeb.loadUrl("https://www."+forSearch.getText().toString()+".com");
            }
        });

        //for login account

        forAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forWeb.setWebViewClient(new WebViewClient());
                WebSettings ok = forWeb.getSettings();
                ok.setJavaScriptEnabled(true);
                forWeb.loadUrl("https://accounts.google.com/signin/v2/identifier?passive=1209600&continue=https%3A%2F%2Faccounts.google.com%2FManageAccount&followup=https%3A%2F%2Faccounts.google.com%2FManageAccount&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                forWeb.setWebViewClient(new WebViewClient());
                WebSettings kk = forWeb.getSettings();
                kk.setJavaScriptEnabled(true);
                forWeb.loadUrl("https://www.google.com/");
            }
        });

    }


    @Override
    public void onBackPressed() {
        if (forWeb.canGoBack()) {
            forWeb.goBack();
        } else {
            super.onBackPressed();
        }
    }



}
