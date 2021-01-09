
package fr.ubx.poo.view.sprite;

import fr.ubx.poo.model.go.Box;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;


public class SpriteBox extends SpriteGameObject {


    public SpriteBox(Pane layer, Image image, Box box) {

        super(layer,image, box);



    }

    @Override
    public void updateImage() {
    }
}
