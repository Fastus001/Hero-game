package inventory;

public class ArmorPart extends InventoryObject{
    private int damageResistance;
    private String bodyPart;

    public ArmorPart(String name, double weight, int damageResistance, String bodyPart) {
        super(name, weight);
        this.damageResistance = damageResistance;
        this.bodyPart = bodyPart;
    }

    public String getBodyPart() {
        return bodyPart;
    }

    public int getDamageResistance() {
        return damageResistance;
    }
}
