package com.rpg.combat.infraestructure.output.screen;

import com.rpg.combat.domain.models.Game;
import com.rpg.combat.domain.models.OptionScreen;
import com.rpg.combat.domain.models.PlayerCharacter;
import com.rpg.combat.domain.models.TemplateTag;
import com.rpg.combat.infraestructure.output.ConsoleUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewProfileScreen implements Screen {

    private final String RETURN_TO_MENU_OPTION = "return to menu";

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
                "╚═╝░░╚══╝╚══════╝░░░╚═╝░░░╚═╝░░ ░╚═════╝░╚═╝░░╚═╝╚═╝░░░░░╚═╝╚══════╝",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                ""

        };
        return template;
    }

    public String[] getPlayerListTemplade() {
        String[] template = {

                "",
                "",
                "",
                "--------------------------------------------------",
                " list of players characters",
                "--------------------------------------------------",
                "<listaDePersonajes>",
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

    public void showPlayerList(){

        TemplateTag tag = getPlayerListTag();
        String[] processedTemplate = replaceTemplateTags(new ArrayList<>(Arrays.asList(tag)), getPlayerListTemplade());
        consoleUI.showTemplate(processedTemplate);

    }

    @Override
    public OptionScreen getOptions() {
        String title = "selecione un personaje";
        List<String> options = getOptionValuesToDisplay();

        OptionScreen optionScreen = new OptionScreen(title, options);

        return optionScreen;
    }

    public OptionScreen getBeginBattleOption(){
        String title = "selecione si desea continuar a la batalla o salir al menu";
        List<String> options = new ArrayList<>();
        options.add("Empezar Batalla");
        options.add("Regresar al menu");
        OptionScreen optionScreen = new OptionScreen(title, options);
        return optionScreen;


    }

    private List<String> getOptionValuesToDisplay(){
        List<String> valuesToDisplay = new ArrayList<>();
        for (PlayerCharacter playerCharacter: playerCharacters) {
            valuesToDisplay.add(playerCharacter.getName());
        }
        valuesToDisplay.add(RETURN_TO_MENU_OPTION);
        return valuesToDisplay;
    }

    private TemplateTag getPlayerListTag() {

        String nombreDelTag = "<listaDePersonajes>";
        List<String> templateAReemplazar = new ArrayList<>();

        for (int i = 0; i < this.playerCharacters.size(); i++) {
            templateAReemplazar.add((i + 1) + ". " + this.playerCharacters.get(i).getName() + "\n");
            templateAReemplazar.add("--- --- --- --- --- --- --- --- --- --- --- --- ---" + "\n");
            templateAReemplazar.add(" Damage: " + this.playerCharacters.get(i).getDamage() + "\n");
            templateAReemplazar.add(" Role: " + this.playerCharacters.get(i).getRole() + "\n");
            templateAReemplazar.add(" HP: " + this.playerCharacters.get(i).getHpMax() + "\n");
            templateAReemplazar.add(" MANA: " + this.playerCharacters.get(i).getMpMax() + "\n");
            templateAReemplazar.add("--- --- --- --- --- --- --- --- --- --- --- --- ---" + "\n");
            templateAReemplazar.add("" + "\n");
        }
        return new TemplateTag(nombreDelTag, templateAReemplazar.toArray(new String[0]));
    }

    public void LoadPlayerCharacters(List<PlayerCharacter> playerCharacters) {
        this.playerCharacters = playerCharacters;

    }

}