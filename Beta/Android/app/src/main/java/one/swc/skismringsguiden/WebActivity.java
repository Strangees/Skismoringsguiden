package one.swc.skismringsguiden;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;

import org.w3c.dom.ProcessingInstruction;

import java.security.PrivateKey;

public class WebActivity extends AppCompatActivity {
    private WebView webView;
    private Object view;
    private TextView textViewAbout;
    private Button ButtonViewAbout;
    private FirebaseAnalytics mFirebaseAnalytics;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        setContentView(R.layout.activity_web);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ButtonViewAbout = (Button) findViewById(R.id.buttonviewabout);
        textViewAbout = (TextView) findViewById(R.id.textviewabout);
        webView = (WebView) findViewById(R.id.WebView1);

        //WebView Settings
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(false);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);

        //Webview load url
        webView.loadUrl("http://swc.one/skismoring/index.html");
    }

    public void StartWeb(View view){
        webView.loadUrl("http://swc.one/skismoring/index.html");
    }

    public void ExitAbout(View view){
        webView.setVisibility(webView.VISIBLE);
        textViewAbout.setVisibility(textViewAbout.INVISIBLE);
        ButtonViewAbout.setVisibility(ButtonViewAbout.INVISIBLE);
        webView.loadUrl("http://swc.one/skismoring/index.html");
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
            return true;
        }

        if (id == R.id.action_web){
            webView.loadUrl("http://swc.one/skismoring/index.html");
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