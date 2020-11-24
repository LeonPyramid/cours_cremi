package fr.ubx.poo.view.sprite;

import fr.ubx.poo.model.go.Door_Prev_Open;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class SpriteDoor_P_Open extends SpriteGameObject {

    public SpriteDoor_P_Open(Pane layer, Image image, Door_Prev_Open door) {

        super(layer, image, door);


    }

    @Override
    public void updateImage() {
    }
}

