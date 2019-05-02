package javaFX;

import dataHolder.Member;
import dataHolder.MemberList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

public class ViewPage {
    private Scene viewScene;
    private Button backButton;
    private ListView<Member> memberListView;

    public Scene getViewScene() {
        return viewScene;
    }

    public void setViewScene(Scene viewScene) {
        this.viewScene = viewScene;
    }

    public Button getBackButton() {
        return backButton;
    }

    public ViewPage(){
        GridPane viewLayout = new GridPane();
        viewLayout.setAlignment(Pos.CENTER);
        viewLayout.setVgap(10);
        viewScene = new Scene(viewLayout,640,480);
        viewLayout.setStyle("-fx-background-image: url('file:assets/dolphin.png')");

        //creating view headline/label and adding it to GridPane layout
        Label header = new Label("View members");
        viewLayout.getChildren().add(header);
        header.setStyle("-fx-font-size: 15;"+"-fx-font-weight: bold;");
        GridPane.setConstraints(header,1,1);

        //setting up ListView to see all current members
        MemberList memberList = new MemberList();
        memberListView = new ListView<>();
        //ObservableList<Member> MemberNames = FXCollections.observableArrayList(memberList.createMemberList());
        //memberListView.setItems(MemberNames);
        viewLayout.getChildren().add(memberListView);
        GridPane.setConstraints(memberListView,1,2);


        //setting up a back button, to return to menu
        backButton = new Button("Back");
        viewLayout.getChildren().add(backButton);
        GridPane.setConstraints(backButton,1,3);
        GridPane.setHalignment(backButton, HPos.RIGHT);
    }
}
