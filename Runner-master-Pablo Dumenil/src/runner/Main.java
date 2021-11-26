/* Pablo Dumenil RUNNER */
package runner;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Runner");
        Group root = new Group();
        Pane pane = new Pane(root);
        GameScene theScene = new GameScene(pane, 600, 400);
        primaryStage.setScene(theScene);
        primaryStage.show();

        theScene.setOnKeyPressed( (event)->{
            theScene.getHero().jump();


        });
    }
    public static void main(String[] args) {
        launch(args);

    }
}
