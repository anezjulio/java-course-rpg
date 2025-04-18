package com.rpg.combat.infraestructure.output.screen;

import com.rpg.combat.domain.models.*;
import com.rpg.combat.domain.services.BattleService;
import com.rpg.combat.infraestructure.output.ConsoleUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BattleScreen implements Screen {

    private final ConsoleUI consoleUI;
    private final BattleService battleService;

    public BattleScreen(
            ConsoleUI consoleUI,
            BattleService battleService
    ) {
        this.consoleUI = consoleUI;
        this.battleService = battleService;
    }

    @Override
    public String[] getTemplate() {
        String[] template = {
                "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
                "               Chapter: <currentChapter>            ",
                "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
                "Player name: <currentPlayerName>",
                "",
                "Character: <characterList>",
                "",
                "Enemies: ",
                "<enemyList>",
                "",
        };
        return template;
    }

    public String[] getSelectedOptionsTemplate() {
        String[] template = {
                "",
                "<playerTurn> : <actionSelected> -> <targetSelected>",
                "",
        };
        return template;
    }

    public void displaySelectedOption(int actionSelected, int targetSelected) {
        List<TemplateTag> tags = getSelectedOptionTagList(actionSelected, targetSelected);
        String[] processedTemplate = replaceTemplateTags(tags, getSelectedOptionsTemplate());
        consoleUI.showTemplate(processedTemplate);
    }

    private List<TemplateTag> getSelectedOptionTagList(int actionSelected, int targetSelected) {
        List<TemplateTag> tagList = new ArrayList<>();

        String playerTurnTag = "<playerTurn>";
        List<String> playerTurnTemplateToReplace = new ArrayList<>();
        playerTurnTemplateToReplace.add(
                battleService.getCurrentGame().getName()
        );
        tagList.add(new TemplateTag(playerTurnTag, playerTurnTemplateToReplace.toArray(new String[0])));

        String actionSelectedTag = "<actionSelected>";
        List<String> actionSelectedTemplateToReplace = new ArrayList<>();
        actionSelectedTemplateToReplace.add(
                getActionSelected(actionSelected)
        );
        tagList.add(new TemplateTag(actionSelectedTag, actionSelectedTemplateToReplace.toArray(new String[0])));

        String targetSelectedTag = "<targetSelected>";
        List<String> targetSelectedTemplateToReplace = new ArrayList<>();
        targetSelectedTemplateToReplace.add(
                getTargetSelected(targetSelected)
        );
        tagList.add(new TemplateTag(targetSelectedTag, targetSelectedTemplateToReplace.toArray(new String[0])));

        return tagList;
    }


    private String getActionSelected(int actionSelected) {
        List<Item> itemList = battleService.getCurrentGame().getPlayerCharacter().getItems();
        List<Skill> skillsList = battleService.getCurrentGame().getPlayerCharacter().getSkills();
        List<String> actionsNameList = new ArrayList<>();
        for (int i = 0; i < itemList.size(); i++) {
            actionsNameList.add(itemList.get(i).getName());
        }
        for (int i = 0; i < skillsList.size(); i++) {
            actionsNameList.add(skillsList.get(i).getName());
        }
        return actionSelected + "." + actionsNameList.get(actionSelected - 1);
    }

    private String getTargetSelected(int targetSelected) {
        List<Enemy> enemyList = battleService.getCurrentGame().getEnemyList();
        return targetSelected + "." + enemyList.get(targetSelected - 1).getName();
    }

    private List<TemplateTag> getTagList() {
        List<TemplateTag> tagList = new ArrayList<>();
        tagList.add(getCurrentPlayerNameTag());
        tagList.add(getCurrentChapterTag());
        tagList.add(getCharacterListTag());
        tagList.add(getEnemyListTag());
        return tagList;
    }

    private TemplateTag getCurrentPlayerNameTag() {
        String tagName = "<currentPlayerName>";
        List<String> templateToReplace = new ArrayList<>();
        templateToReplace.add(
                battleService.getCurrentGame().getName()
        );
        return getTemplateTag(tagName, templateToReplace);
    }

    private TemplateTag getCurrentChapterTag() {
        String tagName = "<currentChapter>";
        List<String> templateToReplace = new ArrayList<>();
        templateToReplace.add(
                battleService.getCurrentGame().getChapter().name()
        );
        return getTemplateTag(tagName, templateToReplace);
    }

/*
    private TemplateTag getCurrentRoundTag() {
        String tagName = "<currentRound>";
        List<String> templateToReplace = new ArrayList<>();
        templateToReplace.add(
                // convierte el round int, en string añadiendo el "" vacio
                "" + battleService.getCurrentGame().getRound()
        );
        return getTemplateTag(tagName, templateToReplace);
    }

    private TemplateTag getCurrentTurnTag() {
        String tagName = "<currentTurn>";
        List<String> templateToReplace = new ArrayList<>();
        templateToReplace.add(
                "" + battleService.getCurrentGame().getTurn()
        );
        return getTemplateTag(tagName, templateToReplace);
    }*/

    private TemplateTag getEnemyListTag() {
        String tagName = "<enemyList>";
        List<String> templateToReplace = new ArrayList<>();
        List<Enemy> enemyList = battleService.getCurrentGame().getEnemyList();
        for (int i = 0; i < enemyList.size(); i++) {
            templateToReplace.add("--- --- --- --- --- --- --- --- --- --- --- --- ---" + "\n");
            templateToReplace.add((i + 1) + ". " + enemyList.get(i).getName() + "\n");
            templateToReplace.add("Level: " + enemyList.get(i).getLevel() + "\n");
            templateToReplace.add("Damage: " + enemyList.get(i).getDamage() + "\n");
            templateToReplace.add("HP: " + enemyList.get(i).getHpCurrent() + "/" + enemyList.get(i).getHpMax() + "\n");
            templateToReplace.add("MP: " + enemyList.get(i).getMpCurrent() + "/" + enemyList.get(i).getMpMax() + "\n");
            templateToReplace.add("--- --- --- --- --- --- --- --- --- --- --- --- ---" + "\n");

        }
        return getTemplateTag(tagName, templateToReplace);
    }

    private TemplateTag getCharacterListTag() {
        String tagName = "<characterList>";
        List<String> templateToReplace = new ArrayList<>();
        List<PlayerCharacter> playerCharacterList = new ArrayList<>();
        playerCharacterList.add(battleService.getCurrentGame().getPlayerCharacter());
        for (int i = 0; i < playerCharacterList.size(); i++) {
            templateToReplace.add(playerCharacterList.get(i).getName() + "\n");
            templateToReplace.add("Level: " + playerCharacterList.get(i).getLevel() + "\n");
            templateToReplace.add("HP: " + playerCharacterList.get(i).getHpCurrent() + "/" + playerCharacterList.get(i).getHpMax() + "\n");
            templateToReplace.add("MP: " + playerCharacterList.get(i).getMpCurrent() + "/" + playerCharacterList.get(i).getMpMax() + "\n");
            templateToReplace.add("Damage: " + playerCharacterList.get(i).getDamage() + "\n");
        }
        return getTemplateTag(tagName, templateToReplace);
    }

    private TemplateTag getTemplateTag(String name, List<String> template) {
        return new TemplateTag(name, template.toArray(new String[0]));
    }

    @Override
    public void show() {
        consoleUI.cls();
        List<TemplateTag> tags = getTagList();
        String[] processedTemplate = replaceTemplateTags(tags);
        consoleUI.showTemplate(processedTemplate);
    }

    @Override
    public OptionScreen getOptions() {
        return null;
    }

    public OptionScreen getPlayerActionsOptions() {
        String title = "Action";
        List<String> options = getPlayerActionsToDisplay();
        OptionScreen optionScreen = new OptionScreen(title, options);
        return optionScreen;
    }

    private List<String> getPlayerActionsToDisplay() {
        List<String> valuesToDisplay = new ArrayList<>();
        PlayerCharacter playerCharacter = battleService.getCurrentGame().getPlayerCharacter();
        for (Item item : playerCharacter.getItems()) {
            valuesToDisplay.add(item.getName());
        }
        for (Skill skill : playerCharacter.getSkills()) {
            valuesToDisplay.add(skill.getName());
        }
        return valuesToDisplay;
    }

    public OptionScreen getPlayerTargetOptions() {
        String title = "Target";
        List<String> options = getPlayerTargetToDisplay();
        OptionScreen optionScreen = new OptionScreen(title, options);
        return optionScreen;
    }

    private List<String> getPlayerTargetToDisplay() {
        List<String> valuesToDisplay = new ArrayList<>();
        List<Enemy> enemyList = battleService.getCurrentGame().getEnemyList();
        for (Enemy enemy : enemyList) {
            valuesToDisplay.add(enemy.getName());
        }
        return valuesToDisplay;
    }


    public OptionScreen getPlayerContinueOptions() {
        String title = "Option";
        List<String> options = new ArrayList<>(Arrays.asList("Continue"));
        OptionScreen optionScreen = new OptionScreen(title, options);
        return optionScreen;
    }




    /*
    *
    *         List<TemplateTag> tags = new ArrayList<>();
        tags.add(new TemplateTag())"<nombreDelPersonaje>"
        System.out.println(this.replaceTemplateTags(tags));
    *
        String prototipoParaMostrarLaClase = " Clase: (nombreDelPersonaje)";
        prototipoParaMostrarLaClase.replace("(nombreDelPersonaje)",personajePrincipal.getRole().name());
        System.out.println(" Clase: (nombreDelPersonaje) ");
        System.out.println("<nombreDelPersonaje>");
        System.out.println(" HP:    (hpPersonaje) ");
        System.out.println("");
        System.out.println("");
        *
        * <listaDeEnemigos>
        *
        *  System.out.println(" Enemigo1: <nombreDelEnemigo1>");
        System.out.println(" HP: (hpEnemigo1)");
        System.out.println("");
        *
        *  System.out.println(" Enemigo2: <nombreDelEnemigo1>");
        System.out.println(" HP: (hpEnemigo1)");
        System.out.println("");
        *
        *  System.out.println(" Enemigo3: <nombreDelEnemigo1>");
        System.out.println(" HP: (hpEnemigo1)");
        System.out.println("");
        *
        System.out.println(" Enemigo1: <nombreDelEnemigo1>");
        System.out.println(" HP: (hpEnemigo1)");
        System.out.println("");
        System.out.println(" Enemigo2: (nombreDelEnemigo2)");
        System.out.println(" HP: (hpEnemigo2)");
        System.out.println("");
        System.out.println("--------------------------------------------------------------");
        System.out.println(" Inicio de la batalla       ");
        System.out.println(" Es tu turno    ");
        System.out.println(" Accion:");
        System.out.println("    1. Skill");
        System.out.println(" Skill:");
        System.out.println("    1. ()");
        System.out.println("    2. Double damage");
        System.out.println(" Selecciona enemigo:");
        System.out.println("    1. Soldado A ");
        System.out.println("    2. Elemental A");
        System.out.println(" Soldado A Utiliza skill Slash, hace 50 daño al jugado        ");
        System.out.println(" Elemental A Utiliza skill fireball, hace de daño al jugado   ");
        System.out.println(" jugador Utiliza skill fireball, hace 70 daño al jugado       ");
        System.out.println("--------------------------------------------------------------");
    * */

}
