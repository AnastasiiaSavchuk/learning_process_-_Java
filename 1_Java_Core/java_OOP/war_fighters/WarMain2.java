package java_OOP.war_fighters;

public class WarMain2 {

    public static void main(String[] args) {
        Cleric cleric = new Cleric("Cleric", 350, "Handaxe", 85);
        Barbarian barbarian = new Barbarian("Barbarian", 386, "Greatex", 98);
        Paladin paladin = new Paladin("Paladin", 305, "Battleax", 95);
        battle(cleric, barbarian, paladin);
    }

    private static void battle(Cleric cleric, Barbarian barbarian, Paladin paladin) {
        do {
            System.out.println("-----------------------------War------------------------------");
            System.out.println(cleric.toString());
            System.out.println(barbarian.toString());
            System.out.println(paladin.toString());
            System.out.println("----------------------------Round-----------------------------");
            System.out.println(cleric.getName() + " attack " + barbarian.getName());
            cleric.attack();
            barbarian.setHp(barbarian.getHp() - cleric.getWeaponDamage());
            System.out.println(barbarian.getName() + " hp = " + barbarian.getHp());
            System.out.println("--------------------------------------------------------------");
            System.out.println(barbarian.getName() + " attack " + paladin.getName());
            barbarian.attack();
            paladin.setHp(paladin.getHp() - barbarian.getWeaponDamage());
            System.out.println(paladin.getName() + " hp = " + paladin.getHp());
            System.out.println("--------------------------------------------------------------");
            System.out.println(paladin.getName() + " attack " + cleric.getName());
            paladin.attack();
            cleric.setHp(cleric.getHp() - paladin.getWeaponDamage());
            System.out.println(cleric.getName() + " hp = " + cleric.getHp());
        } while (!(cleric.isDead()) && !(barbarian.isDead()) || !(barbarian.isDead()) && !(paladin.isDead()) || !(paladin.isDead()) && !(cleric.isDead()));
        if (cleric.isDead() && barbarian.isDead()) {
            System.out.println(paladin.getName() + " winner!!!");
        } else if (barbarian.isDead() && paladin.isDead()) {
            System.out.println(cleric.getName() + " winner!!!");
        } else if (cleric.isDead() && paladin.isDead()) {
            System.out.println(barbarian.getName() + " winner!!!");
        }
    }
}
