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
import android.content.Intent;
import android.net.Uri;


public class MainActivity extends AppCompatActivity {
    private static ImageView imgview;
    private int currentImage = -1;
    private int asianFoodCount;
    private int bbqCount;
    private int burgerCount;
    private int italianCount;
    private int mexicanCount;
    private int seafoodCount;
    private int veggieCount;

    int[] images = {
            R.drawable.asianfood1, R.drawable.bbq1, R.drawable.burger1,
            R.drawable.italianfood1, R.drawable.mexicanfood1, R.drawable.seafood1, R.drawable.veggie1,
            R.drawable.asianfood2, R.drawable.bbq2, R.drawable.burger2,
            R.drawable.italianfood2, R.drawable.mexicanfood2, R.drawable.seafood2, R.drawable.veggie2,
            R.drawable.asianfood3, R.drawable.bbq3, R.drawable.burger3,
            R.drawable.italianfood3, R.drawable.mexicanfood3, R.drawable.seafood3, R.drawable.veggie3,
            R.drawable.asianfood4, R.drawable.bbq4, R.drawable.burger4,
            R.drawable.italianfood4, R.drawable.mexicanfood4, R.drawable.seafood4, R.drawable.veggie4,

    };
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
        Button btnGo = (Button) findViewById(R.id.btnGo);
        btnGo.setText("FEED ME!");
        // do something when the button is clicked;
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgview = (ImageView)findViewById(R.id.imageView);
                currentImage++;
                currentImage = currentImage % images.length;
                imgview.setImageResource(images[currentImage]);
                View a = findViewById(R.id.btnGo);
                a.setVisibility(View.GONE);
                View b = findViewById(R.id.btnLike);
                b.setVisibility(View.VISIBLE);
                View c = findViewById(R.id.btnDislike);
                c.setVisibility(View.VISIBLE);
                View d = findViewById(R.id.btnDecision);
                d.setVisibility(View.VISIBLE);

            }
        });
        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter < images.length) {
                    imgview = (ImageView)findViewById(R.id.imageView);
                    if (currentImage % 7 == 0) {
                        asianFoodCount++;
                    } else if (currentImage % 7 == 1) {
                        bbqCount++;
                    } else if (currentImage % 7 == 2) {
                        burgerCount++;
                    } else if (currentImage % 7 == 3) {
                        italianCount++;
                    } else if (currentImage % 7 == 4) {
                        mexicanCount++;
                    } else if (currentImage % 7 == 5) {
                        seafoodCount++;
                    } else if (currentImage % 7 == 6) {
                        veggieCount++;
                    }
                    currentImage++;
                    currentImage = currentImage % images.length;
                    imgview.setImageResource(images[currentImage]);
                    counter++;
                } else {
                    if (asianFoodCount == bbqCount
                            && asianFoodCount == burgerCount
                            && asianFoodCount == italianCount
                            && asianFoodCount == mexicanCount
                            && asianFoodCount ==seafoodCount
                            && asianFoodCount == veggieCount) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com/search?q=food_near_me"));
                        startActivity(browserIntent);
                    }
                }
            }
        });
        btnDislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgview = (ImageView)findViewById(R.id.imageView);
                currentImage++;
                currentImage = currentImage % images.length;
                imgview.setImageResource(images[currentImage]);
                counter++;
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
