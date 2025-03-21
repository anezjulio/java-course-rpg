package com.rpg.combat.domain.models;

import com.rpg.combat.domain.constants.Chapter;

public class Event {

    private Chapter chapter;
    private int turn;
    private Character playerTurn;
    private Character target;
    private Action action;

    // Un evento ejecuta una accion, teniendo en cuenta que el "playerTurn" ejecutara una "accion" sobre "target"

}
