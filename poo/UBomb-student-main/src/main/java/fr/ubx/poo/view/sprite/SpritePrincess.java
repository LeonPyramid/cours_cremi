package fr.ubx.poo.view.sprite;

import fr.ubx.poo.model.go.Princess;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class SpritePrincess extends SpriteGameObject  {

    public SpritePrincess(Pane layer, Image image, Princess princess) {

        super(layer,image, princess);



    }

    @Override
    public void updateImage() {
    }
}
