package com.rpg.combat.infraestructure.output.screen;

import com.rpg.combat.domain.models.OptionScreen;
import com.rpg.combat.infraestructure.output.ConsoleUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

    public class GameOverScreen implements Screen {


        private final ConsoleUI consoleUI;

        public GameOverScreen(ConsoleUI consoleUI) {
            this.consoleUI = consoleUI;
        }

        @Override
        public String[] getTemplate() {
            String[] template = {


                        "             ░██████╗░░█████╗░███╗░░░███╗███████╗  ░█████╗░██╗░░░██╗███████╗██████╗░",
                        "             ██╔════╝░██╔══██╗████╗░████║██╔════╝  ██╔══██╗██║░░░██║██╔════╝██╔══██╗",
                        "             ██║░░██╗░███████║██╔████╔██║█████╗░░  ██║░░██║╚██╗░██╔╝█████╗░░██████╔╝",
                        "             ██║░░╚██╗██╔══██║██║╚██╔╝██║██╔══╝░░  ██║░░██║░╚████╔╝░██╔══╝░░██╔══██╗",
                        "             ╚██████╔╝██║░░██║██║░╚═╝░██║███████╗  ╚█████╔╝░░╚██╔╝░░███████╗██║░░██║",
                        "             ░╚═════╝░╚═╝░░╚═╝╚═╝░░░░░╚═╝╚══════╝  ░╚════╝░░░░╚═╝░░░╚══════╝╚═╝░░╚═╝",

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


