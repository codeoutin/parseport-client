package com.winfo.project2.client.basic.data;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
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
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        this.loadedAt = timestamp.getTime();
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

    public void addSourceProperty(Property property){
        this.sourceProperties.add(property);
    }

    public void addSyntheticProperty(Property property){
        this.syntheticProperties.add(property);
    }

    public List<Property> getProperties(){
        List<Property> combined = new ArrayList<>();
        combined.addAll(this.sourceProperties);
        combined.addAll(this.syntheticProperties);
        return combined;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "eid='" + eid + '\'' +
                ", datasource='" + datasource + '\'' +
                ", backlink='" + backlink + '\'' +
                ", classification='" + classification + '\'' +
                ", loadedAt=" + loadedAt +
                ", completeText='" + completeText + '\'' +
                ", sourceProperties=" + sourceProperties +
                ", syntheticProperties=" + syntheticProperties +
                '}';
    }
}