package fr.ubx.poo.view.sprite;

import fr.ubx.poo.model.go.Key;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class SpriteKey extends SpriteGameObject {

    public SpriteKey(Pane layer, Image image, Key key){super(layer,image, key);}

    @Override
    public void updateImage() {
    }
}
