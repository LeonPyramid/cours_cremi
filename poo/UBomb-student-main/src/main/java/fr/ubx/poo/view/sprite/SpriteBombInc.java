package fr.ubx.poo.view.sprite;

import fr.ubx.poo.model.go.BombInc;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class SpriteBombInc extends SpriteGameObject {
    public SpriteBombInc (Pane layer, Image image, BombInc bomb) {

        super(layer,image, bomb);



    }

    @Override
    public void updateImage() {
    }
}
