package com.winfo.project2.client.basic.data;

import java.util.List;

/**
 * Created by Kevin on 15.05.17.
 */

public class Property {

    private String name;
    private String type;
    private List<String> values;

    public Property(String name, String type, List<String> values) {
        this.name = name;
        this.type = type;
        this.values = values;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public List<String> getValues() {
        return values;
    }

    @Override
    public String toString() {
        return "Property{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", values=" + values +
                '}';
    }
}
