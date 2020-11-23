
package fr.ubx.poo.view.sprite;

import fr.ubx.poo.model.go.Box;
import fr.ubx.poo.view.image.ImageFactory;
import fr.ubx.poo.view.image.ImageResource;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.layout.Pane;

import java.awt.*;

import static fr.ubx.poo.view.image.ImageResource.BOX;

public class SpriteBox extends SpriteGameObject {


    public SpriteBox(Pane layer, Box box) {

        super(layer,ImageFactory.getInstance().get(BOX), box);



    }

    @Override
    public void updateImage() {
    }
}
