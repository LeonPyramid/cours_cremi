package fr.ubx.poo.view.sprite;

import fr.ubx.poo.model.go.BombDec;
import fr.ubx.poo.model.go.BombInc;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class SpriteBombDec extends  SpriteGameObject {

    public SpriteBombDec(Pane layer, Image image, BombDec bomb) {
        super(layer,image, bomb);
    }

    @Override
    public void updateImage() {
    }
}
