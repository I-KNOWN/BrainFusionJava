package com.example.brainfusion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Run run = new Run();


        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    ExecutorService executorService = Executors.newSingleThreadExecutor();
                    executorService.execute(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Log.d("returned_Data" ,run.run("train")+"");
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }
                    });

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });




    }
}