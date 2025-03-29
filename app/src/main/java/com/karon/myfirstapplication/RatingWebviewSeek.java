package com.karon.myfirstapplication;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RatingWebviewSeek extends AppCompatActivity {

//    Button btnsubmit;
//    RatingBar ratingBar;
 //   WebView webview;

    SeekBar seekbar;
    TextView txtoutput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rating_webview_seek);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        seekbar = (SeekBar) findViewById(R.id.seekbar);
        txtoutput = (TextView) findViewById(R.id.txtoutput);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                txtoutput.setText(""+i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


//        webview = (WebView) findViewById(R.id.webview);
//        WebSettings websetting = webview.getSettings();
//        websetting.setJavaScriptEnabled(true);
//
//        webview.setWebViewClient((new WebViewClient()));
//        webview.loadUrl("https://karonittraining.com/");




//        ratingBar= (RatingBar) findViewById(R.id.ratingBar);
//        btnsubmit = (Button) findViewById(R.id.btnsubmit);
//
//        btnsubmit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                float rating = ratingBar.getRating();
//                Toast.makeText(RatingWebviewSeek.this, ""+rating, Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}