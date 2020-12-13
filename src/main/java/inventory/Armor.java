package inventory;

import utils.BodyPart;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class Armor {
    private Map<BodyPart,ArmorPart> armor = new HashMap<>();
    private int damageResistance = 0;

    public ArmorPart equipArmorAdvanced(ArmorPart toAssign){
        return armor.put(toAssign.getBodyPart(), toAssign);
    }

    public ArmorPart getBodyPart(BodyPart bp) {
        return armor.get(bp);
    }

    public int getDamageResistance() {
        return armor.values()
                .stream()
                .map(ArmorPart::getResistance)
                .reduce(Integer::sum)
                .orElseThrow();
    }

    public double getWeight() {
        return armor.values()
                .stream()
                .filter(Objects::nonNull)
                .map(InventoryObject::getWeight)
                .reduce(Double::sum)
                .orElse(0.0);
    }
}
