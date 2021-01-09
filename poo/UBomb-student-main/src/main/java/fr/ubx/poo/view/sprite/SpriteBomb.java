package fr.ubx.poo.view.sprite;
import fr.ubx.poo.model.go.Bomb;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import fr.ubx.poo.view.image.*;


public class SpriteBomb extends SpriteGameObject{

    Bomb ownBomb;

    public SpriteBomb(Pane layer, Image image, Bomb bomb) {

        super(layer,image, bomb);
        this.ownBomb =  bomb;
        updateImage();
    }






    @Override
    public void updateImage() {
        int x = wich();

        if (x==1){
            this.setImage(ImageFactory.getInstance().get(ImageResource.BOMB3));
        }
        if (x==2){
            this.setImage(ImageFactory.getInstance().get(ImageResource.BOMB2));
        }
        if (x==3){
            this.setImage(ImageFactory.getInstance().get(ImageResource.BOMB1));
        }
        if (x==4){
            this.setImage(ImageFactory.getInstance().get(ImageResource.EXPLOSION));
        }
        if (x==5){
            this.setImage(null);
         }




    }
    private int wich (){
        return ownBomb.getState();

    }


}
