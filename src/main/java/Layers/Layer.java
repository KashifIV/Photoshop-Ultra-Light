package Layers;

import Main.EditingView;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.opencv.core.Point;

/*
    This is the Layer Superclass, all Layer's must inherit from this class.

    The main focus of this class is to provide information for the Layer View to
    construct the layer panel. It additionally holds skeleton functions which is
    recommended for each inherited object to override.
 */

public class Layer {

    // Layer Information
    public String name;
    protected Boolean isVisible, isSelected;
    protected LayerType layerType;
    protected Point location;

    //Layer Display in Layer Panel
    GridPane pane;
    Pane thumbnail;
    CheckBox visiblityCheckbox;
    Label title;

    //The name of the layer is required.
    public Layer(String name){
        this.name = name;
        layerType = LayerType.EMPTY;
        location = new Point(0,0);
        isSelected = false;
        isVisible = true;
    }

    //Create the Layer Box objects to be rendered in the Layers panel.
    private void generateLayer(){
        pane = new GridPane();
        pane.setPadding(new Insets(20));
        thumbnail = getThumbnail();
        visiblityCheckbox = new CheckBox();
        visiblityCheckbox.setSelected(true);
        visiblityCheckbox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                isVisible = newValue;
                EditingView.Render();
            }
        });
        pane.add(visiblityCheckbox, 0, 0);
        pane.add(thumbnail, 1, 0);
        title = new Label(this.name);
        pane.add(title, 2, 0);
        pane.setStyle("-fx-background-color:#323232; -fx-opacity:1;");
    }
    //Limit Discarding the constructed layer upon reconstruction
    private void updateLayer(){
        if (title == null)
            title = new Label(this.name);
        title.setText(name);
    }
    //Custom Thumbnail for each Layer
    protected Pane getThumbnail(){
        Pane pane = new Pane();
        if (layerType == LayerType.SOLID) pane.getChildren().add(new Rectangle(20, 20, Color.BLACK));
        else if (layerType == LayerType.IMAGE) pane.getChildren().add( new Rectangle(20, 20, Color.NAVY));
        else if(layerType == LayerType.PAINT) pane.getChildren().add(new Rectangle(20, 20, Color.BLUE));
        else if (layerType == LayerType.TEXT)pane.getChildren().add(new Rectangle(20, 20, Color.BLACK));
        else{
            pane.getChildren().add(new Rectangle(20, 20, Color.RED));
        }
        return pane;
    }

    //Get the LayerBox needed for the Layers Panel
    public GridPane getLayerView(){
        if (pane == null)
            generateLayer();
        else updateLayer();
        return pane;
    }

    //Get the pane of the layer. Used primarily by the renderer.
    public Pane getLayer(){return null;}
    public void undo(){
        System.out.println("FAILED TO UNDO");
        return;
    }

    //Handle when the layer is selected
    public void selectLayer(){
        isSelected = true;
        pane.setStyle("-fx-background-color:#5AA4FF; -fx-opacity:1;");
    }
    //Handle when the layer loses its selection
    public void unselectLayer(){
        isSelected = false;
        pane.setStyle("-fx-background-color:#323232; -fx-opacity:1;");
    }

    //It is recommended the following functions are overriden by the
    // inherited classes.
    public void rotate(double degrees){
        return;
    }
    public void crop(Point start, Point end){
        return;
    }
    public void setLocation(Point p){
        location = p;
    }
    public void resize(double size){return;}
    public Point getLocation(){
        return location;
    }
    public LayerType getType(){
        return layerType;
    }
}
