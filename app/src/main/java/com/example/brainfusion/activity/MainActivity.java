package com.example.brainfusion.activity;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.brainfusion.R;
import com.example.brainfusion.apiCall.Run;
import com.example.brainfusion.apiInterface.CallBackService;
import com.example.brainfusion.enums.AIStyle;
import com.example.brainfusion.enums.Resolution;
import com.example.brainfusion.utils.EnumMethods;

public class MainActivity extends AppCompatActivity {

    public Dialog dialog;
    private EnumMethods enumMethods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Run run = new Run(MainActivity.this);
        enumMethods = new EnumMethods();
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.progress_dialog_image);
        dialog.setCancelable(false);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    dialog.show();
                    EditText editText = findViewById(R.id.et_data);
                    String queryString = editText.getText().toString();

                    run.run(queryString, enumMethods.getStyle(AIStyle.cartoon), enumMethods.getResolution(Resolution.r1x1), new CallBackService() {
                        @Override
                        public void onImageFound(String img) {
                            if (img != null) {
                                Log.d("Run TAG", img);


                                byte[] encodeByte = Base64.decode(img, Base64.DEFAULT);
                                Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);

                                ImageView imageView = findViewById(R.id.iv_gen);
                                imageView.setImageBitmap(bitmap);
                                dialog.dismiss();

                            }else{
                                Toast.makeText(MainActivity.this, "Failed To Get Images", Toast.LENGTH_LONG).show();
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