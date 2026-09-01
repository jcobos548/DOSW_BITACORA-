package dosw.semana_4.patrones;

public abstract class CharacterDecorator implements Character {

    protected Character character;

    public CharacterDecorator(Character character) {
        this.character = character;
    }

    @Override
    public void attack() {
        character.attack();
    }
}