package com.rpg.combat.application.screen;

public interface Screen {

    // muestra la pantalla con los datos reemplazados en el texto
    // llama a dataForScreen(objetos con datos), y textForScreen()
    void show();

    // texto base a mostrar en la pantalla
    String textForScreen();

    // datos a reemplazar para mostrar en la pantalla
    String dataForScreen();

    // llama a show() para mostrar texto con datos reemplazados
    void loadScreen();

    // llama a la siguiente pantalla a mostrar
    void nextScreen();

}
