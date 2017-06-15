package com.example.laboratorio.pedelanche;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOExceptionWithCause;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Professor Sudoeste on 02/06/2017.
 */

public class SplahsScreen extends AppCompatActivity {

    private GifImageView gifImageView;
    private ProgressBar progressBar;
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gifImageView = (GifImageView) findViewById(R.id.gifImageView);
        //progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(progressBar.VISIBLE);

        try {
            InputStream  inputStream = getAssets().open("splash.gif");
            byte[] bytes = IOUtils.toByteArray(inputStream);
            gifImageView.setBytes(bytes);
            gifImageView.startAnimation();

        }
        catch (IOException e)
        {

        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SplahsScreen.this.startActivity(new Intent(SplahsScreen.this, Login.class));
                SplahsScreen.this.finish();
            }
        },SPLASH_TIME_OUT);
    }
}
