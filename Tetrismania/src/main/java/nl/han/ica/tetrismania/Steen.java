package nl.han.ica.tetrismania;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.Sprite;
import nl.han.ica.OOPDProcessingEngineHAN.Objects.SpriteObject;

/**
 * @author Ralph Niels
 * Een zwaardvis is een spelobject dat zelfstandig
 * door de wereld beweegt
 */
public class Steen extends SpriteObject {

    private Tetrismania world;

    /**
     * Constructor
     * @param world Referentie naar de wereld
     */
    public Steen(Tetrismania world) {
        this(new Sprite("src/main/java/nl/han/ica/tetrismania/media/vierkant.png"));
        this.world=world;
    }

    /**
     * Maak een Swordfish aan met een sprite
     * @param sprite De sprite die aan dit object gekoppeld moet worden
     */
    private Steen(Sprite sprite) {
        super(sprite);
        setySpeed(+1);
    }

    @Override
    public void update() {
        if (getY()+getWidth()<=0) {
            setY(world.getWidth());
        }

    }
}