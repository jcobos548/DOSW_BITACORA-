package dosw.semana_4.patrones;

public class Ejercicio4 {

    public static void main(String[] args) {

        WarriorBuilder builder = new WarriorBuilder();

        Character warrior = builder
                .setArmor("steel")
                .setWeapon("sword")
                .setSkill("rage")
                .build();

        System.out.println("Personaje base:");
        warrior.attack();

        System.out.println();

        Character powered = new ShieldDecorator(
                new SpeedDecorator(warrior)
        );

        System.out.println("Personaje con poderes:");
        powered.attack();
    }
}
