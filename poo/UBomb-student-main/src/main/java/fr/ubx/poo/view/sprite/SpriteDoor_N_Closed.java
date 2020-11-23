package fr.ubx.poo.view.sprite;

import fr.ubx.poo.model.go.BombRangeInc;
import fr.ubx.poo.model.go.Door_Next_Closed;
import fr.ubx.poo.model.go.Door_Next_Open;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class SpriteDoor_N_Closed extends SpriteGameObject {

    public SpriteDoor_N_Closed (Pane layer, Image image, Door_Next_Closed door) {

            super(layer,image, door);



        }

        @Override
        public void updateImage() {
        }
}
