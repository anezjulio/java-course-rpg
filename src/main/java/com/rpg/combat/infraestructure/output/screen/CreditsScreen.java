package com.rpg.combat.infraestructure.output.screen;

import com.rpg.combat.domain.models.OptionScreen;
import com.rpg.combat.infraestructure.input.ConsoleInput;
import com.rpg.combat.infraestructure.output.ConsoleUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreditsScreen implements Screen {


    private final ConsoleUI consoleUI;

    public CreditsScreen(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String[] getTemplate() {
        String[] template = {
                "                          ░█████╗░██████╗░███████╗░█████╗░████████╗███████╗██████╗░  ██████╗░██╗░░░██╗",
                "                          ██╔══██╗██╔══██╗██╔════╝██╔══██╗╚══██╔══╝██╔════╝██╔══██╗  ██╔══██╗╚██╗░██╔╝",
                "                          ██║░░╚═╝██████╔╝█████╗░░███████║░░░██║░░░█████╗░░██║░░██║  ██████╦╝░╚████╔╝░",
                "                          ██║░░██╗██╔══██╗██╔══╝░░██╔══██║░░░██║░░░██╔══╝░░██║░░██║  ██╔══██╗░░╚██╔╝░░",
                "                          ╚█████╔╝██║░░██║███████╗██║░░██║░░░██║░░░███████╗██████╔╝  ██████╦╝░░░██║░░░",
                "                          ░╚════╝░╚═╝░░╚═╝╚══════╝╚═╝░░╚═╝░░░╚═╝░░░╚══════╝╚═════╝░  ╚═════╝░░░░╚═╝░░░",
                "",
                "  ****𝕁𝕦𝕝𝕚𝕠 ❞𝔻𝕦𝕝𝕔𝕖𝔻𝕖𝔾𝕦𝕒𝕪𝕒𝕓𝕒❞ 𝔸𝕟̃𝕖𝕤****",
                "  ****𝕄𝕚𝕘𝕦𝕖𝕝𝕒𝕟𝕘𝕖𝕝 ❞𝔹𝕝𝕒𝕔𝕜𝕕𝕣𝕖𝕒𝕕❞ ℝ𝕖𝕪𝕖𝕤****",
                "  ****𝕃𝕦𝕚𝕤 𝕘𝕦𝕚𝕝𝕝𝕖𝕣𝕞𝕠 ❞𝕎𝕠𝕝𝕗𝕥𝕔𝕣𝕔𝕠𝕗𝕥❞ 𝕗𝕦𝕖𝕟𝕞𝕒𝕪𝕠𝕣****",
                "",
                ""
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
        List<String> options = new ArrayList<>(Arrays.asList("Return To Menu", "Exit"));

        OptionScreen optionScreen = new OptionScreen(title, options);

        return optionScreen;
    }



}
