package dosw.semana_4.patrones;

public class WarriorBuilder {

    private String armor;
    private String weapon;
    private String skill;

    public WarriorBuilder setArmor(String armor) {
        this.armor = armor;
        return this;
    }

    public WarriorBuilder setWeapon(String weapon) {
        this.weapon = weapon;
        return this;
    }

    public WarriorBuilder setSkill(String skill) {
        this.skill = skill;
        return this;
    }

    public Character build() {
        return new Warrior(armor, weapon, skill);
    }
}
