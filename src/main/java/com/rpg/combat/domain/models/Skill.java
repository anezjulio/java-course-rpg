package src.main.java.com.rpg.combat.domain.models;

public class Skill extends Move{
    private String name;
    private String description;
    private int manaRequired;

    public Skill(int outputValue, SkillType skillType) {
        super(outputValue, skillType);
    }
    // slash: hace x daño al enemigo
    // stab: hace x daño al enemigo
    // double attack hace x daño al enemigo
    // iceball: hace x daño al enemigo
    // windcut: hace x daño al enemigo
    // thunder: hace x daño al enemigo
    // fireball: hace x daño al enemigo
    // heal: cura x cantidad de hp a un personaje (el mismo)
}
