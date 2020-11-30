package java_OOP.war_fighters;


public abstract class Fighter {

    private String name;
    private int hp;
    private String weapon;
    private int weaponDamage;

    public Fighter(String name, int hp, String weapon, int weaponDamage) {
        this.name = name;
        this.hp = hp;
        this.weapon = weapon;
        this.weaponDamage = weaponDamage;
    }

    public abstract void attack();

    public abstract boolean isDead();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    @Override
    public String toString() {
        return "" + "" + name + ": hp = " + hp + ", weapon = " + weapon + " : " + weaponDamage + " power.";
    }
}

