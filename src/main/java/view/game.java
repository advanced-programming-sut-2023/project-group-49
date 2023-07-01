package view;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;

public class game extends Application {
    @FXML
    public TextField textfield;
    private Rectangle selectionRect;
    private Point2D dragStart;
    private List<StackPane> selectedImages = new ArrayList<>();
    public HashMap<Integer, Integer> cost = new HashMap<>();
    public GridPane gridPane1;
    public Pane mainPane;
    public int imageNumber = 1;
    public int goldValue = 0;
    public ArrayList<TextField> marketTextFields = new ArrayList<>();

    @Override
    public void start(Stage stage) throws IOException {
        Random random = new Random();
        Pane main = new Pane();
        mainPane = main;
        GridPane gridPane = new GridPane();
        GridPane gridPane2 = new GridPane();

        gridPane1 = gridPane2;
        gridPane.setPadding(new Insets(10));
        Scene scene = new Scene(main, 800, 650);
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(gridPane);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        for (int i = 0; i < 900; i++) {
            int number = random.nextInt(5);
            Image image = new Image(game.class.getResource("/images2/" + number + ".jpg").toString());
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(image.getWidth());
            imageView.setFitHeight(image.getHeight());

            Rectangle border = new Rectangle(image.getWidth() - 3, image.getHeight() - 3);
            border.setFill(null);
            border.setStroke(Color.RED);
            border.setStrokeWidth(3);
            border.setVisible(false);
            Tooltip tooltip = new Tooltip("Image details go here");

            imageView.setOnMouseEntered(event -> {
                Point2D p = imageView.localToScreen(imageView.getLayoutBounds().getMaxX(),
                        imageView.getLayoutBounds().getMaxY());
                tooltip.show(imageView, p.getX(), p.getY());

            });

            imageView.setOnMouseExited(event -> {
                tooltip.hide();
            });

            StackPane stackPane = new StackPane(imageView, border);
            stackPane.setOnMouseClicked(mouseEvent -> {
                border.setVisible(!border.isVisible());

            });

            gridPane2.add(stackPane, i % 40, i / 40); // row index = i/10, column index = i%10


        }

        gridPane.getChildren().add(gridPane2);


        Image bottom = new Image(game.class.getResource("/images2/bottomMenu.png").toString());
        ImageView bottomImage = new ImageView(bottom);
        bottomImage.setFitWidth(1000);
        bottomImage.setFitHeight(150);
        StackPane fixedImagePane = new StackPane(bottomImage);
        VBox parentPane = new VBox();
        parentPane.setStyle("-fx-background-color: black;");
        Button market = new Button("market");
        market.setStyle("-fx-background-color: #904a2c");
        market.setLayoutY(500);
        parentPane.getChildren().addAll(scrollPane, fixedImagePane);
        Button fire = new Button("fire");
        fire.setStyle("-fx-background-color: #904a2c");
        fire.setLayoutY(500);
        parentPane.setMaxSize(800, 650);
        main.getChildren().addAll(parentPane, market, fire);
        fire.setLayoutX(100);
        fire.setOnMouseClicked(mouseEvent -> {
            Fire fire1 = new Fire(main, selectedImages);
            try {
                fire1.start(stage);
            } catch (Exception e) {
              //TODO:handle
            }

        });
        ///////////////////////////////////////////////////////////////////fixedImage


        ImageView bottomMenuImage = new ImageView(new Image(game.class.getResource("/images2" +
                "/castle.jpg").toString()));
        bottomMenuImage.setFitHeight(90);
        bottomMenuImage.setFitWidth(350);
        main.getChildren().add(bottomMenuImage);
        bottomMenuImage.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                double x = mouseEvent.getX();
                double y = mouseEvent.getY();
                if (bottomMenuImage.getImage().getUrl().equals(new Image(game.class.getResource
                        ("/images2/castle.jpg").toString()).getUrl())) {
                    if (x > 204 && x < 236 && y > 31 && y < 58) {
                        Image image1 = new Image(game.class.getResource("/Building/Barracks.png").toString());
                        ImageMoveWithMouse imageMoveWithMouse = new ImageMoveWithMouse(main, gridPane, scene, image1,
                                415, 580);
                        imageMoveWithMouse.start(stage);

                    } else if (x > 260 && x < 289 && y > 31 && y < 54) {
                        Image image1 = new Image(game.class.getResource("/Building/barracks3.png").toString());
                        ImageMoveWithMouse imageMoveWithMouse = new ImageMoveWithMouse(main, gridPane, scene, image1,
                                470, 580);
                        imageMoveWithMouse.start(stage);
                    } else if (x > 316 && x < 346 && y > 28 && y < 60) {
                        Image image1 = new Image(game.class.getResource("/Building/castle1.png").toString());
                        ImageMoveWithMouse imageMoveWithMouse = new ImageMoveWithMouse(main, gridPane, scene, image1,
                                520, 580);
                        imageMoveWithMouse.start(stage);
                    }
                }
                else if (bottomMenuImage.getImage().getUrl().equals(new Image(game.class.getResource(
                        "/images1/SmartSelect_20230628_104246_Gallery.jpg").toString()).getUrl())){
                    if (x > 305 && x < 333 && y > 32 && y < 56) {
                        Image image1 = new Image(game.class.getResource("/Building/Market.png").toString());
                        ImageMoveWithMouse imageMoveWithMouse = new ImageMoveWithMouse(main, gridPane, scene, image1,
                                495, 580);
                        imageMoveWithMouse.start(stage);

                    }

                }
                else if (bottomMenuImage.getImage().getUrl().equals(new Image(game.class.getResource("/images1/" +
                        "SmartSelect_20230628_104328_Gallery.jpg").toString()).getUrl())){
                    if (x > 155 && x < 188 && y > 18 && y < 47) {
                        Image image1 = new Image(game.class.getResource("/appletree/0_0img73.png").toString());
                        ImageMoveWithMouse imageMoveWithMouse = new ImageMoveWithMouse(main, gridPane, scene, image1,
                                370, 555);
                        imageMoveWithMouse.start(stage);


                    }

                }
                System.out.println(x + "  " + y);
            }
        });

        bottomMenuImage.setLayoutY(553);
        bottomMenuImage.setLayoutX(220);
        ImageView castleIcon = new ImageView(new Image(game.class.getResource("/icon/castle-removebg" +
                "-preview.png").toString()));
        castleIcon.setOnMouseClicked(mouseEvent -> {
            bottomMenuImage.setImage(new Image(game.class.getResource("/images2/castle.jpg").toString()));
        });

        castleIcon.setFitHeight(35);
        castleIcon.setFitWidth(35);
        ImageView imageView2 = new ImageView(new Image(game.class.getResource("/icon" +
                "/repair building.png").toString()));
        imageView2.setOnMouseClicked(mouseEvent -> {
            bottomMenuImage.setImage(new Image(game.class.getResource("/images1/" +
                    "SmartSelect_20230628_104246_Gallery.jpg").toString()));
        });
        ImageView treeIcon = new ImageView(new Image(game.class.getResource("/icon" +
                "/plant woods.png").toString()));
        treeIcon.setOnMouseClicked(mouseEvent -> {
            bottomMenuImage.setImage(new Image(game.class.getResource("/images1/" +
                    "SmartSelect_20230628_104328_Gallery.jpg").toString()));
        });
        ImageView homeIcon = new ImageView(new Image(game.class.getResource("/icon" +
                "/home-removebg-preview.png").toString()));
        homeIcon.setOnMouseClicked(mouseEvent -> {
            bottomMenuImage.setImage(new Image(game.class.getResource("/images1" +
                    "/SmartSelect_20230628_104353_Gallery.jpg").toString()));
        });
        homeIcon.setFitWidth(35);
        homeIcon.setFitHeight(35);
        ImageView imageView3 = new ImageView(new Image(game.class.getResource("/icon" +
                "/fortify.png").toString()));
        imageView3.setOnMouseClicked(mouseEvent -> {
            bottomMenuImage.setImage(new Image(game.class.getResource("/images1/" +
                    "SmartSelect_20230628_104421_Gallery.jpg").toString()));
        });
        ImageView imageView4 = new ImageView(new Image(game.class.getResource("/icon" +
                "/clear land.png").toString()));
        imageView4.setOnMouseClicked(mouseEvent -> {
            bottomMenuImage.setImage(new Image(game.class.getResource("/images1/" +
                    "SmartSelect_20230628_104441_Gallery.jpg").toString()));
        });
        HBox bottomIcon = new HBox(castleIcon, imageView2, treeIcon, homeIcon, imageView3, imageView4);
        bottomIcon.setLayoutY(620);
        bottomIcon.setLayoutX(220);
        ImageView undoAndDeleteImage = new ImageView(new Image(game.class.getResource
                ("/icon/undo-delete icon.jpg").toString()));
        undoAndDeleteImage.setLayoutY(550);
        undoAndDeleteImage.setLayoutX(775);
        undoAndDeleteImage.setFitHeight(105);
        undoAndDeleteImage.setFitWidth(25);
        Button undo = new Button();
        undo.setStyle("-fx-opacity: 0;");
        undo.setMaxSize(5, 5);
        undo.setOnMouseClicked(mouseEvent -> {
            try {
                main.getChildren().remove(ImageMoveWithMouse.buildings.get(ImageMoveWithMouse.buildings.size() - 1));
                ImageMoveWithMouse.buildings.remove(ImageMoveWithMouse.buildings.size() - 1);

            } catch (IndexOutOfBoundsException e) {
                //TODO:handle
            }


        });

        bottomImage.setOnMouseClicked(mouseEvent -> {
            for (ImageView building : ImageMoveWithMouse.buildings) {
                building.setOnMouseClicked(mouseEvent1 -> {
                    ;
                });
            }
        });
        Button delete = new Button();
        delete.setStyle("-fx-opacity: 0;");
        delete.setMaxSize(5, 5);

        delete.setOnMouseClicked(mouseEvent -> {
            for (ImageView building : ImageMoveWithMouse.buildings) {
                building.setOnMouseClicked(mouseEvent1 -> {
                    main.getChildren().remove(building);
                    ImageMoveWithMouse.buildings.remove(building);
                });
            }
        });
        VBox undoAndDeleteButton = new VBox(delete, undo);
        undoAndDeleteButton.setLayoutX(775);
        undoAndDeleteButton.setLayoutY(610);
        undoAndDeleteButton.setMaxSize(20, 20);
        main.getChildren().addAll(bottomIcon, undoAndDeleteImage, undoAndDeleteButton);

        ////////////////////////////////////////////////////////////////////////////market

        Button nextItem = new Button();
        nextItem.setStyle("-fx-opacity: 0;");
        nextItem.setLayoutY(555);
        nextItem.setLayoutX(280);
        Button previousItem = new Button();
        previousItem.setStyle("-fx-opacity: 0;");
        previousItem.setLayoutY(555);
        previousItem.setLayoutX(250);
        TextField gold = new TextField();
        gold.setPromptText("gold:");
        gold.setLayoutX(490);
        gold.setLayoutY(575);
        gold.setMaxWidth(50);
        Button okGoldValue = new Button("ok");
        okGoldValue.setLayoutX(540);
        okGoldValue.setLayoutY(575);
        Button buy = new Button();
        buy.setStyle("-fx-opacity: 0;");
        buy.setLayoutY(565);
        buy.setLayoutX(340);
        buy.setMinWidth(140);
        Button sell = new Button();
        sell.setStyle("-fx-opacity: 0;");
        sell.setMinWidth(140);
        sell.setLayoutX(340);
        sell.setLayoutY(600);
        Button exitMarket = new Button();
        exitMarket.setLayoutY(620);
        exitMarket.setLayoutX(235);
        exitMarket.setStyle("-fx-opacity: 0;");
        Pane marketButton = new Pane(nextItem, previousItem, gold, okGoldValue, buy, sell, exitMarket);
        cost.put(1, 40);
        cost.put(2, 40);
        cost.put(3, 40);
        cost.put(4, 40);
        cost.put(5, 115);
        cost.put(6, 20);
        cost.put(7, 70);
        cost.put(8, 225);
        cost.put(9, 100);
        cost.put(10, 100);
        cost.put(11, 290);
        cost.put(12, 290);
        cost.put(13, 180);
        cost.put(14, 290);
        cost.put(15, 125);
        cost.put(16, 290);
        cost.put(17, 100);
        cost.put(18, 75);
        market.setOnMouseClicked(mouseEvent -> {
            bottomMenuImage.setImage(new Image(game.class.getResource("/images1/market.jpg").toString()));
            for (int i = 1; i < 19; i++) {
                TextField textField = createTextfield(String.valueOf(i));
            }
            main.getChildren().remove(bottomIcon);
            bottomMenuImage.setImage(new Image(game.class.getResource("/market/" +
                    "1.jpg").toString()));
            main.getChildren().addAll(marketButton, getTextfieldById("1"));
        });
        exitMarket.setOnMouseClicked(mouseEvent -> {

            main.getChildren().removeAll(marketButton, getTextfieldById(String.valueOf(imageNumber)), getTextfieldById("1"));

            bottomMenuImage.setImage(new Image(game.class.getResource("/images2" +
                    "/castle.jpg").toString()));
            main.getChildren().add(bottomIcon);

        });
        buy.setOnMouseClicked(mouseEvent -> {
            TextField marketTextField = getTextfieldById(String.valueOf(imageNumber));
            try {
                if (Integer.parseInt(gold.getText()) < cost.get(imageNumber)) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error");
                    alert.setContentText("gold is not enough!");
                    alert.showAndWait();
                } else {
                    gold.setText(String.valueOf(Integer.parseInt(gold.getText()) - cost.get(imageNumber)));
                    marketTextField.setText(String.valueOf(Integer.parseInt(marketTextField.getText()) + 1));

                }

            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setContentText("invalid format: please write number");
                alert.showAndWait();
            }

        });
        sell.setOnMouseClicked(mouseEvent -> {
            for (TextField textField : marketTextFields) {
                if(textField.getId().equals(String.valueOf(imageNumber))) {
                    if (Objects.equals(textField.getText(), "0")) {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Error");
                        alert.setContentText("you can't sell!");
                        alert.showAndWait();

                    } else {
                        textField.setText(String.valueOf(Integer.parseInt(textField.getText()) - 1));
                    }
                }
            }
            try {
                switch (imageNumber) {
                    case 6:
                        gold.setText(String.valueOf(Integer.parseInt(gold.getText()) + 10));
                        break;
                    case 7:
                        gold.setText(String.valueOf(Integer.parseInt(gold.getText()) + 70));
                        break;
                }
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setContentText("invalid format: please write number");
                alert.showAndWait();
            }

        });
        okGoldValue.setOnMouseClicked(mouseEvent -> {
            try {
                goldValue = Integer.parseInt(gold.getText());
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error");
                alert.setContentText("invalid format: please write number");
                alert.showAndWait();
            }


        });

        nextItem.setOnMouseClicked(mouseEvent -> {
            if (imageNumber != 18) {
                imageNumber++;
                bottomMenuImage.setImage(new Image(game.class.getResource("/market/" +
                        imageNumber + ".jpg").toString()));
            } else {
                imageNumber = 1;
                bottomMenuImage.setImage(new Image(game.class.getResource("/market/" +
                        imageNumber + ".jpg").toString()));
            }
            if (imageNumber != 1)
                main.getChildren().remove(getTextfieldById(String.valueOf(imageNumber - 1)));
            if (imageNumber == 1)
                main.getChildren().remove(getTextfieldById(String.valueOf(18)));

            main.getChildren().add(getTextfieldById(String.valueOf(imageNumber)));

        });
        previousItem.setOnMouseClicked(mouseEvent -> {
            if (imageNumber != 1) {
                imageNumber--;
                bottomMenuImage.setImage(new Image(game.class.getResource("/market/" +
                        imageNumber + ".jpg").toString()));
            } else {
                imageNumber = 18;
                bottomMenuImage.setImage(new Image(game.class.getResource("/market/" +
                        imageNumber + ".jpg").toString()));
            }
            if (imageNumber != 18)
                main.getChildren().remove(getTextfieldById(String.valueOf(imageNumber + 1)));
            if (imageNumber == 18)
                main.getChildren().remove(getTextfieldById(String.valueOf(1)));

            main.getChildren().add(getTextfieldById(String.valueOf(imageNumber)));

        });
        /////////////////////////////////////////////////////////////////////////////////////////////////////
        bottomImage.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                double x = mouseEvent.getX();
                double y = mouseEvent.getY();
                Button popularityButton = new Button("Popularity");
                Button fearFactorButton = new Button("Fear Factor");
                Button back = new Button();
                back.setLayoutX(230);
                back.setLayoutY(620);
                back.setStyle("-fx-opacity: 0;");
                Button next = new Button("");
                next.setLayoutY(550);
                next.setLayoutX(550);
                next.setStyle("-fx-opacity: 0;");
                Button population = new Button("Population");
                Button food = new Button("Food");
                VBox firstRaw = new VBox(popularityButton, fearFactorButton, population, food);
                toolbarMethod(firstRaw);
                Button army = new Button("Army");
                Button stores = new Button("Stores");
                Button weapons = new Button("Weapons");
                Button religion = new Button("Religion");
                VBox secondRaw = new VBox(army, stores, weapons, religion);
                toolbarMethod(secondRaw);
                ImageView imageView5 = new ImageView(new Image(game.class.getResource("/images1/" +
                        "SmartSelect_20230628_104540_Gallery.jpg").toString()));
                imageView5.setFitHeight(95);
                imageView5.setFitWidth(150);
                Button backMapMenu = new Button("back");

                HBox mainHbox = new HBox(imageView5, firstRaw, secondRaw, backMapMenu);
                backMapMenu.setOnMouseClicked(mouseEvent1 -> {
                    main.getChildren().remove(mainHbox);
                    main.getChildren().addAll(bottomMenuImage, bottomIcon);
                    bottomMenuImage.setImage(new Image(game.class.getResource("/images2" +
                            "/castle.jpg").toString()));
                });
                mainHbox.setSpacing(10);
                if (x > 578 && x < 690 && y > 82 && y < 138) {

                    main.getChildren().removeAll(bottomMenuImage, bottomIcon, marketButton);
                    popularityButton.setOnMouseClicked(mouseEvent1 -> {
                        popularityClicked();
                    });

                    back.setOnMouseClicked(mouseEvent1 -> {
                        main.getChildren().removeAll(bottomMenuImage, back, next);
                    });
                    fearFactorButton.setOnMouseClicked(mouseEvent2 -> {
                        bottomMenuImage.setImage(new Image(game.class.getResource("/images1/" +
                                "SmartSelect_20230628_105212_Gallery.jpg").toString()));
                        main.getChildren().addAll(bottomMenuImage, back);

                    });

                    population.setOnMouseClicked(mouseEvent1 -> {
                        bottomMenuImage.setImage(new Image(game.class.getResource("/images1/" +
                                "SmartSelect_20230628_105238_Gallery.jpg").toString()));
                        main.getChildren().addAll(bottomMenuImage, back);
                    });

                    food.setOnMouseClicked(mouseEvent1 -> {
                        bottomMenuImage.setImage(new Image(game.class.getResource("/images1/" +
                                "SmartSelect_20230628_105258_Gallery.jpg").toString()));
                        main.getChildren().addAll(bottomMenuImage, back);

                    });

                    army.setOnMouseClicked(mouseEvent1 -> {
                        bottomMenuImage.setImage(new Image(game.class.getResource("/images1/" +
                                "SmartSelect_20230628_105325_Gallery.jpg").toString()));
                        next.setOnMouseClicked(mouseEvent2 -> {
                            if (bottomMenuImage.getImage().getUrl().equals(new Image(game.class.
                                    getResource("/images1/SmartSelect_20230628_105325_Gallery.jpg")
                                    .toString()).getUrl()))
                                bottomMenuImage.setImage(new Image(game.class.getResource(
                                        "/images1/SmartSelect_20230628_105343_Gallery.jpg").toString()));
                            else if (bottomMenuImage.getImage().getUrl().equals(new Image(game.class.getResource
                                    ("/images1/SmartSelect_20230628_105343_Gallery.jpg").toString()).getUrl()))
                                bottomMenuImage.setImage(new Image(game.class.getResource("/images1/" +
                                        "SmartSelect_20230628_105406_Gallery.jpg").toString()));
                            else if (bottomMenuImage.getImage().getUrl().equals(new Image(game.class.getResource
                                    ("/images1/SmartSelect_20230628_105406_Gallery.jpg").toString()).getUrl()))
                                bottomMenuImage.setImage(new Image(game.class.getResource("/images1/" +
                                        "SmartSelect_20230628_105325_Gallery.jpg").toString()));

                        });

                        main.getChildren().addAll(bottomMenuImage, back, next);
                    });

                    stores.setOnMouseClicked(mouseEvent1 -> {
                        bottomMenuImage.setImage(new Image(game.class.getResource("/images1/" +
                                "SmartSelect_20230628_105450_Gallery.jpg").toString()));
                        main.getChildren().addAll(bottomMenuImage, back);
                    });

                    weapons.setOnMouseClicked(mouseEvent1 -> {
                        bottomMenuImage.setImage(new Image(game.class.getResource("/images1/" +
                                "SmartSelect_20230628_105511_Gallery.jpg").toString()));
                        main.getChildren().addAll(bottomMenuImage, back);
                    });

                    religion.setOnMouseClicked(mouseEvent1 -> {
                        bottomMenuImage.setImage(new Image(game.class.getResource("/images1/" +
                                "SmartSelect_20230628_105527_Gallery.jpg").toString()));
                        main.getChildren().addAll(bottomMenuImage, back);
                    });

                    main.getChildren().add(mainHbox);
                    mainHbox.setLayoutY(550);
                    mainHbox.setLayoutX(250);
                }
            }

        });
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////select cells
        scrollPane.setOnMousePressed(event -> {

            dragStart = new Point2D(event.getX(), event.getY());
            selectionRect = new Rectangle(dragStart.getX(), dragStart.getY(), 0, 0);
            selectionRect.setFill(Color.TRANSPARENT);
            selectionRect.setStroke(Color.BLUE);
            main.getChildren().add(selectionRect);
            selectedImages.clear();

        });

        gridPane.setOnMouseDragged(mouseEvent -> {
            try {
                double x = Math.min(mouseEvent.getX(), dragStart.getX());
                double y = Math.min(mouseEvent.getY(), dragStart.getY());
                double width = Math.abs(mouseEvent.getX() - dragStart.getX());
                double height = Math.abs(mouseEvent.getY() - dragStart.getY());
                selectionRect.setX(x);
                selectionRect.setY(y);
                selectionRect.setWidth(width);
                selectionRect.setHeight(height);
                selectImages();
            } catch (NullPointerException e) {

            }

        });

        scrollPane.setOnMouseReleased(event -> {

            main.getChildren().remove(selectionRect);
            selectionRect = null;

        });


        //////////////////////////////////////////////////////
        gridPane.setOnScroll(event -> {
            double deltaY = event.getDeltaY();
            double scale = gridPane.getScaleX();
            if (deltaY < 0) {
                scale /= 1.1;
            } else {
                scale *= 1.1;
            }
            scale = Math.min(Math.max(scale, 1), 10.0);

            gridPane.setScaleX(scale);
            gridPane.setScaleY(scale);

            event.consume();
        });
        Scale scale = new Scale(1, 1);
        gridPane.getTransforms().add(scale);
        scrollPane.setOnZoom(event -> {
            double zoomFactor = event.getZoomFactor();
            scale.setX(scale.getX() * zoomFactor);
            scale.setY(scale.getY() * zoomFactor);
            event.consume();
        });
        KeyCombination ctrlC = new KeyCodeCombination(KeyCode.C, KeyCombination.CONTROL_DOWN);
        KeyCombination ctrlV = new KeyCodeCombination(KeyCode.V, KeyCombination.CONTROL_DOWN);
        scrollPane.setOnKeyPressed(event -> {
            double deltaX = 0;
            double deltaY = 0;

            switch (event.getCode()) {
                case UP:
                    deltaY = +10;
                    break;
                case DOWN:
                    deltaY = -10;
                    break;
                case LEFT:
                    deltaX = -10;
                    break;
                case RIGHT:
                    deltaX = 10;
                    break;
                default:
                    break;
            }
            if (ctrlC.match(event)) {
                System.out.println("Copying...");
                for(ImageView imageView:ImageMoveWithMouse.buildings){
                    imageView.setOnMouseClicked(mouseEvent -> {
                       copyImageToClipboard(imageView);
                    });
                }
                // Add your own logic here for handling the shortcut
            }
            if (ctrlV.match(event)) {
                System.out.println("Copying...");
                main.setOnMouseClicked(mouseEvent -> {
                    double x=mouseEvent.getX();
                    double y=mouseEvent.getY();
                    pasteImageFromClipboard(x,y);
                });

                // Add your own logic here for handling the shortcut
            }
            bottomImage.setOnMouseClicked(mouseEvent -> {
                main.setOnMouseClicked(mouseEvent1 -> {
                    ;
                });
            });
            double hValue = scrollPane.getHvalue() - deltaX / scrollPane.getContent().getBoundsInLocal().getWidth();
            double vValue = scrollPane.getVvalue() - deltaY / scrollPane.getContent().getBoundsInLocal().getHeight();
            for (ImageView building : ImageMoveWithMouse.buildings) {
                building.setLayoutX(building.getLayoutX() - deltaX);
                building.setLayoutY(building.getLayoutY() + deltaY);
            }
            scrollPane.setHvalue(hValue);
            scrollPane.setVvalue(vValue);
        });

        stage.setScene(scene);
        stage.show();


    }

    private void toolbarMethod(VBox vBox) {
        for (Node node : vBox.getChildren()) {
            if (node instanceof Button) {
                Button button = (Button) node;
                button.setMaxSize(100, 5);
                ImageView imageView1 = new ImageView(new Image(game.class.getResource
                        ("/images2/BackOfResources.png").toString()));
                imageView1.setFitHeight(5);
                imageView1.setFitWidth(100);
                button.setBackground(new Background(new BackgroundImage(imageView1.getImage(),
                        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                        new BackgroundSize(100, 100, true, true, true, false))));
            }
        }
    }

    private void selectImages() {
        selectedImages.clear();
        for (Node node : gridPane1.getChildren()) {
            if (node instanceof StackPane) {
                StackPane imageView = (StackPane) node;
                if (selectionRect.getBoundsInParent().intersects(imageView.getBoundsInParent())) {
                    selectedImages.add(imageView);
                }
            }
        }
    }

    public List<StackPane> getSelectedImages() {
        return selectedImages;
    }

    public static void main(String[] args) {
        launch();
    }

    public void popularityClicked() {
        Pane book = new Pane();
        mainPane.getChildren().add(book);
        book.setLayoutY(550);
        book.setLayoutX(215);
        ImageView imageView1 = new ImageView(new Image(game.class.getResource
                ("/images2/BackOfResources.png").toString()));
        imageView1.setFitHeight(140);
        imageView1.setFitWidth(360);
        Button back = new Button("back");
        back.setOnMouseClicked(mouseEvent -> {
            mainPane.getChildren().remove(book);
        });
        back.setLayoutX(0);
        back.setLayoutY(80);
        ArrayList<HBox> hBoxes = new ArrayList<HBox>();
        HBox food = createHbox("Food", "0", "food");
        hBoxes.add(food);
        HBox tax = createHbox("Tax", "0", "tax");
        hBoxes.add(tax);
        VBox first = new VBox(food, tax);
        HBox crowding = createHbox("Crowding", "0", "crowding");
        hBoxes.add(crowding);
        HBox fearFactor = createHbox("Fear factor", "0", "fearFactor");
        hBoxes.add(fearFactor);
        VBox second = new VBox(crowding, fearFactor);
        HBox religion = createHbox("Religion", "0", "religion");
        hBoxes.add(religion);
        HBox aleCoverage = createHbox("Ale coverage", "0", "aleCoverage");
        hBoxes.add(aleCoverage);
        VBox third = new VBox(religion, aleCoverage);
        Button chooseValue = new Button("value");
        ArrayList<TextField> textFields = new ArrayList<>();
        TextField Food = createTextField("Food value", "food");
        TextField Tax = createTextField("Tax value", "tax");
        TextField Crowding = createTextField("Crowding value", "crowding");
        TextField FearFactor = createTextField("Fear factor value", "fearFactor");
        TextField Religion = createTextField("Religion value", "religion");
        TextField AleCoverage = createTextField("Ale coverage value", "aleCoverage");
        Button ok = new Button("ok");
        Button close = new Button("close");
        HBox buttons = new HBox(ok, close);
        VBox vBox = new VBox(Food, Tax, Crowding, FearFactor, Religion, AleCoverage, buttons);
        for (Node textField : vBox.getChildren()) {
            if (textField.getClass().equals(TextField.class)) {
                TextField textField1=(TextField)textField;
                textFields.add(textField1);
            }
        }
        ok.setOnMouseClicked(mouseEvent1 -> {
            for (TextField textField : textFields) {
                if (textField.getText().matches("-*[0-9]+")) {
                    for (HBox hBox : hBoxes) {
                        if (textField.getId().equals(hBox.getId())) {
                            if (hBox.getChildren().get(0).getClass().equals(Text.class)) {
                                Text text=(Text)hBox.getChildren().get(0);
                                text.setText(textField.getText());
                                if (textField.getText().matches("-[1-9]+")) {
                                    ImageView imageView = (ImageView) hBox.getChildren().get(1);
                                    imageView.setImage(new Image(game.class.getResource("/icon/sad.jpg").toString()));
                                } else if (textField.getText().matches("[1-9]+")) {
                                    ImageView imageView = (ImageView) hBox.getChildren().get(1);
                                    imageView.setImage(new Image(game.class.getResource("/icon/happy.jpg").toString()));
                                } else if (textField.getText().matches("0")) {
                                    ImageView imageView = (ImageView) hBox.getChildren().get(1);
                                    imageView.setImage(new Image(game.class.getResource("/icon/normal.jpg").toString()));
                                }
                            }

                        }
                    }
                }

            }
        });
        close.setOnMouseClicked(mouseEvent -> {
            mainPane.getChildren().remove(vBox);
        });

        chooseValue.setOnMouseClicked(mouseEvent -> {


            mainPane.getChildren().add(vBox);

        });


        HBox finalHbox = new HBox(first, second, third, chooseValue);
        finalHbox.setSpacing(10);
        finalHbox.setLayoutX(20);
        book.getChildren().addAll(imageView1, back, finalHbox);


    }

    public TextField createTextField(String promptText, String id) {
        TextField textField = new TextField();
        textField.setPromptText(promptText);
        textField.setId(id);

        return textField;
    }

    public HBox createHbox(String name, String valueNumber, String id) {
        Text value = new Text(valueNumber);
        Text Name = new Text(name);
        ImageView face = new ImageView(new Image(game.class.getResource("/icon/normal.jpg").toString()));
        face.setFitWidth(50);
        face.setFitHeight(50);
        HBox hBox = new HBox(value, face, Name);
        hBox.setId(id);
        return hBox;
    }

    public TextField createTextfield(String id) {
        TextField textField = new TextField("0");
        textField.setId(id);
        textField.setLayoutY(580);
        textField.setLayoutX(300);
        textField.setMaxSize(30, 10);
        marketTextFields.add(textField);
        return textField;
    }

    public TextField getTextfieldById(String id) {
        for (TextField textField : marketTextFields) {
            if (textField.getId().equals(id)) {
                return textField;
            }
        }
        return null;
    }
    private void copyImageToClipboard(ImageView imageView) {
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putImage(imageView.getImage());
        clipboard.setContent(content);
    }

    private void pasteImageFromClipboard(double x,double y) {
        Clipboard clipboard = Clipboard.getSystemClipboard();
        Image image = clipboard.getImage();
        ImageView imageView=new ImageView();
        imageView.setFitWidth(60);
        imageView.setFitHeight(60);
        imageView.setLayoutY(y);
        imageView.setLayoutX(x);
        if (image != null) {
            imageView.setImage(image);
            mainPane.getChildren().add(imageView);

        }
    }

}