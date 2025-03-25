package com.rpg.combat.domain.models;

import java.util.List;

public class OptionScreen {

    private String title;
    private List<String> options;

    public OptionScreen(String title, List<String> options) {
        this.title = title;
        this.options = options;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getOptions() {
        return options;
    }
}
