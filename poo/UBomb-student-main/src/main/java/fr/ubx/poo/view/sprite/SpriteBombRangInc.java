package fr.ubx.poo.view.sprite;

import fr.ubx.poo.model.go.BombRangeDec;
import fr.ubx.poo.model.go.BombRangeInc;
import fr.ubx.poo.model.go.Princess;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class SpriteBombRangInc extends SpriteGameObject {

    public SpriteBombRangInc (Pane layer, Image image, BombRangeInc bomb) {

        super(layer,image, bomb);



    }

    @Override
    public void updateImage() {
    }
}
