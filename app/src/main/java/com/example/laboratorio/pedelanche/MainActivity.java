package com.example.laboratorio.pedelanche;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private GifImageView gifImageView;
    private ProgressBar progressBar;
    private static int SPLASH_TIME_OUT = 9000;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent i = new Intent(MainActivity.this, Login.class);
//                startActivity(i);
//                finish();
//            }
//        },SPLASH_TIME_OUT);
//    }
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Setar ImageView

    gifImageView = (GifImageView) findViewById(R.id.gifImageView);
    progressBar = (ProgressBar) findViewById(R.id.progressBar);
    progressBar.setVisibility(progressBar.VISIBLE);

    try {
        InputStream inputStream = getAssets().open("splash.gif");
        byte[] bytes = IOUtils.toByteArray(inputStream);
        gifImageView.setBytes(bytes);
        gifImageView.startAnimation();

    }
    catch (IOException e)
    {

    }
    // Tempo de espera 3seg

    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            MainActivity.this.startActivity(new Intent(MainActivity.this, Login.class));
            MainActivity.this.finish();
        }
    },SPLASH_TIME_OUT);
}
}
