package java_OOP.war_fighters;

public class Cleric extends Fighter {

    public Cleric(String name, int hp, String weapon, int weaponDamage) {
        super(name, hp, weapon, weaponDamage);
    }

    @Override
    public void attack() {
        System.out.println(getName() + " attack with power : " + getWeaponDamage());
    }

    @Override
    public boolean isDead() {
        return getHp() <= 0;
    }
}
