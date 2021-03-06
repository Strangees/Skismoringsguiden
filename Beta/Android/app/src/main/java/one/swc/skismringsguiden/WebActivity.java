package one.swc.skismringsguiden;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import com.google.firebase.analytics.FirebaseAnalytics;

import org.w3c.dom.ProcessingInstruction;

import java.io.File;
import java.security.PrivateKey;

public class WebActivity extends AppCompatActivity {
    private WebView webView;
    private Object view;
    private TextView textViewAbout;
    private Button ButtonViewAbout;
    private FirebaseAnalytics mFirebaseAnalytics;
    private AdView mAdView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        setContentView(R.layout.activity_web);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ButtonViewAbout = (Button) findViewById(R.id.buttonviewabout);
        textViewAbout = (TextView) findViewById(R.id.textviewabout);
        webView = (WebView) findViewById(R.id.WebView1);

        //Advview
        MobileAds.initialize(this, "ca-app-pub-2106018268188752~9296363419");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("AD9AF5A795246BB2C7D73DCBB49BBCBC").build();
        mAdView.loadAd(adRequest);


        //WebView Settings
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(false);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);


        //Webview load url
        webView.loadUrl("http://swc.one/skismoring/index.html");
        Toast.makeText(getApplicationContext(), "Velkommen!", Toast.LENGTH_SHORT).show();
    }

    public void StartWeb(View view) {
        webView.loadUrl("http://swc.one/skismoring/index.html");
    }

    public void ExitAbout(View view) {
        webView.setVisibility(webView.VISIBLE);
        textViewAbout.setVisibility(textViewAbout.INVISIBLE);
        ButtonViewAbout.setVisibility(ButtonViewAbout.INVISIBLE);
        //webView.loadUrl("http://swc.one/skismoring/index.html");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_web, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, MySettingsActivity.class);
            startActivity(intent);
        }

        if (id == R.id.action_web) {
            webView.loadUrl("http://swc.one/skismoring/index.html");
            Toast.makeText(getApplicationContext(), "Oppdaterer", Toast.LENGTH_SHORT).show();
        }

        if (id == R.id.action_about) {
            //webView.getVisibility();
            webView.setVisibility(webView.INVISIBLE);
            textViewAbout.setVisibility(textViewAbout.VISIBLE);
            ButtonViewAbout.setVisibility(ButtonViewAbout.VISIBLE);
        }

        if (id == R.id.action_exit) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (webView.canGoBack()) {
                        webView.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }
}