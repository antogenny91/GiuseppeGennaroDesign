package it.giuseppegennaro.giuseppegennarodesign.giuseppegennarodesign;

import java.util.jar.Attributes;

/**
 * Created by antog on 18/11/2017.
 */

public class CatalogueCategory {
    private int id;
    private String name;

    public CatalogueCategory(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
