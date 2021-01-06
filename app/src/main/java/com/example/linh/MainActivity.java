package com.example.linh;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {
    Bitmap bmp;
    String username = "18120558";
    String duration = "01:01:05";
    String pace = "2.3";
    String distance = "8.0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bmp = BitmapFactory.decodeResource(getResources(),
                R.drawable.image);
    }

    public void btn_add_onclick(View view){
        sendIntent();
    }

    public void sendIntent(){
//        ByteArrayOutputStream stream = new ByteArrayOutputStream();
//        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
//        byte[] img_array = stream.toByteArray();
        String img_array = getStringImage(bmp);
        Intent intent = new Intent(this, save_activity.class);
        intent.putExtra("username", username);
        intent.putExtra("duration", duration);
        intent.putExtra("pace", pace);
        intent.putExtra("distance", distance);
//        intent.putExtra("image", img_array);
        startActivity(intent);
    }

    public String getStringImage(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

}