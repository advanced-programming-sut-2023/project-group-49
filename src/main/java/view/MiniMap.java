package view;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MiniMap extends Application {
//    private Pane pane1;
//    private Pane Map;
//    private ArrayList<Node> nodes;
//    public MiniMap(Pane pane1,Pane pane2){
//        this.pane1=pane1;
//        this.Map=pane2;
//    }

    @Override
    public void start(Stage primaryStage) {
        ImageView imageView=new ImageView(new Image(MiniMap.class.getResource("/icon/castle.png").toString()));
        Pane mainPane = new Pane(imageView);
        mainPane.setPrefSize(400, 400);
        mainPane.setLayoutX(50);
        mainPane.setLayoutY(50);
        Pane miniPane = new Pane();
        miniPane.setPrefSize(100, 100);
        miniPane.setLayoutX(250);
        miniPane.setLayoutY(250);
        ChangeListener<Bounds> paneChangeListener = (observable, oldBounds, newBounds) -> {
            double scaleX = miniPane.getWidth() / mainPane.getWidth();
            double scaleY = miniPane.getHeight() / mainPane.getHeight();
            miniPane.setScaleX(scaleX);
            miniPane.setScaleY(scaleY);
        };

        mainPane.layoutBoundsProperty().addListener(paneChangeListener);
        Group root = new Group( miniPane);
        Scene scene = new Scene(root, 500, 500);
primaryStage.setScene(scene);
primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
