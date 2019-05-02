package javaFX;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class DepositPage {
    private Scene depositScene;
    private Button backButton;

    public Scene getDepositScene() {
        return depositScene;
    }

    public void setDepositScene(Scene depositScene) {
        this.depositScene = depositScene;
    }

    public Button getBackButton() {
        return backButton;
    }

    public DepositPage(){
        GridPane depositLayout = new GridPane();
        depositLayout.setAlignment(Pos.CENTER);
        depositLayout.setVgap(10);
        depositScene = new Scene(depositLayout,640,480);
        depositLayout.setStyle("-fx-background-image: url('file:assets/dolphin.png')");

        //creating deposit headline/label and adding it to GridPane layout
        Label header = new Label("Deposit a payment");
        depositLayout.getChildren().add(header);
        GridPane.setConstraints(header,0,0);

        //setting up a back button, to return to menu
        backButton = new Button("Back");
        depositLayout.getChildren().add(backButton);
        GridPane.setConstraints(backButton,10,10);
    }
}
