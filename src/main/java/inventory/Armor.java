package inventory;

public class Armor {
    private ArmorPart head;
    private ArmorPart leftArm;
    private ArmorPart rightArm;
    private ArmorPart leftLeg;
    private ArmorPart rightLeg;
    private ArmorPart torso;

    public ArmorPart equipArmour(ArmorPart toAssign)
    {
        ArmorPart toReturn = null;
        switch (toAssign.getBodyPart())
        {
            case "Head":
                toReturn = this.head;
                this.head = toAssign;
                break;
//            case "Left arm":return checkSlot(this.leftArm,toAssign);
//            case "Right arm":return checkSlot(this.rightArm,toAssign);
//            case "Left leg":return checkSlot(this.leftLeg,toAssign);
//            case "Right leg":return checkSlot(this.rightLeg,toAssign);
//            case "Torso":return checkSlot(this.torso,toAssign);
            default:
                System.out.println("Armor element not match to any location!!");
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
}
