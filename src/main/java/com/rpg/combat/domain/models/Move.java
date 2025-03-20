package src.main.java.com.rpg.combat.domain.models;

public class Move {

    private int outputValue;
    private SkillType skillType;

    public Move(int outputValue, SkillType skillType) {
        this.outputValue = outputValue;
        this.skillType = skillType;
    }

    public int getOutputValue() {
        return outputValue;
    }

    public SkillType getSkillType() {
        return skillType;
    }

}
