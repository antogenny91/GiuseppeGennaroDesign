package it.giuseppegennaro.giuseppegennarodesign.giuseppegennarodesign;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by antog on 18/11/2017.
 */

public class CategoryAdapter extends ArrayAdapter<CatalogueCategory> {

    public CategoryAdapter(Context context, int textViewResourceId, List<CatalogueCategory> objects) {
        super(context, textViewResourceId, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.category_item, null);
        TextView name = (TextView)convertView.findViewById(R.id.categoryItemName);
        CatalogueCategory c = getItem(position);
        name.setText(c.getName());
        return convertView;
    }

}
