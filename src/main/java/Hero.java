public class Hero {
    private static final double MAX_LOAD = 100;
    private String name;
    private String race;
    private int currentHealth;
    private InventoryObject[] equipment = new InventoryObject[10];
    private boolean overloaded;

    public Hero(String name, String race) {
        this.name = name;
        this.race = race;
        this.currentHealth = 100;
    }

    public void showEquipment()
    {
        for (int i = 0; i < equipment.length; i++) {
            if(equipment[i]!=null){
                System.out.print((i+1) +" ");
                equipment[i].showItem();
            }
        }
    }

    public boolean addNewItem(InventoryObject io)
    {
        for (int i = 0; i < equipment.length; i++) {
            if(equipment[i] == null){
                equipment[i] = io;
                checkOverload();
                return true;
            }else if(equipment[i].getWeight() == io.getWeight() && equipment[i].getName().equals(io.getName()))
            {
                equipment[i].addOneToCount();
                checkOverload();
                return true;
            }
        }
        return false;
    }

    private void checkOverload() {
        double sum = 0;
        for (InventoryObject inventoryObject : equipment) {
            if(inventoryObject!=null){
                sum += inventoryObject.getWeight() * inventoryObject.getCount();
            }
        }
        if(sum > MAX_LOAD){
            overloaded = true;
            System.out.println("Hero is overloaded");
        }

    }
}
