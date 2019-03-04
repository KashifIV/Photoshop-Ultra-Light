package ImageScraper;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ImageScraperView {
    ArrayList<Image> images = new ArrayList<Image>();
    ArrayList<ImageView> imageView = new ArrayList<ImageView>();
    int numOfSearchResults = 100;
    int numOfPicturesDiplayed =10;
    public static ScrollPane scroll = new ScrollPane();
    public void loadImage(String textField)throws IOException {
        ArrayList<String> googleImagesLinks = ImageScraper.getImageArray(textField, numOfSearchResults);
        for (int i = 0; i<numOfPicturesDiplayed; i++) {
            images.add(new Image(googleImagesLinks.get(i)));
            System.out.println(images.get(i).errorProperty());
        }
        int numErros=0;
        for (int j = 0; j < images.size(); j++) {
            if(images.get(j).isError()) {
                images.remove(j);
                numErros++;
            }
        }
        System.out.println(numErros+ " Broken Pics");
        for (int i = 0; i < images.size(); i++) {
            imageView.add(new ImageView(images.get(i)));
            imageView.get(i).setFitHeight(1000);
            imageView.get(i).setFitWidth(500);
            imageView.get(i).setPreserveRatio(true);
            imageView.get(i).setCache(true);
        }
    }
    public void googleImageView(){
        final TextField textField = new TextField();
        Button btn = new Button("Search");



        final FlowPane flowPane = new FlowPane();
        flowPane.setPadding(new Insets(5, 5, 5, 5));
        flowPane.setVgap(5);
        flowPane.setHgap(5);
        flowPane.setPrefWrapLength(5);
        flowPane.setAlignment(Pos.CENTER);
        flowPane.getChildren().add(textField);
        flowPane.getChildren().add(btn);
        btn.setOnAction(e-> {

                try {
                    images.clear();
                    imageView.clear();
                    loadImage(textField.getText());
                    for (int i = 0; i < imageView.size(); i++) {
                        flowPane.getChildren().add(imageView.get(i));
                    }
                }
                catch (IOException ex){

                }

        });

        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scroll.setContent(flowPane);


    }
}
