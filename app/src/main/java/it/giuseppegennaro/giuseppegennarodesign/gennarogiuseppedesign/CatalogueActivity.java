package it.giuseppegennaro.giuseppegennarodesign.gennarogiuseppedesign;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class CatalogueActivity extends Activity{

    private Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_catalogue);

    }
}
