package src.domain;

import java.time.LocalDateTime;
import java.util.List;

// partida
public class Game {
    private LocalDateTime dateTime = LocalDateTime.now();
    private String name;
    private PlayerCharacter playerCharacter;
    private Chapter chapter;
    private List<Event> eventRecord;
    private Score score;
}
