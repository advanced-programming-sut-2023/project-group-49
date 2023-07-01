package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ImageMoveWithMouse extends Application {
    private double startXLayout;
    private double startYLayout;
    private Boolean moveCount = true;
    private int moveCount1 = 0;
    private Image image;
    private Pane mainPane;
    private Pane gridPane;
    private Scene mainScene;
    public static ArrayList<ImageView> buildings=new ArrayList<>();
    ImageView imageView;

    public ImageMoveWithMouse(Pane pane,Pane gridPane, Scene scene, Image image1, double startXLayout1, double startYLayout1) {
        this.mainPane = pane;
        this.gridPane=gridPane;
        this.mainScene = scene;
        this.image = image1;
        this.startXLayout = startXLayout1;
        this.startYLayout = startYLayout1;
    }

    @Override
    public void start(Stage primaryStage) {
         imageView = new ImageView(image);
        buildings.add(imageView);
        imageView.setFitWidth(60);
        imageView.setFitHeight(60);
        imageView.setLayoutX(startXLayout);
        imageView.setLayoutY(startYLayout);
        imageView.setOnMousePressed(mouseEvent -> {
            moveCount1++;
            if(moveCount1==1){
                if(imageView.getImage().getUrl().equals(new Image(ImageMoveWithMouse.class.getResource("/appletree/0_0img73.png").toString()).getUrl())){
                    TreeAnimation treeAnimation1=new TreeAnimation(mainPane,imageView);
                    try {
                        treeAnimation1.start(primaryStage);
                    } catch (Exception e) {
                        //TODO:handle
                    }
                }
            }
            if(moveCount1==2){
                moveCount=false;

            }
        });

        imageView.setOnMouseDragged(event -> {
              if(moveCount) {
                  double offsetX = event.getSceneX();
                  double offsetY = event.getSceneY();
                  imageView.setLayoutX(offsetX);
                  imageView.setLayoutY(offsetY);
              }

        });

        mainPane.getChildren().add(imageView);


    }

    public static void main(String[] args) {
        launch(args);
    }

    public ImageView getImageView() {
        return imageView;
    }
}

