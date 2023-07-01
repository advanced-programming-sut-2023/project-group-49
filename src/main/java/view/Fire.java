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

public class Fire extends Application {
    Pane pane;
    List<StackPane> imageSelected;
    public int index=0;
    public Fire(Pane pane1, List<StackPane> imageSelected1){
        this.pane=pane1;
        this.imageSelected=imageSelected1;
    }
    @Override
    public void start(Stage stage) throws Exception {
        for(int i=0;i<imageSelected.size();i++) {
            ImageView imageView = new ImageView();
            imageView.setFitWidth(70);
            imageView.setFitHeight(70);
            imageView.setLayoutY(imageSelected.get(i).getLayoutY()-40);
            imageView.setLayoutX(imageSelected.get(i).getLayoutX()-40);
            Image[] fireFrames = new Image[40];
            for (int j = 0; j < fireFrames.length; j++) {
                fireFrames[j] = new Image(Fire.class.getResource("/Fire/0_0img" + j + ".png").toString());
            }

            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.millis(Math.random()*500), event -> {
                        int newIndex = (int) (Math.random() * fireFrames.length);
                        imageView.setImage(fireFrames[index]);
                        index++;
                        if(index==40)index=0;

                    })
            );
            timeline.setCycleCount(-1);
            timeline.play();
            pane.getChildren().add(imageView);

        }

    }
}
