package com.example.yichenliu.cs125finalproject;
import android.media.Image;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ImageView;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static ImageView imgview;
    private int currentImage;
    int[] images = {R.drawable.asianfood2, R.drawable.asianfood3, R.drawable.asianfood3,
            R.drawable.asianfood4, R.drawable.bbq1, R.drawable.bbq2, R.drawable.bbq3,
            R.drawable.bbq4, R.drawable.burger1, R.drawable.burger2, R.drawable.burger3,
            R.drawable.burger4, R.drawable.italianfood1, R.drawable.italianfood2,
            R.drawable.italianfood3, R.drawable.italianfood4, R.drawable.mexicanfood1,
            R.drawable.mexicanfood2, R.drawable.mexicanfood3,R.drawable.mexicanfood4,
            R.drawable.seafood1, R.drawable.seafood2, R.drawable.seafood4};
    int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // get the first button;
        Button btnLike = (Button) findViewById(R.id.btnLike);
        btnLike.setText("Like");
        Button btnDislike = (Button) findViewById(R.id.btnDislike);
        btnDislike.setText("Not Really");
        Button btnDecide = (Button) findViewById(R.id.btnDecision);
        btnDecide.setText("THIS IS IT!");
        // do something when the button is clicked;
        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgview = (ImageView)findViewById(R.id.imageView);
                currentImage++;
                currentImage = currentImage % images.length;
                imgview.setImageResource(images[currentImage]);
            }
        });
        btnDislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgview = (ImageView)findViewById(R.id.imageView);
                currentImage++;
                currentImage = currentImage % images.length;
                imgview.setImageResource(images[currentImage]);
            }
        });
        btnDecide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgview = (ImageView)findViewById(R.id.imageView);
                currentImage++;
                currentImage = currentImage % images.length;
                imgview.setImageResource(images[currentImage]);
            }
        });
    }
}
