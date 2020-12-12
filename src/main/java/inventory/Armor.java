package inventory;

import utils.BodyPart;

import java.util.Map;
import java.util.TreeMap;

public final class Armor {
    private Map<BodyPart,ArmorPart> armor = new TreeMap<>();
    private int damageResistance = 0;

    public ArmorPart equipArmorAdvanced(ArmorPart toAssign){
        return armor.put(toAssign.getBodyPart(), toAssign);
    }

    public ArmorPart getHead() {
        return armor.get(BodyPart.HEAD);
    }

    public ArmorPart getLeftArm() {
        return armor.get(BodyPart.LEFT_ARM);
    }

    public ArmorPart getRightArm() {
        return armor.get(BodyPart.RIGHT_ARM);
    }

    public ArmorPart getLeftLeg() {
        return armor.get(BodyPart.LEFT_LEG);
    }

    public ArmorPart getRightLeg() {
        return armor.get(BodyPart.RIGHT_LEG);
    }

    public ArmorPart getTorso() {
        return armor.get(BodyPart.TORSO);
    }

    public int getDamageResistance() {
        return armor.values()
                .stream()
                .map(ArmorPart::getDamageResistance)
                .reduce(Integer::sum)
                .orElseThrow();
    }
}
