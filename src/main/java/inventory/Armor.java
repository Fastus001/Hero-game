package inventory;

public class Armor {
    private ArmorPart head;
    private ArmorPart leftArm;
    private ArmorPart rightArm;
    private ArmorPart leftLeg;
    private ArmorPart rightLeg;
    private ArmorPart torso;
    private int damageResistance = 0;

    public ArmorPart equipArmour(ArmorPart toAssign)
    {
        ArmorPart toReturn = null;
        damageResistance+=toAssign.getDamageResistance();
        switch (toAssign.getBodyPartName())
        {
            case "HEAD":
                toReturn = this.head;

                this.head = toAssign;
                break;
            case "LEFT_ARM":
                toReturn = this.leftArm;
                this.leftArm = toAssign;
                break;
            case "RIGHT_ARM":
                toReturn = this.rightArm;
                this.rightArm = toAssign;
                break;
            case "LEFT_LEG":
                toReturn = this.leftLeg;
                this.leftLeg = toAssign;
                break;
            case "RIGHT_LEG":
                toReturn = this.rightLeg;
                this.rightLeg = toAssign;
                break;
            case "TORSO":
                toReturn = this.torso;
                this.torso = toAssign;
                break;
            default:
                System.out.println("Armor element not match to any location!!");
        }
        if(toReturn!=null){
            damageResistance-=toReturn.getDamageResistance();
        }
        return toReturn;
    }


    public ArmorPart getHead() {
        return head;
    }

    public ArmorPart getLeftArm() {
        return leftArm;
    }

    public ArmorPart getRightArm() {
        return rightArm;
    }

    public ArmorPart getLeftLeg() {
        return leftLeg;
    }

    public ArmorPart getRightLeg() {
        return rightLeg;
    }

    public ArmorPart getTorso() {
        return torso;
    }

    public int getDamageResistance() {

        return damageResistance;
    }
}
