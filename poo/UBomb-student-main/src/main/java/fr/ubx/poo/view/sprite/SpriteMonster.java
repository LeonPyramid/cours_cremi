package fr.ubx.poo.view.sprite;

import fr.ubx.poo.model.go.Box;
import fr.ubx.poo.model.go.character.Monster;
import fr.ubx.poo.model.go.character.Player;
import fr.ubx.poo.view.image.ImageFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class SpriteMonster extends SpriteGameObject {

    public SpriteMonster(Pane layer, Image image, Monster monster) {

        super(layer,image, monster);
        updateImage();
    }

    @Override
    public void updateImage() {
    	Monster monster = (Monster) go;
        setImage(ImageFactory.getInstance().getMonster(monster.getDirection()));
       
    }
}
