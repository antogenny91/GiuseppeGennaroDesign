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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CatalogueActivity extends Activity{

    private Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_catalogue);
        ListView categoryListView = (ListView)findViewById(R.id.catalogue_list);

        //List of cataloguecategory
        List <CatalogueCategory> category_list = new LinkedList<CatalogueCategory>();

        //simulate activity getting data from db
        //table category - id, name
        //for(int i= 0; i<125; i++) {
        //    category_list.add(new CatalogueCategory(i,"Categoria numero " + i ));
        //}
        category_list.add(new CatalogueCategory(0,"Tendaggi"));
        category_list.add(new CatalogueCategory(1,"Divani e poltrone"));
        category_list.add(new CatalogueCategory(2,"Tappeti e moquoettes"));
        category_list.add(new CatalogueCategory(3,"Illuminazione" ));

        //View adapter by CategoryAdapter
        CategoryAdapter categoryAdapter = new CategoryAdapter(this, R.layout.category_item, category_list);
        categoryListView.setAdapter(categoryAdapter);

        categoryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adattatore, final View componente, int pos, long id){
                // recupero il titolo memorizzato nella riga tramite l'ArrayAdapter
                //Log.d("List", "Ho cliccato sull'elemento con titolo" + titoloriga);
                CatalogueCategory selected = (CatalogueCategory) adattatore.getItemAtPosition(pos);
                Intent openCategory = getOpenCategoryIntent(context, pos);
                //Use for testing purpose
                Intent openCategorySelected = getOpenCategoryIntent(context, pos, selected.getName());

                startActivity(openCategorySelected);
            }
        });
    }

    public Intent getOpenCategoryIntent(Context context, int idCategory) {
        Intent intent = new Intent(CatalogueActivity.this, CategoryActivity.class);
        intent.putExtra("idCategory", idCategory);
        return intent;
    }
    //Use for testing purpose
    public Intent getOpenCategoryIntent(Context context, int idCategory, String category) {
        Intent intent = new Intent(CatalogueActivity.this, CategoryActivity.class);
        intent.putExtra("idCategory", idCategory);
        intent.putExtra("nameCategory", category);
        return intent;
    }
}
