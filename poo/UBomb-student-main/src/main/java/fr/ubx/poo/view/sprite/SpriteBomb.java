package fr.ubx.poo.view.sprite;

import fr.ubx.poo.model.go.Bomb;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class SpriteBomb extends SpriteGameObject{

    public SpriteBomb(Pane layer, Image image, Bomb bomb) {
        super(layer,image, bomb);
    }

    @Override
    public void updateImage() {

    }


}
