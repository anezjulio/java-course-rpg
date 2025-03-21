package com.rpg.combat.domain.models;

public class Item extends Move{

    private String name;
    private String description;
    private int useAmount;

    public Item(String name, String description, int useAmount, int outputValue, SkillType skillType){
        super(outputValue, skillType);
        this.name = name;
        this.description = description;
        this.useAmount = useAmount;
    }

    public int getAmount() {return super.getAmount();}

    public SkillType getSkillType() {return super.getSkillType();}


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getUseAmount() {
        return useAmount;
    }

    public void useItem() {
        if(this.getUseAmount() > 0){
            this.useAmount--;
        }
    }
}
