package com.winfo.project2.client;

import java.util.HashMap;
import java.util.Map;

public class Entity {

    private String eid;
    private String datasource;
    private String backlink;
    private String classification;
    private Integer loadedAt;
    private String completeText;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Entity () {}

    public Entity (String datasource, String backlink, String classification, Integer loadedAt, String completeText) {
        this.datasource = datasource;
        this.backlink = backlink;
        this.classification = classification;
        this.loadedAt = loadedAt;
        this.completeText = completeText;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getDatasource() {
        return datasource;
    }

    public void setDatasource(String datasource) {
        this.datasource = datasource;
    }

    public String getBacklink() {
        return backlink;
    }

    public void setBacklink(String backlink) {
        this.backlink = backlink;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public Integer getLoadedAt() {
        return loadedAt;
    }

    public void setLoadedAt(Integer loadedAt) {
        this.loadedAt = loadedAt;
    }

    public String getCompleteText() {
        return completeText;
    }

    public void setCompleteText(String completeText) {
        this.completeText = completeText;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}