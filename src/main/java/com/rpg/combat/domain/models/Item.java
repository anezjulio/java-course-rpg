package com.rpg.combat.domain.models;

import com.rpg.combat.domain.constants.MoveType;

public class Item extends Action{

    private String name;
    private String description;
    private int useAmount;

    public Item(String name, String description, int useAmount, int outputValue, MoveType moveType){
        super(outputValue, moveType);
        this.name = name;
        this.description = description;
        this.useAmount = useAmount;
    }

    public int getAmount() {return super.getAmount();}

    public MoveType getMoveType() {return super.getMoveType();}


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
