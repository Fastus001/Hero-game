package npc;

public class Monster extends Enemy {
    private String description;

    public Monster(String name, int health, int damage, String description) {
        super(name, health, damage);
        this.description = description;
    }


    @Override
    public void getDamage(int dmg) {
        super.changeHeath(dmg);
        if(this.isDamageLethal())
            System.out.println("Enemy's dead!");
    }




}
