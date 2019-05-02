package javaFX;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class EditPage {
    private Scene editScene;
    private Button backButton;

    public Scene getEditScene() {
        return editScene;
    }

    public void setEditScene(Scene editScene) {
        this.editScene = editScene;
    }

    public Button getBackButton() {
        return backButton;
    }

    public EditPage(){
        GridPane editLayout = new GridPane();
        editLayout.setAlignment(Pos.CENTER);
        editLayout.setVgap(10);
        editScene = new Scene(editLayout,640,480);
        editLayout.setStyle("-fx-background-image: url('file:assets/dolphin.png')");

        //creating edit headline/label and adding it to GridPane layout
        Label header = new Label("Edit a member");
        editLayout.getChildren().add(header);
        GridPane.setConstraints(header,0,0);

        //setting up a back button, to return to menu
        backButton = new Button("Back");
        editLayout.getChildren().add(backButton);
        GridPane.setConstraints(backButton,10,10);
    }
}
