package com.example.brainfusion.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.brainfusion.R;
import com.example.brainfusion.apiCall.Run;
import com.example.brainfusion.enums.AIStyle;
import com.example.brainfusion.enums.Resolution;
import com.example.brainfusion.utils.EnumMethods;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {


    private EnumMethods enumMethods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Run run = new Run();
        enumMethods = new EnumMethods();

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    ExecutorService executorService = Executors.newSingleThreadExecutor();
                    executorService.execute(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                run.run("train", enumMethods.getStyle(AIStyle.cartoon), enumMethods.getResolution(Resolution.r1x1) );
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