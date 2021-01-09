package fr.ubx.poo.view.sprite;

import fr.ubx.poo.model.go.BombRangeDec;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class SpriteBombRangeDec  extends SpriteGameObject {

    public SpriteBombRangeDec (Pane layer, Image image, BombRangeDec bomb) {

        super(layer,image, bomb);



    }

    @Override
    public void updateImage() {
    }
}
