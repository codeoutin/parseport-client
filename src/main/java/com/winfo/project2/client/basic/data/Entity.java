package com.winfo.project2.client.basic.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin on 15.05.17.
 */
public class Entity {

    private String eid;
    private String datasource;
    private String backlink;
    private String classification;
    private long loadedAt;
    private String completeText;

    private List<Property> sourceProperties;
    private List<Property> syntheticProperties;

    public Entity()
    {
        this.sourceProperties = new ArrayList<>();
        this.syntheticProperties = new ArrayList<>();
    }

    public Entity(String eid, String datasource, String backlink, String classification, long loadedAt, String completeText)
    {
        this.eid = eid;
        this.datasource = datasource;
        this.backlink = backlink;
        this.classification = classification;
        this.loadedAt = loadedAt;
        this.completeText = completeText;

        this.sourceProperties = new ArrayList<>();
        this.syntheticProperties = new ArrayList<>();
    }

    public Entity(String eid, String datasource, String backlink, String classification, long loadedAt, String completeText, List<Property> sourceProperties, List<Property> syntheticProperties)
    {
        this.eid = eid;
        this.datasource = datasource;
        this.backlink = backlink;
        this.classification = classification;
        this.loadedAt = loadedAt;
        this.completeText = completeText;

        this.sourceProperties = sourceProperties;
        this.syntheticProperties = syntheticProperties;
    }

    public String getEid() {
        return eid;
    }

    public String getDatasource() {
        return datasource;
    }

    public String getBacklink() {
        return backlink;
    }

    public String getClassification() {
        return classification;
    }

    public long getLoadedAt() {
        return loadedAt;
    }

    public String getCompleteText() {
        return completeText;
    }

    public void setDatasource(String datasource) {
        this.datasource = datasource;
    }

    public void setBacklink(String backlink) {
        this.backlink = backlink;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public void setCompleteText(String completeText) {
        this.completeText = completeText;
    }


}