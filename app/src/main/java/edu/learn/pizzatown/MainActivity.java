package edu.learn.pizzatown;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ImageView cheeseImg, mushroomImg, tomatoImg, oliveImg, basilImg, pineappleImg;

    CheckBox checkboxCheese, checkboxMushroom, checkboxTomato, checkboxOlive, checkboxBasil, checkboxPineapple;

    Button orderButton;
    boolean isCheeseChecked = false, isMushroomChecked = false, isTomatoChecked = false, isOliveChecked = false, isBasilChecked = false, isPineappleChecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        cheeseImg = findViewById(R.id.cheese);
        mushroomImg = findViewById(R.id.mushroom);
        tomatoImg = findViewById(R.id.tomato);
        oliveImg = findViewById(R.id.olive);
        basilImg = findViewById(R.id.basil);
        pineappleImg = findViewById(R.id.pineapple);

        checkboxCheese = findViewById(R.id.checkCheese);
        checkboxMushroom = findViewById(R.id.checkMushroom);
        checkboxTomato = findViewById(R.id.checkTomato);
        checkboxOlive = findViewById(R.id.checkOlive);
        checkboxBasil = findViewById(R.id.checkBasil);
        checkboxPineapple = findViewById(R.id.checkPineapple);
        orderButton = findViewById(R.id.proceed);


        checkboxCheese.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                isCheeseChecked = isChecked;

                if (isChecked) {
                    cheeseImg.setVisibility(View.VISIBLE);
                } else {
                    cheeseImg.setVisibility(View.GONE);
                }
            }
        });


        checkboxMushroom.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isMushroomChecked = isChecked;
                if (isChecked) {
                    mushroomImg.setVisibility(View.VISIBLE);
                } else {
                    mushroomImg.setVisibility(View.GONE);
                }
            }
        });

        checkboxTomato.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isTomatoChecked = isChecked;
                if (isChecked) {
                    tomatoImg.setVisibility(View.VISIBLE);
                } else {
                    tomatoImg.setVisibility(View.GONE);
                }
            }
        });


        checkboxOlive.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isOliveChecked = isChecked;
                if (isChecked) {
                    oliveImg.setVisibility(View.VISIBLE);
                } else {
                    oliveImg.setVisibility(View.GONE);
                }
            }
        });


        checkboxBasil.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isBasilChecked = isChecked;
                if (isChecked) {
                    basilImg.setVisibility(View.VISIBLE);
                } else {
                    basilImg.setVisibility(View.GONE);
                }
            }
        });

        checkboxPineapple.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isPineappleChecked = isChecked;
                if (isChecked) {
                    pineappleImg.setVisibility(View.VISIBLE);
                } else {
                    pineappleImg.setVisibility(View.GONE);
                }
            }
        });


        orderButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                intent.putExtra("cheese", isCheeseChecked);
                intent.putExtra("mushroom", isMushroomChecked);
                intent.putExtra("tomato", isTomatoChecked);
                intent.putExtra("olive", isOliveChecked);
                intent.putExtra("basil", isBasilChecked);
                intent.putExtra("pineapple", isPineappleChecked);

                startActivity(intent);

            }
        });
        //finish oncreate
    }

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (menu instanceof MenuBuilder) {
            MenuBuilder menuBuilder = (MenuBuilder) menu;
            menuBuilder.setOptionalIconsVisible(true);
        }

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.margarita:
                checkboxCheese.setChecked(true);
                checkboxTomato.setChecked(true);
                checkboxBasil.setChecked(true);

                checkboxMushroom.setChecked(false);
                checkboxOlive.setChecked(false);
                checkboxPineapple.setChecked(false);

                return true;
            case R.id.mushroom:
                checkboxCheese.setChecked(true);
                checkboxTomato.setChecked(true);
                checkboxMushroom.setChecked(true);

                checkboxBasil.setChecked(false);
                checkboxOlive.setChecked(true);
                checkboxPineapple.setChecked(false);
                return true;
            case R.id.newYork:
                checkboxCheese.setChecked(true);
                checkboxTomato.setChecked(true);
                checkboxMushroom.setChecked(true);

                checkboxBasil.setChecked(true);
                checkboxOlive.setChecked(true);
                checkboxPineapple.setChecked(true);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}