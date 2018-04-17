package com.jingju.newstructure;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.File;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ProgressBar mPb = (ProgressBar) findViewById(R.id.pb_progress);
        TextView mTv= (TextView) findViewById(R.id.tv_jindu);
        mTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 new MyThread(mPb).start();
            }
        });

        File externalStorageDirectory = this.getExternalCacheDir();
        Log.d("cache",externalStorageDirectory.getAbsolutePath().toString());


    }
    static class MyThread extends Thread{
        ProgressBar pb;
      public MyThread(ProgressBar pb) {
            this.pb=pb;
        }

        @Override
        public void run() {
            //10s内完成更新
            int progress = pb.getProgress();
            while(progress<100)
            {
                progress++;
                pb.setProgress(progress);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            }

        }
    }
}
