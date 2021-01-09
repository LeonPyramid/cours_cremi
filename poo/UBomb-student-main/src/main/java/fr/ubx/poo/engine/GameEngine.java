/*
 * Copyright (c) 2020. Laurent Réveillère
 */

package fr.ubx.poo.engine;

import fr.ubx.poo.game.Direction;
import fr.ubx.poo.game.World;
import fr.ubx.poo.model.go.*;
import fr.ubx.poo.view.image.ImageFactory;
import fr.ubx.poo.view.image.ImageResource;
import fr.ubx.poo.view.sprite.*;
import fr.ubx.poo.game.Game;
import fr.ubx.poo.game.Position;
import fr.ubx.poo.model.go.character.Player;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public final class GameEngine {

    private static AnimationTimer gameLoop;
    private final String windowTitle;
    private final Game game;
    private final Player player;
    private static List<Sprite> sprites = new ArrayList<>();
    private StatusBar statusBar;
    private static Pane layer;
    private Input input;
    private Stage stage;
    private Sprite spritePlayer;

    public GameEngine(final String windowTitle, Game game, final Stage stage) {
        this.windowTitle = windowTitle;
        this.game = game;
        this.player = game.getPlayer();
        initialize(stage, game);
        buildAndSetGameLoop();
    }

    private void initialize(Stage stage, Game game) {
        this.stage = stage;
        Group root = new Group();
        layer = new Pane();

        int height = game.getWorld().actualDim().height;
        int width = game.getWorld().actualDim().width;
        int sceneWidth = width * Sprite.size;
        int sceneHeight = height * Sprite.size;
        Scene scene = new Scene(root, sceneWidth, sceneHeight + StatusBar.height);
        scene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());

        stage.setTitle(windowTitle);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        input = new Input(scene);
        root.getChildren().add(layer);
        statusBar = new StatusBar(root, sceneWidth, sceneHeight, game);
        // Create decor sprites
        game.getWorld().forEach((pos, d) -> sprites.add(SpriteFactory.createDecor(layer, pos, d)));

        //
        game.getWorld().forEachMovables((pos, go) -> MovableSpriteAdder(pos, go, sprites));
        spritePlayer = SpriteFactory.createPlayer(layer, player);

    }

    /*Au moment de l'initialisation des objets qui bougent (player, box,collectables,monstres..)
     * le sprite de player est déjà déclaré à part dans le code de base. Afin d'éviter les conflits il ne faut
     * pas le redéclarer dans la liste des sprites, or notre player est dans la Map movables.
     * cette fonction sert donc à éviter de redéclarer le player dans la liste des sprites*/
    public static Sprite  MovableSpriteAdder(Position pos, GameObject go, List<Sprite> sprt) {
        if (!(go instanceof Player)) {
            Sprite sprite =SpriteFactory.createMovables(layer, pos, go);
            sprt.add((sprite));
            return sprite;
        }
        return null;

    }

    protected final void buildAndSetGameLoop() {
        gameLoop = new AnimationTimer() {
            public void handle(long now) {
                // Check keyboard actions
                processInput(now);

                // Do actions
                update(now);

                // Graphic update
                render();
                statusBar.update(game);
                
            }
        };
    }

    private void processInput(long now) {
        if (input.isExit()) {
            gameLoop.stop();
            Platform.exit();
            System.exit(0);
        }
        if (input.isMoveDown()) {
            player.requestMove(Direction.S);
        }
        if (input.isMoveLeft()) {
            player.requestMove(Direction.W);
        }
        if (input.isMoveRight()) {
            player.requestMove(Direction.E);
        }
        if (input.isMoveUp()) {
            player.requestMove(Direction.N);
        }
        if (input.isKey()){
            Position pos = player.getDirection().nextPosition(player.getPosition());
            World world = game.getWorld();
            GameObject mov = world.returnMovable(pos);
            if(mov instanceof Door_Next_Closed){
                if(player.getKey() != 0){
                    player.setKey(player.getKey()-1);
                    world.RemoveMovable(mov);
                    Door_Next_Open door = new Door_Next_Open(game, pos);
                    world.SetMovable(pos,door);
                    for (int i = 0; i<this.sprites.size(); i++){
                        Sprite u =this.sprites.get(i);
                       if (u instanceof SpriteDoor_N_Closed){
                            this.sprites.set(i,new SpriteDoor_N_Open(layer,ImageFactory.getInstance().get(ImageResource.DOPEN),door));
                        }
                    }
                }
            }
        }
        if (input.isBomb()){
            Position Ppos= player.getPosition();
            if (game.getPlayer().getNumberBomb() >0){
                Bomb bomb = new Bomb(game,Ppos);
                player.addbomb(bomb);
                Sprite sprtbomb =  MovableSpriteAdder(Ppos,bomb,sprites);
            }
        }
        input.clear();
    }

    private void showMessage(String msg, Color color) {
        Text waitingForKey = new Text(msg);
        waitingForKey.setTextAlignment(TextAlignment.CENTER);
        waitingForKey.setFont(new Font(60));
        waitingForKey.setFill(color);
        StackPane root = new StackPane();
        root.getChildren().add(waitingForKey);
        Scene scene = new Scene(root, 400, 200, Color.WHITE);
        stage.setTitle(windowTitle);
        stage.setScene(scene);
        input = new Input(scene);
        stage.show();
        new AnimationTimer() {
            public void handle(long now) {
                processInput(now);
            }
        }.start();
    }


    private void update(long now) {
        player.update(now);
        int nlvl;
        if ((nlvl = player.isChangingLevel()) != 0) {
            game.getWorld().ChangeLevel(nlvl, player);
            player.resetLvl();
            this.initialize(stage, game);
            statusBar.update(game);
        }
        if (player.isAlive() == false) {
            gameLoop.stop();
            showMessage("Perdu!", Color.RED);
        }
        if (player.isWinner()) {
            gameLoop.stop();
            showMessage("Gagné", Color.BLUE);
        }
        //Debug dégueu
        //System.out.println(game.getWorld().getMovables());
        //Update des monstres
        game.getWorld().monsterList().forEach(go -> go.update(now));
        
    }


    

    private void render() {
        sprites.forEach(Sprite::render);
        // last rendering to have player in the foreground
        spritePlayer.render();
    }

    public void start() {
        gameLoop.start();
    }

    public static List<Sprite> getSprite() {
        return sprites;
    }
    public static Pane getLayer(){
        return layer;
    }

    public static void RemoveSprite(Sprite sprite) {
        for (int i = 0; i < sprites.size(); i++) {
            Sprite u = sprites.get(i);
            if (u.getClass() == sprite.getClass() && u.getPosition() == sprite.getPosition()) {
                sprites.get(i).remove();
                sprites.remove(i);
            }
        }
    }

}