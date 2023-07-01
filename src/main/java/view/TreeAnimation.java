package view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.List;

public class TreeAnimation extends Application {
    Pane pane;
    List<StackPane> imageSelected;
    public int index=0;
    private ImageView imageView;
    public TreeAnimation(Pane pane1,ImageView imageView){
        this.pane=pane1;
        this.imageView=imageView;

    }
    @Override
    public void start(Stage stage) throws Exception {

            //ImageView imageView = new ImageView();
            imageView.setFitWidth(100);
            imageView.setFitHeight(100);
            Image[] fireFrames = new Image[100];
            for (int j = 0; j < fireFrames.length; j++) {
                fireFrames[j] = new Image(Fire.class.getResource("/appletree/0_0img" + j + ".png").toString());
            }

            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.millis(Math.random()*1000), event -> {
                        int newIndex = (int) (Math.random() * fireFrames.length);
                        imageView.setImage(fireFrames[index]);
                        index++;
                        if(index==100)index=0;

                    })
            );
            timeline.setCycleCount(-1);
            timeline.play();
            pane.getChildren().add(imageView);

        }


}
