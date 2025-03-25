package com.rpg.combat.infraestructure.output.screen;

import com.rpg.combat.domain.models.OptionScreen;
import com.rpg.combat.infraestructure.output.ConsoleUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuScreen implements Screen {

    private final ConsoleUI consoleUI;

    public MenuScreen(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String[] getTemplate() {
        String[] template = {
                "██████╗░██╗░░░██╗███╗░░██╗░██████╗░███████╗░█████╗░███╗░░██╗  ███╗░░░███╗░█████╗░████████╗░█████╗░██╗░░██╗",
                "██╔══██╗██║░░░██║████╗░██║██╔════╝░██╔════╝██╔══██╗████╗░██║  ████╗░████║██╔══██╗╚══██╔══╝██╔══██╗██║░░██║",
                "██║░░██║██║░░░██║██╔██╗██║██║░░██╗░█████╗░░██║░░██║██╔██╗██║  ██╔████╔██║███████║░░░██║░░░██║░░╚═╝███████║",
                "██║░░██║██║░░░██║██║╚████║██║░░╚██╗██╔══╝░░██║░░██║██║╚████║  ██║╚██╔╝██║██╔══██║░░░██║░░░██║░░██╗██╔══██║",
                "██████╔╝╚██████╔╝██║░╚███║╚██████╔╝███████╗╚█████╔╝██║░╚███║  ██║░╚═╝░██║██║░░██║░░░██║░░░╚█████╔╝██║░░██║",
                "╚═════╝░░╚═════╝░╚═╝░░╚══╝░╚═════╝░╚══════╝░╚════╝░╚═╝░░╚══╝  ╚═╝░░░░░╚═╝╚═╝░░╚═╝░░░╚═╝░░░░╚════╝░╚═╝░░╚═╝",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                /*  "▄█ ░ █▄░█ █▀▀ █░█░█   █▀█ █▀█ █▀█ █▀▀ █ █░░ █▀▀",
                  "░█ ▄ █░▀█ ██▄ ▀▄▀▄▀   █▀▀ █▀▄ █▄█ █▀░ █ █▄▄ ██▄",
                  "▀█ ░ █░░ █▀█ ▄▀█ █▀▄   █▀█ █▀█ █▀█ █▀▀ █ █░░ █▀▀",
                  "█▄ ▄ █▄▄ █▄█ █▀█ █▄▀   █▀▀ █▀▄ █▄█ █▀░ █ █▄▄ ██▄",
                  "█▀█ ░ █▀▀ █▀█ █▀▀ █▀▄ █ █▀ ▀█▀",
                  "█▄█ ▄ █▄▄ █▀▄ ██▄ █▄▀ █ ▄█ ░█░",
                  "",*/
        };
        return template;
    }

    @Override
    public void show() {
        consoleUI.cls();
        consoleUI.showTemplate(getTemplate());
    }

    @Override
    public OptionScreen getOptions() {

        String title = "Options";
        List<String> options = new ArrayList<>(Arrays.asList("New Game", "Continue", "Credits", "Exit"));

        OptionScreen optionScreen = new OptionScreen(title, options);

        return optionScreen;
    }

}
