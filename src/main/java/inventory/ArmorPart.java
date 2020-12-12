package inventory;

import utils.BodyPart;

public class ArmorPart extends InventoryObject{
    private final int damageResistance;
    private final BodyPart bodyPart;

    public ArmorPart(String name, double weight, int damageResistance, BodyPart bodyPart) {
        super(name, weight);
        this.damageResistance = damageResistance;
        this.bodyPart = bodyPart;
    }

    public BodyPart getBodyPart() {
        return bodyPart;
    }


    public  String getBodyPartName()
    {
        return bodyPart.name();
    }

    public int getDamageResistance() {
        return damageResistance;
    }


}
