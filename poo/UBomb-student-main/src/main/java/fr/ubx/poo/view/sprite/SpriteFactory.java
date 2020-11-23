/*
 * Copyright (c) 2020. Laurent Réveillère
 */

package fr.ubx.poo.view.sprite;

import static fr.ubx.poo.view.image.ImageResource.*;

import fr.ubx.poo.game.Position;
import fr.ubx.poo.model.decor.Decor;
import fr.ubx.poo.model.decor.Stone;
import fr.ubx.poo.model.decor.Tree;
import fr.ubx.poo.model.go.Box;
import fr.ubx.poo.model.go.GameObject;
import fr.ubx.poo.model.go.Heart;
import fr.ubx.poo.model.go.Key;
import fr.ubx.poo.model.go.character.Player;
import fr.ubx.poo.view.image.ImageFactory;
import javafx.scene.layout.Pane;


public final class SpriteFactory {

    public static Sprite createDecor(Pane layer, Position position, Decor decor) {
        ImageFactory factory = ImageFactory.getInstance();
        if (decor instanceof Stone)
            return new SpriteDecor(layer, factory.get(STONE), position);
        if (decor instanceof Tree)
            return new SpriteDecor(layer, factory.get(TREE), position);
        return null;
    }

    public static Sprite createMovables(Pane layer, Position position, GameObject go){
        ImageFactory factory = ImageFactory.getInstance();
        if ( go  instanceof Box)
            return new SpriteBox(layer,factory.get(BOX), (Box) go);
        if (go instanceof  Key)
            return  new SpriteKey(layer,factory.get(KEY), (Key) go);
        if (go instanceof Heart)
            return new SpriteHeart(layer, factory.get(HEART), (Heart) go );
        return null;
        
    }

    public static Sprite createPlayer(Pane layer, Player player) {
        return new SpritePlayer(layer, player);
    }
}
