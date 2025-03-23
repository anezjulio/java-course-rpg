package com.rpg.combat.domain.models;

public class Option {

    private int key;
    private String Value;

    public Option(int key, String value) {
        this.key = key;
        Value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return this.key + ". " + this.Value;
    }
}
