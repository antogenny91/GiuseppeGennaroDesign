package it.giuseppegennaro.giuseppegennarodesign.gennarogiuseppedesign;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
    private Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);
        LinearLayout catalogue_layer = (LinearLayout) findViewById (R.id.catalogue_ll);
        LinearLayout website_layer = (LinearLayout) findViewById (R.id.website_ll);
        LinearLayout fbpage_layer = (LinearLayout) findViewById (R.id.fbpage_ll);

        catalogue_layer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openCatalogue = getOpenCatalogueIntent(context);
                startActivity(openCatalogue);
            }
        });

        website_layer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openWebsite = getOpenWebsiteIntent(context);
                startActivity(openWebsite);
            }
        });

        fbpage_layer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openFbpage = getOpenFacebookIntent(context);
                startActivity(openFbpage);
            }
        });
    }

    public static Intent getOpenFacebookIntent(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/179715715437678"));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/GiuseppeGennaroDesign"));
        }
    }

    public static Intent getOpenWebsiteIntent(Context context) {
            return new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.giuseppegennaro.it"));
    }

    public Intent getOpenCatalogueIntent(Context context) {
        return new Intent(MainActivity.this, CatalogueActivity.class);
    }

}


