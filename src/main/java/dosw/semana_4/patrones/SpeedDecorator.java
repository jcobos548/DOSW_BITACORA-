package dosw.semana_4.patrones;

public class SpeedDecorator extends CharacterDecorator {

    public SpeedDecorator(Character character) {
        super(character);
    }

    @Override
    public void attack() {
        System.out.println("Velocidad extra activada.");
        super.attack();
    }
}