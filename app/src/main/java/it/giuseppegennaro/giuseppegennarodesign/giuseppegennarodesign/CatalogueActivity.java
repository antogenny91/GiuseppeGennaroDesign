package it.giuseppegennaro.giuseppegennarodesign.giuseppegennarodesign;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CatalogueActivity extends Activity{

    private Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_catalogue);

        //Test read database
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("categories");
        final List <CatalogueCategory> category_list = new ArrayList<>();
        final ListView categoryListView = findViewById(R.id.catalogue_list);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                Log.v("USAGE","Inside onDataChange method" );
                for (DataSnapshot noteSnapshot: snapshot.getChildren()){
                    Log.v("CATEGORY","Get children " + noteSnapshot.toString() );
                    CatalogueCategory category = noteSnapshot.getValue(CatalogueCategory.class);
                    Log.v("CATEGORY","Create CatalogueCategory object name: " + category.getName() );
                    category_list.add(category);
                }
                Log.v("LIST","Number of items in category_list " + category_list.size() );

                //Create categoryAdapter and populate categotyListView
                CategoryAdapter categoryAdapter = new CategoryAdapter(context, R.layout.category_item, category_list);
                categoryListView.setAdapter(categoryAdapter);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

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
