package src;

import src.domain.Item;
import src.domain.SkillType;

public class Principal {
    public static void main(String[] args) {

        Item sword = new Item("sword", "normal sword", 15, 20, SkillType.DAMAGE);
        System.out.println(
                "name: " + sword.getName() +
                        " description: " + sword.getDescription() +
                        " SkillType: " + sword.getSkillType() +
                        " OutputValue: " + sword.getOutputValue() +
                        " remainUses: " + sword.getUseAmount());
        sword.useItem();
        System.out.println(
                "name: " + sword.getName() +
                        " description: " + sword.getDescription() +
                        " SkillType: " + sword.getSkillType() +
                        " OutputValue: " + sword.getOutputValue() +
                        " remainUses: " + sword.getUseAmount());




    }
}
