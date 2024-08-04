package edu.learn.pizzatown;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class OrderActivity extends AppCompatActivity {

    TextView cheeseText, mushroomsText, tomatoText, oliveText, basilText, pineappleText;

    Button backBtn, orderBtn;
    Intent intent;

    String[] quantity = {"one", "two", "three", "four", "five"};
    Spinner typeSpinner, qtySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_order);
        cheeseText = findViewById(R.id.textCheese);
        mushroomsText = findViewById(R.id.textMushroom);
        tomatoText = findViewById(R.id.textTomato);
        oliveText = findViewById(R.id.textOlive);
        basilText = findViewById(R.id.textBasil);
        pineappleText = findViewById(R.id.textPineapple);
        backBtn = findViewById(R.id.btnBack);
        orderBtn = findViewById(R.id.btnConfirm);

        typeSpinner = findViewById(R.id.pizzaSize);
        qtySpinner = findViewById(R.id.pizzaQty);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, quantity);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        qtySpinner.setAdapter(adapter);

        registerForContextMenu(orderBtn);


        typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String type = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(OrderActivity.this, type, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        qtySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String type = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(OrderActivity.this, type, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        renderIngrident();

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // code here for popup menu.
                showConfirmPopup(v);
            }
        });


    }

    void renderIngrident() {
        intent = getIntent();
        boolean isCheese = intent.getBooleanExtra("cheese", false);
        if (isCheese) {
            cheeseText.setVisibility(View.VISIBLE);
        }

        boolean isMushrooms = intent.getBooleanExtra("mushroom", false);

        if (isMushrooms) {
            mushroomsText.setVisibility(View.VISIBLE);
        }

        boolean isTomato = intent.getBooleanExtra("tomato", false);

        if (isTomato) {
            tomatoText.setVisibility(View.VISIBLE);
        }

        boolean isOlive = intent.getBooleanExtra("olive", false);

        if (isOlive) {
            oliveText.setVisibility(View.VISIBLE);
        }

        boolean isBasil = intent.getBooleanExtra("basil", false);

        if (isBasil) {
            basilText.setVisibility(View.VISIBLE);
        }

        boolean isPineapple = intent.getBooleanExtra("pineapple", false);

        if (isPineapple) {
            pineappleText.setVisibility(View.VISIBLE);
        }


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.confirm_context_menu, menu);
    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.single:
                typeSpinner.setSelection(1);
                qtySpinner.setSelection(1);
                return true;
            case R.id.homeParty:
                typeSpinner.setSelection(2);
                qtySpinner.setSelection(3);
                return true;
            case R.id.officeLunch:
                typeSpinner.setSelection(3);
                qtySpinner.setSelection(4);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    public void showConfirmPopup(View view){
        PopupMenu popUpMenu = new PopupMenu(OrderActivity.this, view);
        popUpMenu.inflate(R.menu.confirm_popup_menu);

        popUpMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.dineIn:
                        Toast.makeText(OrderActivity.this, "Your order has been successfully placed fod dine in", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.takeAway:
                        Toast.makeText(OrderActivity.this, "Your order has been successfully placed fod take in", Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return false;
                }
            }
        });
        popUpMenu.show();
    }
}