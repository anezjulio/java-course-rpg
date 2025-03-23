package com.rpg.combat.domain.models;

public class TemplateTag {

    private String key;
    private String[] templateValue;

    public TemplateTag(String key, String[] templateValue) {
        this.key = key;
        this.templateValue = templateValue;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String[] getTemplateValue() {
        return templateValue;
    }

    public void setTemplateValue(String[] templateValue) {
        this.templateValue = templateValue;
    }
}
