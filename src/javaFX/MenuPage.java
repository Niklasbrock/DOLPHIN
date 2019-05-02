package javaFX;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.*;

public class MenuPage {
    private Button menuCreateButton;
    private Button menuEditButton;
    private Button menuDepositButton;
    private Button menuViewButton;
    private Button menuExitButton;
    private Scene menuScene;

    public Scene getMenuScene() {
        return menuScene;
    }

    public void setMenuScene(Scene menuScene) {
        this.menuScene = menuScene;
    }

    public Button getMenuCreateButton() {
        return menuCreateButton;
    }

    public void setMenuCreateButton(Button menuCreateButton) {
        this.menuCreateButton = menuCreateButton;
    }

    public Button getMenuEditButton() {
        return menuEditButton;
    }

    public void setMenuEditButton(Button menuEditButton) {
        this.menuEditButton = menuEditButton;
    }

    public Button getMenuDepositButton() {
        return menuDepositButton;
    }

    public void setMenuDepositButton(Button menuDepositButton) {
        this.menuDepositButton = menuDepositButton;
    }

    public Button getMenuViewButton() {
        return menuViewButton;
    }

    public void setMenuViewButton(Button menuViewButton) {
        this.menuViewButton = menuViewButton;
    }

    public Button getMenuExitButton() {
        return menuExitButton;
    }

    public MenuPage() throws Exception{
        GridPane menuLayout = new GridPane();
        menuLayout.setAlignment(Pos.CENTER);
        menuLayout.setVgap(10);
        menuLayout.setStyle("-fx-background-image: url('file:assets/dolphin.png')");
        menuScene = new Scene(menuLayout, 640, 480);
        //creating menu buttons; giving them appropriate text and adding them to GridPane layout
        menuCreateButton = new Button();
        menuEditButton = new Button();
        menuDepositButton = new Button();
        menuViewButton = new Button();
        menuExitButton = new Button();
        menuCreateButton.setText("Create");
        menuEditButton.setText("Edit");
        menuDepositButton.setText("Deposit");
        menuViewButton.setText("View");
        menuExitButton.setText("Exit Application");
        menuLayout.getChildren().add(menuCreateButton);
        menuLayout.getChildren().add(menuEditButton);
        menuLayout.getChildren().add(menuDepositButton);
        menuLayout.getChildren().add(menuViewButton);
        menuLayout.getChildren().add(menuExitButton);
        menuCreateButton.setMinWidth(100);
        menuEditButton.setMinWidth(100);
        menuDepositButton.setMinWidth(100);
        menuViewButton.setMinWidth(100);
        menuExitButton.setMinWidth(100);
        GridPane.setConstraints(menuCreateButton,0,2);
        GridPane.setConstraints(menuEditButton,0,3);
        GridPane.setConstraints(menuDepositButton,0,4);
        GridPane.setConstraints(menuViewButton,0,5);
        GridPane.setConstraints(menuExitButton,0,6);

        //creating menu headline/label and adding it to GridPane layout
        Label header = new Label("Welcome [username]");
        menuLayout.getChildren().add(header);
        GridPane.setConstraints(header,0,0);
    }

    public void setMenuExitButton(Button menuExitButton) {
        this.menuExitButton = menuExitButton;
    }
}
