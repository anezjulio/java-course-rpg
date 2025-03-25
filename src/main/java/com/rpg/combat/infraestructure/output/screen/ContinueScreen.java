package com.rpg.combat.infraestructure.output.screen;

import com.rpg.combat.domain.models.Game;
import com.rpg.combat.domain.models.OptionScreen;
import com.rpg.combat.domain.models.TemplateTag;
import com.rpg.combat.infraestructure.output.ConsoleUI;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContinueScreen implements Screen {

    private final String RETURN_TO_MENU_OPTION = "return to menu";

    private final ConsoleUI consoleUI;

    public ContinueScreen(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    private List<Game> saveGames;

    @Override
    public String[] getTemplate() {
        String[] template = {
                "--------------------------------------------------",
                "                   Load Game",
                "--------------------------------------------------",
                "",
                "<listaDePartidas>",
                "",

        };
        return template;
    }

    @Override
    public void show() {
        // cargo el / los tags
        TemplateTag tag = getGamesListTag();
        // Obtener array de string del texto a reemplazar
        String[] processedTemplate = replaceTemplateTags(new ArrayList<>(Arrays.asList(tag)));
        // imprimirlo linea por linea con consoleUI
        consoleUI.showTemplate(processedTemplate);
    }

    @Override
    public OptionScreen getOptions() {

        String title = "Options";
        List<String> options = getOptionValuesToDisplay();

        OptionScreen optionScreen = new OptionScreen(title, options);

        return optionScreen;
    }

    private List<String> getOptionValuesToDisplay(){
        List<String> valuesToDisplay = new ArrayList<>();
        for (Game game: saveGames) {
            valuesToDisplay.add(game.getName());
        }
        valuesToDisplay.add(RETURN_TO_MENU_OPTION);
        return valuesToDisplay;
    }

    public void loadSaveGames(List<Game> saveGames) {
        this.saveGames = saveGames;
    }

    private TemplateTag getGamesListTag() {

        String nombreDelTag = "<listaDePartidas>";
        List<String> templateAReemplazar = new ArrayList<>();

        // TODO: pasar este formmater a una clase utils dentro de un package common a nivel de infraestructure
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a");

        // for( 'setear Variable' ; ' Condicional' ; 'ejecucionAlTerminarLoop' ){
        //  // x veces  o hasta cumplir una condicion
        // }
        for (int i = 0; i < this.saveGames.size(); i++) {
            templateAReemplazar.add((i + 1) + ". " + this.saveGames.get(i).getName() + "\n");
            templateAReemplazar.add("--- --- --- --- --- --- --- --- --- --- --- --- ---" + "\n");
            templateAReemplazar.add("Fecha: " + this.saveGames.get(i).getStartDateTime().format(formatter) + "\n");
            templateAReemplazar.add("Chapter: " + this.saveGames.get(i).getChapter().name() + "\n");
            templateAReemplazar.add("PlayerCharacter: " + this.saveGames.get(i).getPlayerCharacter().getName() + "\n");
            templateAReemplazar.add("Role: " + this.saveGames.get(i).getPlayerCharacter().getRole() + "\n");
            templateAReemplazar.add("--- --- --- --- --- --- --- --- --- --- --- --- ---" + "\n");
            templateAReemplazar.add("" + "\n");
        }
        return new TemplateTag(nombreDelTag, templateAReemplazar.toArray(new String[0]));
    }

}
