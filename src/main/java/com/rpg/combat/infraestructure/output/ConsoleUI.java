package com.rpg.combat.infraestructure.output;

import com.rpg.combat.domain.models.OptionScreen;

import java.util.Arrays;
import java.util.List;

//  Maneja la impresion del texto a mostrar
public class ConsoleUI {

    private final String SELECT_OPTION = "Seleccione una opción: ";
    private final String SELECT_OPTION_TAG = "<titleTag>";
    private final String SELECT_OPTION_TITLE = "=== " + SELECT_OPTION_TAG + " ===";

    public void showOptions(OptionScreen optionScreen) {
        showOptions(optionScreen.getTitle(), optionScreen.getOptions());
    }

    public void showOptions(String title, List<String> options) {
        showTitle(title);
        showOptions(options);
    }

    public void showOptions(List<String> options) {
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
        System.out.print(SELECT_OPTION);
    }

    private void showTitle(String title){
        System.out.println(
                SELECT_OPTION_TITLE.replace(SELECT_OPTION_TAG, title)
        );
    }

    public void showTemplate(List<String> template) {
        for (String line: template ) {
            System.out.println(line);
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void cls() {
        for(int i=0; i < 30; i++){
            System.out.println(" ");
        }
    }


    //TODO: quitar cuando se reemplacen todos los templates con String[] por List<String>
    public void showOptions(String[] options) {
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.print(SELECT_OPTION);
    }

    //TODO: quitar cuando se reemplacen todos los templates con String[] por List<String>
    public void showTemplate(String[] template) {
        showTemplate(Arrays.asList(template));
    }

}
