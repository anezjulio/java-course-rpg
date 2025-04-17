package com.rpg.combat.infraestructure.output.screen;

// info del jugador HUB
// lista de enemigos
// Acciones a tomar
// leer opcion de la consola

import com.rpg.combat.domain.models.Enemy;
import com.rpg.combat.domain.models.OptionScreen;
import com.rpg.combat.domain.models.PlayerCharacter;
import com.rpg.combat.domain.models.TemplateTag;
import com.rpg.combat.domain.services.BattleService;
import com.rpg.combat.infraestructure.output.ConsoleUI;

import java.util.ArrayList;
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
                "round: <currentRound>",
                "turno: <currentTurn>",
                "",
                "Character:",
                "<characterList>",
                "",
                "Enemies: ",
                "<enemyList>",
                "",
                "",
                "",
        };
        return template;
    }

    private List<TemplateTag> getTagList() {
        List<TemplateTag> tagList = new ArrayList<>();
        tagList.add(getCurrentPlayerNameTag());
        tagList.add(getCurrentChapterTag());
        tagList.add(getCurrentRoundTag());
        tagList.add(getCurrentTurnTag());
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
    }

    private TemplateTag getEnemyListTag() {
        String tagName = "<enemyList>";
        List<String> templateToReplace = new ArrayList<>();
        List<Enemy> enemyList = battleService.getCurrentGame().getEnemyList();
        for (int i = 0; i < enemyList.size() ; i++ ){
            templateToReplace.add("--- --- --- --- --- --- --- --- --- --- --- --- ---" + "\n");
            templateToReplace.add( (i + 1) + ". " + enemyList.get(i).getName()+ "\n");
            templateToReplace.add( "Level: " + enemyList.get(i).getLevel() + "\n");
            templateToReplace.add( "Damage: " + enemyList.get(i).getDamage() + "\n");
            templateToReplace.add( "HP: " + enemyList.get(i).getHpCurrent() + "/" + enemyList.get(i).getHpMax() + "\n");
            templateToReplace.add( "MP: " + enemyList.get(i).getMpCurrent() + "/" + enemyList.get(i).getMpMax() + "\n");
            templateToReplace.add("--- --- --- --- --- --- --- --- --- --- --- --- ---" + "\n");

        }
        return getTemplateTag(tagName, templateToReplace);
    }

    private TemplateTag getCharacterListTag() {
        String tagName = "<characterList>";
        List<String> templateToReplace = new ArrayList<>();
        List<PlayerCharacter> playerCharacterList = new ArrayList<>();
        playerCharacterList.add(battleService.getCurrentGame().getPlayerCharacter());
        for (int i = 0; i < playerCharacterList.size() ; i++ ){
            templateToReplace.add(playerCharacterList.get(i).getName()+ "\n");
            templateToReplace.add( "Level: " + playerCharacterList.get(i).getLevel() + "\n");
            templateToReplace.add( "HP: " + playerCharacterList.get(i).getHpCurrent() + "/" + playerCharacterList.get(i).getHpMax() + "\n");
            templateToReplace.add( "MP: " + playerCharacterList.get(i).getMpCurrent() + "/" + playerCharacterList.get(i).getMpMax() + "\n");
            templateToReplace.add( "Damage: " + playerCharacterList.get(i).getDamage() + "\n");
        }
        return getTemplateTag(tagName, templateToReplace);
    }


    private TemplateTag getTemplateTag(String name, List<String> template) {
        return new TemplateTag(name, template.toArray(new String[0]));
    }

    @Override
    public void show() {
        consoleUI.cls();
        List<TemplateTag> tag = getTagList();
        String[] processedTemplate = replaceTemplateTags(tag);
        consoleUI.showTemplate(processedTemplate);
    }

    @Override
    public OptionScreen getOptions() {
        return null;
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
