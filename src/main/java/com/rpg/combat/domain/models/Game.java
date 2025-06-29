package com.rpg.combat.domain.models;

import com.rpg.combat.domain.constants.Chapter;

import java.time.LocalDateTime;
import java.util.List;

// partida
public class Game {

    private LocalDateTime startDateTime;
    private PlayerCharacter playerCharacter;
    private List<Enemy> enemies;
    private List<Event> eventRecord;
    private Chapter chapter;
    private Score score;
    private String name;
    private int turn;
    private int round;

    public Game(
            String name,
            int turn,
            int round,
            PlayerCharacter playerCharacter,
            List<Enemy> enemies,
            Chapter chapter,
            List<Event> eventRecord,
            Score score
    ) {
        this.startDateTime = LocalDateTime.now();
        this.name = name;
        this.playerCharacter = playerCharacter;
        this.chapter = chapter;
        this.eventRecord = eventRecord;
        this.score = score;
        this.enemies = enemies;
        this.turn = turn;
        this.round = round;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerCharacter getPlayerCharacter() {
        return playerCharacter;
    }

    public void setPlayerCharacter(PlayerCharacter playerCharacter) {
        this.playerCharacter = playerCharacter;
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public List<Event> getEventRecord() {
        return eventRecord;
    }

    public void setEventRecord(List<Event> eventRecord) {
        this.eventRecord = eventRecord;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }
}
