package dosw.semana_4.patrones;

public class ShieldDecorator extends CharacterDecorator {

    public ShieldDecorator(Character character) {
        super(character);
    }

    @Override
    public void attack() {
        System.out.println("Escudo de hielo activado.");
        super.attack();
    }
}