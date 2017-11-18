package it.giuseppegennaro.giuseppegennarodesign.giuseppegennarodesign;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CategoryActivity extends Activity{

    private Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_category);

        //For test purpose
        TextView test = (TextView)findViewById(R.id.category_intent_test);
        String categoryNameSelected = getIntent().getExtras().getString("nameCategory");
        test.setText(categoryNameSelected);

        int categorySelected = getIntent().getExtras().getInt("idCategory");
    }

}
