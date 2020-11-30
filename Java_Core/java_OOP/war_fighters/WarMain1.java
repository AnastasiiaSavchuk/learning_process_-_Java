package java_OOP.war_fighters;

public class WarMain1 {

    public static void main(String[] args) {

        Cleric fighter1 = new Cleric("Cleric", 350, "Handaxe", 125);
        Barbarian fighter2 = new Barbarian("Barbarian", 400, "Greatex", 150);
        Paladin fighter3 = new Paladin("Paladin", 300, "Battleax", 170);

        war1(fighter1, fighter2, fighter3);
    }

    private static void war1(Cleric fighter1, Barbarian fighter2, Paladin fighter3) {
        System.out.println("-----------------------------War------------------------------");
        System.out.println(fighter1.toString());
        System.out.println(fighter2.toString());
        System.out.println(fighter3.toString());
        System.out.println("---------------------------Round 1----------------------------");
        System.out.println(fighter1.getName() + " attack " + fighter2.getName());
        fighter1.attack();
        fighter2.setHp(fighter2.getHp() - fighter1.getWeaponDamage());
        System.out.println(fighter2.getName() + " hp = " + fighter2.getHp());
        System.out.println("--------------------------------------------------------------");
        System.out.println(fighter2.getName() + " attack " + fighter3.getName());
        fighter2.attack();
        fighter3.setHp(fighter3.getHp() - fighter2.getWeaponDamage());
        System.out.println(fighter3.getName() + " hp = " + fighter3.getHp());
        System.out.println("--------------------------------------------------------------");
        System.out.println(fighter3.getName() + " attack " + fighter1.getName());
        fighter3.attack();
        fighter1.setHp(fighter1.getHp() - fighter3.getWeaponDamage());
        System.out.println(fighter1.getName() + " hp = " + fighter1.getHp());
        System.out.println("--------------------------------------------------------------");
        System.out.println(fighter1.toString());
        System.out.println(fighter2.toString());
        System.out.println(fighter3.toString());
        if (fighter1.getHp() <= 0 && fighter2.getHp() <= 0) {
            System.out.println(fighter3.getName() + " winner!!!");
        } else if (fighter2.getHp() <= 0 && fighter3.getHp() <= 0) {
            System.out.println(fighter1.getName() + " winner!!!");
        } else if (fighter1.getHp() <= 0 && fighter3.getHp() <= 0) {
            System.out.println(fighter2.getName() + " winner!!!");
        } else {
            System.out.println("---------------------------Round 2----------------------------");
            System.out.println(fighter1.getName() + " attack " + fighter2.getName());
            fighter1.attack();
            fighter2.setHp(fighter2.getHp() - fighter1.getWeaponDamage());
            System.out.println(fighter2.getName() + " hp = " + fighter2.getHp());
            System.out.println("--------------------------------------------------------------");
            System.out.println(fighter2.getName() + " attack " + fighter3.getName());
            fighter2.attack();
            fighter3.setHp(fighter3.getHp() - fighter2.getWeaponDamage());
            System.out.println(fighter3.getName() + " hp = " + fighter3.getHp());
            System.out.println("--------------------------------------------------------------");
            System.out.println(fighter1.toString());
            System.out.println(fighter2.toString());
            System.out.println(fighter3.toString());
            if (fighter1.getHp() <= 0 && fighter2.getHp() <= 0) {
                System.out.println(fighter3.getName() + " winner!!!");
            } else if (fighter2.getHp() <= 0 && fighter3.getHp() <= 0) {
                System.out.println(fighter1.getName() + " winner!!!");
            } else if (fighter1.getHp() <= 0 && fighter3.getHp() <= 0) {
                System.out.println(fighter2.getName() + " winner!!!");
            } else {
                System.out.println("---------------------------Round 3----------------------------");
                System.out.println(fighter1.getName() + " attack " + fighter2.getName());
                fighter1.attack();
                fighter2.setHp(fighter2.getHp() - fighter1.getWeaponDamage());
                System.out.println(fighter2.getName() + " hp = " + fighter2.getHp());
                System.out.println("--------------------------------------------------------------");
                System.out.println(fighter2.getName() + " attack " + fighter1.getName());
                fighter2.attack();
                fighter1.setHp(fighter1.getHp() - fighter2.getWeaponDamage());
                System.out.println(fighter1.getName() + " hp = " + fighter1.getHp());
                System.out.println("--------------------------------------------------------------");
                System.out.println(fighter1.toString());
                System.out.println(fighter2.toString());
                System.out.println(fighter3.toString());
                if (fighter1.getHp() <= 0 && fighter2.getHp() <= 0) {
                    System.out.println(fighter3.getName() + " winner!!!");
                } else if (fighter2.getHp() <= 0 && fighter3.getHp() <= 0) {
                    System.out.println(fighter1.getName() + " winner!!!");
                } else if (fighter1.getHp() <= 0 && fighter3.getHp() <= 0) {
                    System.out.println(fighter2.getName() + " winner!!!");
                } else {
                    System.out.println("---------------------------Round 4----------------------------");
                    System.out.println(fighter1.getName() + " attack " + fighter2.getName());
                    fighter1.attack();
                    fighter2.setHp(fighter2.getHp() - fighter1.getWeaponDamage());
                    System.out.println(fighter2.getName() + " hp = " + fighter2.getHp());
                    System.out.println("--------------------------------------------------------------");
                    System.out.println(fighter1.toString());
                    System.out.println(fighter2.toString());
                    System.out.println(fighter3.toString() + "\n");
                    if (fighter1.getHp() <= 0 && fighter2.getHp() <= 0) {
                        System.out.println(fighter3.getName() + " winner!!!");
                    } else if (fighter2.getHp() <= 0 && fighter3.getHp() <= 0) {
                        System.out.println(fighter1.getName() + " winner!!!");
                    } else if (fighter1.getHp() <= 0 && fighter3.getHp() <= 0) {
                        System.out.println(fighter2.getName() + " winner!!!");
                    }
                }
            }
        }
    }
}

