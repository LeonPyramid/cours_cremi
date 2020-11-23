/*
 * Copyright (c) 2020. Laurent Réveillère
 */

package fr.ubx.poo.view.sprite;

import static fr.ubx.poo.view.image.ImageResource.*;

import fr.ubx.poo.game.Position;
import fr.ubx.poo.model.decor.Decor;
import fr.ubx.poo.model.decor.Stone;
import fr.ubx.poo.model.decor.Tree;
import fr.ubx.poo.model.go.*;
import fr.ubx.poo.model.go.character.Monster;
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
        if (go instanceof Monster)
            return new SpriteMonster(layer,factory.get(MONSTER_DOWN), (Monster) go);
        if (go instanceof Princess)
            return new SpritePrincess(layer,factory.get(PRINCESS), (Princess) go);
        if (go instanceof BombRangeInc)
            return new SpriteBombRangInc(layer, factory.get(BOMB_R_INC),(BombRangeInc) go );
        if (go  instanceof  BombRangeDec)
            return new SpriteBombRangeDec(layer, factory.get(BOMB_R_DEC),(BombRangeDec) go );
        if(go instanceof BombInc)
            return new SpriteBombInc(layer,factory.get(BOMB_INC), (BombInc) go);

        if (go instanceof  Door_Next_Closed)
            return  new SpriteDoor_N_Closed(layer, factory.get(DCLOSE),(Door_Next_Closed) go );
        if (go instanceof  Door_Next_Open)
            return  new SpriteDoor_N_Open(layer, factory.get(DOPEN),(Door_Next_Open) go);





        return null;
        
    }

    public static Sprite createPlayer(Pane layer, Player player) {
        return new SpritePlayer(layer, player);
    }
}
