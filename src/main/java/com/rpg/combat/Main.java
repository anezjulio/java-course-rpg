package com.rpg.combat;


import com.rpg.combat.application.handler.*;
import com.rpg.combat.domain.services.BattleService;
import com.rpg.combat.infraestructure.input.ConsoleInput;
import com.rpg.combat.infraestructure.output.ConsoleUI;
import com.rpg.combat.infraestructure.output.GameScreenManager;
import com.rpg.combat.infraestructure.output.screen.*;
import com.rpg.combat.infraestructure.persistence.EnemyRepository;
import com.rpg.combat.infraestructure.persistence.GameRepository;
import com.rpg.combat.infraestructure.persistence.PlayerCharacterRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Main {

    // Declare dependencies
    private static MenuHandler menuHandler;
    private static ContinueHandler continueHandler;
    private static NewProfileHandler newProfileHandler;
    private static BattleHandler battleHandler;
    private static CreditsHandler creditsHandler;

    private static MenuScreen menuScreen;
    private static ContinueScreen continueScreen;
    private static NewProfileScreen newProfileScreen;
    private static BattleScreen battleScreen;
    private static CreditsScreen creditsScreen;


    private static GameRepository gameRepository;
    private static PlayerCharacterRepository playerCharacterRepository;
    private static EnemyRepository enemyRepository;

    private static ConsoleInput consoleInput;
    private static ConsoleUI consoleUI;

    private static BattleService battleService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        GameScreenManager gameScreenManager = new GameScreenManager(getMenuHandler());
        gameScreenManager.startGame();
    }

    // Lazy initialization - Inicialización perezosa
    // Decision Tecnica/Mala practica
    // Hacer los método público: Solución rápida,
    // pero expone el acceso a las dependencias desde
    // cualquier parte del código, lo que puede no ser ideal.

    public static ConsoleInput getConsoleInput() {
        if (consoleInput == null) {
            consoleInput = new ConsoleInput();
        }
        return consoleInput;
    }

    public static ConsoleUI getConsoleUI() {
        if (consoleUI == null) {
            consoleUI = new ConsoleUI();
        }
        return consoleUI;
    }

    public static MenuHandler getMenuHandler() {
        if (menuHandler == null) {
            menuHandler = new MenuHandler(getMenuScreen(), getConsoleInput(), getConsoleUI());
        }
        return menuHandler;
    }

    public static GameRepository getGameRepository() {
        if (gameRepository == null) {
            gameRepository = new GameRepository();
        }
        return gameRepository;
    }

    public static PlayerCharacterRepository getPlayerCharacterRepository() {
        if (playerCharacterRepository == null) {
            playerCharacterRepository = new PlayerCharacterRepository();
        }
        return playerCharacterRepository;
    }

    public static ContinueScreen getContinueScreen() {
        if (continueScreen == null) {
            continueScreen = new ContinueScreen(getConsoleUI());
        }
        return continueScreen;
    }

    public static ContinueHandler getContinueHandler() {
        if (continueHandler == null) {
            continueHandler = new ContinueHandler(
                    getGameRepository(),
                    getContinueScreen(),
                    getConsoleInput(),
                    getConsoleUI(),
                    getBattleService()
            );
        }
        return continueHandler;
    }

    public static BattleService getBattleService() {
        if (battleService == null) {
            battleService = new BattleService();
        }
        return battleService;
    }

    public static BattleHandler getBattleHandler() {
        if (battleHandler == null) {
            battleHandler = new BattleHandler(
                    getConsoleUI(),
                    getConsoleInput(),
                    getBattleService(),
                    getBattleScreen()
            );
        }
        return battleHandler;
    }

    private static NewProfileScreen getNewProfileScreen() {
        if (newProfileScreen == null) {
            newProfileScreen = new NewProfileScreen(getConsoleUI());
        }
        return newProfileScreen;
    }

    public static MenuScreen getMenuScreen() {
        if (menuScreen == null) {
            menuScreen = new MenuScreen(getConsoleUI());
        }
        return menuScreen;
    }

    public static NewProfileHandler getNewProfileHandler() {
        if (newProfileHandler == null) {
            newProfileHandler = new NewProfileHandler(
                    getBattleService(),
                    getNewProfileScreen(),
                    getConsoleInput(),
                    getConsoleUI(),
                    getPlayerCharacterRepository(),
                    getEnemyRepository()
            );

        }
        return newProfileHandler;
    }

    public static BattleScreen getBattleScreen() {
        if (battleScreen == null) {
            battleScreen = new BattleScreen(
                    getConsoleUI(),
                    getBattleService()
            );
        }
        return battleScreen;
    }

    private static CreditsScreen getCreditsScreen() {
        if (creditsScreen == null) {
            creditsScreen = new CreditsScreen(getConsoleUI());
        }
        return creditsScreen;
    }

    public static CreditsHandler getCreditsHandler() {
        if (creditsHandler == null) {
            creditsHandler= new CreditsHandler(getCreditsScreen(), getConsoleInput(), getConsoleUI());
        }
        return creditsHandler;
    }
    public static EnemyRepository getEnemyRepository() {
        if (enemyRepository == null) {
            enemyRepository = new EnemyRepository();
        }
        return enemyRepository;
    }

}

