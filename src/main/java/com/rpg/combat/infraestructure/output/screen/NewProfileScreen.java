package com.rpg.combat.infraestructure.output.screen;

import com.rpg.combat.domain.models.OptionScreen;
import com.rpg.combat.domain.models.PlayerCharacter;
import com.rpg.combat.infraestructure.output.ConsoleUI;

import java.util.List;

public class NewProfileScreen implements Screen {
    private final ConsoleUI consoleUI;
    private List<PlayerCharacter> playerCharacters;

    public NewProfileScreen(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String[] getTemplate() {
        String[] template = {
                "███╗░░██╗███████╗░██╗░░░░░░░██╗ ░██████╗░░█████╗░███╗░░░███╗███████╗",
                "████╗░██║██╔════╝░██║░░██╗░░██  ██╔════╝░██╔══██╗████╗░████║██╔════╝",
                "██╔██╗██║█████╗░░░╚██╗████╗██╔╝ ██║░░██╗░███████║██╔████╔██║█████╗░░",
                "██║╚████║██╔══╝░░░░████╔═████║░ ██║░░╚██╗██╔══██║██║╚██╔╝██║██╔══╝░░",
                "██║░╚███║███████╗░░╚██╔╝░╚██╔╝░ ╚██████╔╝██║░░██║██║░╚═╝░██║███████╗",
                "╚═╝░░╚══╝╚══════╝░░░╚═╝░░░╚═╝░░ ░╚═════╝░╚═╝░░╚═╝╚═╝░░░░░╚═╝╚══════╝"
        };
        return template;
    }

    @Override
    public void show() {

    }

    @Override
    public OptionScreen getOptions() {
        return null;
    }

    public void LoadPlayerCharacters(List<PlayerCharacter> playerCharacters) {
        this.playerCharacters = playerCharacters;

    }

}