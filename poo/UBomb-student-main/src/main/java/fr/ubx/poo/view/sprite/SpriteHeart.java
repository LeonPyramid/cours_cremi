package fr.ubx.poo.view.sprite;

import fr.ubx.poo.model.go.Heart;
import fr.ubx.poo.model.go.Key;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class SpriteHeart extends SpriteGameObject{

    public SpriteHeart (Pane layer, Image image, Heart heart){super(layer,image,heart);}

    @Override
    public void updateImage() { }

}
