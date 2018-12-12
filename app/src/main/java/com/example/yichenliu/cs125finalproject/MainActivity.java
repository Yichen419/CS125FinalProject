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

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {
    private static ImageView imgview;
    private int currentImage = -1;
    private int asianFoodCount = 0;
    private int bbqCount = 0;
    private int burgerCount = 0;
    private int italianCount = 0;
    private int mexicanCount = 0;
    private int seafoodCount = 0;
    private int veggieCount = 0;
    private Button btnLike;
    private Button btnDislike;
    private Button btnDecide;
    private Button btnGo;


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
    protected void initLike() {
        btnLike = (Button) findViewById(R.id.btnLike);
        btnLike.setText("Like");
    }
    protected void initDislike() {
        btnDislike = (Button) findViewById(R.id.btnDislike);
        btnDislike.setText("Not Really");
    }
    protected void initDecision() {
        btnDecide = (Button) findViewById(R.id.btnDecision);
        btnDecide.setText("THIS IS IT!");
    }
    protected void initGo() {
        btnGo = (Button) findViewById(R.id.btnGo);
        btnGo.setText("FEED ME!");
    }
    protected void clickGo() {
        Toasty.success(MainActivity.this, "Let's Grab Some Food!", Toast.LENGTH_SHORT, true).show();
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
    protected void clickDislike() {
        imgview = (ImageView)findViewById(R.id.imageView);
        if (currentImage % 7 == 0) {
            asianFoodCount++;
        } else if (currentImage % 7 == 1) {
            bbqCount--;
        } else if (currentImage % 7 == 2) {
            burgerCount--;
        } else if (currentImage % 7 == 3) {
            italianCount--;
        } else if (currentImage % 7 == 4) {
            mexicanCount--;
        } else if (currentImage % 7 == 5) {
            seafoodCount--;
        } else if (currentImage % 7 == 6) {
            veggieCount--;
        }
        currentImage++;
        currentImage = currentImage % images.length;
        imgview.setImageResource(images[currentImage]);
        counter++; //
    }
    protected void clickLike() {
        int start = images.length / 3;
        int end = (2 * images.length) / 3;
        if (counter == start) {
            Toasty.info(MainActivity.this, "Great! We have more options for you", Toast.LENGTH_SHORT, true).show();
        }
        if (counter == end) {
            Toasty.info(MainActivity.this, "Almost there! Just few more!", Toast.LENGTH_SHORT, true).show();
        }
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
    }
    protected int computeMax() {
        int[] results = new int[] {asianFoodCount, bbqCount, burgerCount, italianCount, mexicanCount, seafoodCount, veggieCount};
        Max input = new Max(results);
        return input.max();
    }
    protected void decisionMaking(int max) {
        if (max == burgerCount) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com/search?q=burger+near+me"));
            startActivity(browserIntent);
        } else if (max == asianFoodCount) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com/search?q=asian+food+near+me"));
            startActivity(browserIntent);
        } else if (max == italianCount) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com/search?q=italian+food+near+me"));
            startActivity(browserIntent);
        } else if (max == mexicanCount) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com/search?q=mexican+food+near+me"));
            startActivity(browserIntent);
        } else if (max == seafoodCount) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com/search?q=seafood+near+me"));
            startActivity(browserIntent);
        } else if (max == veggieCount) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com/search?q=veggie+restaurant+near+me"));
            startActivity(browserIntent);
        } else {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com/search?q=food+near+me"));
            startActivity(browserIntent);
        }
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLike();
        initDislike();
        initDecision();
        initGo();
        // do something when the button is clicked;
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickGo();
            }
        });
        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter < images.length) {
                    clickLike();
                } else {
                    int max = computeMax();
                    decisionMaking(max);
                }
            }
        });
        btnDislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter < images.length) {
                    clickDislike();
                } else {
                    int max = computeMax();
                    decisionMaking(max);
                }
            }
        });
        btnDecide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toasty.success(MainActivity.this, "Getting you to the food RIGHT NOW!", Toast.LENGTH_LONG, true).show();
                if (currentImage % 7 == 0) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com/search?q=asian+food+near+me"));
                    startActivity(browserIntent);
                } else if (currentImage % 7 == 1) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com/search?q=bbq+near+me"));
                    startActivity(browserIntent);
                } else if (currentImage % 7 == 2) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com/search?q=burger+near+me"));
                    startActivity(browserIntent);
                } else if (currentImage % 7 == 3) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com/search?q=italian+food+near+me"));
                    startActivity(browserIntent);
                } else if (currentImage % 7 == 4) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com/search?q=mexican+food+near+me"));
                    startActivity(browserIntent);
                } else if (currentImage % 7 == 5) {
                    seafoodCount++;Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com/search?q=seafood+near+me"));
                    startActivity(browserIntent);
                } else if (currentImage % 7 == 6) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com/search?q=veggie+restaurant+near+me"));
                    startActivity(browserIntent);
                }
            }
        });
    }
}
