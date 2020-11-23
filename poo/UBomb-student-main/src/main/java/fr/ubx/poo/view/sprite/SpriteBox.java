
package fr.ubx.poo.view.sprite;

import fr.ubx.poo.model.go.Box;
import fr.ubx.poo.view.image.ImageFactory;
import fr.ubx.poo.view.image.ImageResource;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.awt.*;

import static fr.ubx.poo.view.image.ImageResource.BOX;

public class SpriteBox extends SpriteGameObject {


    public SpriteBox(Pane layer, Image image, Box box) {

        super(layer,image, box);



    }

    @Override
    public void updateImage() {
    }
}
