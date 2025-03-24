package com.rpg.combat.domain.models;

import com.rpg.combat.domain.constants.Chapter;

import java.time.LocalDateTime;
import java.util.List;

// partida
public class Game {

    private LocalDateTime startDateTime = LocalDateTime.now();
    private String name;
    private PlayerCharacter playerCharacter;
    private Chapter chapter;
    private List<Event> eventRecord;
    private Score score;

    public Game(LocalDateTime startDateTime, String name, PlayerCharacter playerCharacter, Chapter chapter, List<Event> eventRecord, Score score) {
        this.startDateTime = startDateTime;
        this.name = name;
        this.playerCharacter = playerCharacter;
        this.chapter = chapter;
        this.eventRecord = eventRecord;
        this.score = score;
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
}
