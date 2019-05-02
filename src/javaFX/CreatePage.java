package javaFX;


import IO.IOWriter;
import dataHolder.Member;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;


public class CreatePage {
    private Scene CreateScene;
    private Scene ReviewScene;
    private Button BackButton;
    private Button CreateButton;
    private Button ResetButton;
    private Button ConfirmButton;
    private Button BackToCreateButton;
    private Label ReviewText;
    private TextField InputName;
    private TextField InputPhoneNumber;
    private TextField InputEmail;
    private TextField InputBalance;
    private DatePicker InputBirthday;
    private DatePicker InputStartDate;
    private RadioButton Active;
    private RadioButton Passive;
    private RadioButton Competitive;
    private RadioButton NonCompetitive;
    private GridPane createLayout;
    private GridPane reviewLayout;

    public Scene getCreateScene() {
        return CreateScene;
    }

    public void setCreateScene(Scene CreateScene) {
        this.CreateScene = CreateScene;
    }

    public Scene getReviewScene() {
        return ReviewScene;
    }

    public Button getBackButton() {
        return BackButton;
    }

    public Button getCreateButton() {
        return CreateButton;
    }

    public Button getConfirmButton() {
        return ConfirmButton;
    }

    public Button getBackToCreateButton() {
        return BackToCreateButton;
    }

    public CreatePage(){

        createLayout = new GridPane();
        createLayout.setAlignment(Pos.CENTER);
        createLayout.setVgap(10);
        createLayout.setHgap(5);
        createLayout.setStyle("-fx-background-image: url('file:assets/dolphin.png')");
        CreateScene = new Scene(createLayout,640,480);

        //setting up create headline/label and adding it to GridPane layout
        Label header = new Label("Create a new member");
        header.setStyle("-fx-font-size: 15;"+"-fx-font-weight: bold;");
        createLayout.getChildren().add(header);
        GridPane.setConstraints(header,1,0);
        GridPane.setHalignment(header, HPos.CENTER);

        //setting up a create button, to confirm creation
        CreateButton = new Button("Create");
        createLayout.getChildren().add(CreateButton);
        GridPane.setConstraints(CreateButton,1,10);
        CreateButton.setOnAction(event -> reviewMember());

        //setting up a reset button, to reset creation form
        ResetButton = new Button("Reset");
        createLayout.getChildren().add(ResetButton);
        GridPane.setConstraints(ResetButton,1,10);
        GridPane.setHalignment(ResetButton, HPos.CENTER);
        ResetButton.setOnAction(event -> {
            InputName.clear();
            InputPhoneNumber.clear();
            InputEmail.clear();
            InputBirthday.setValue(null);
            InputStartDate.setValue(null);
            Active.setSelected(false);
            Passive.setSelected(false);
            Competitive.setSelected(false);
            NonCompetitive.setSelected(false);
            InputBalance.clear();
        });

        //setting up text input fields
        InputName = new TextField();
        InputName.setPromptText("Enter Name");
        createLayout.getChildren().add(InputName);
        GridPane.setConstraints(InputName,1,1);

        InputPhoneNumber = new TextField();
        InputPhoneNumber.setPromptText("Enter Phone Number");
        createLayout.getChildren().add(InputPhoneNumber);
        GridPane.setConstraints(InputPhoneNumber,1,2);

        InputEmail = new TextField();
        InputEmail.setPromptText("Enter Email");
        createLayout.getChildren().add(InputEmail);
        GridPane.setConstraints(InputEmail,1,3);

        InputBalance = new TextField();
        InputBalance.setPromptText("Enter Balance");
        createLayout.getChildren().add(InputBalance);
        GridPane.setConstraints(InputBalance,1,4);

        //setting up date picker for age and subscription start date
        InputBirthday = new DatePicker();
        InputBirthday.setPromptText("Enter Birthday");
        createLayout.getChildren().add(InputBirthday);
        GridPane.setConstraints(InputBirthday,1,5);
        
        InputStartDate = new DatePicker();
        createLayout.getChildren().add(InputStartDate);
        InputStartDate.setPromptText("Enter Start Date");
        GridPane.setConstraints(InputStartDate,1,6);

        //setting up radio buttons for membership status choices
        Active = new RadioButton("Active");
        createLayout.getChildren().add(Active);
        GridPane.setConstraints(Active,1,7);
        GridPane.setHalignment(Active, HPos.RIGHT);
        Active.setOnAction(event -> Passive.setSelected(false));

        Passive = new RadioButton("Passive");
        createLayout.getChildren().add(Passive);
        GridPane.setConstraints(Passive,1,8);
        GridPane.setHalignment(Passive, HPos.RIGHT);
        Passive.setOnAction(event -> Active.setSelected(false));

        Competitive = new RadioButton("Competitive");
        createLayout.getChildren().add(Competitive);
        GridPane.setConstraints(Competitive,1,7);
        Competitive.setOnAction(event -> NonCompetitive.setSelected(false));

        NonCompetitive = new RadioButton("Noncompetitive");
        createLayout.getChildren().add(NonCompetitive);
        GridPane.setConstraints(NonCompetitive,1,8);
        NonCompetitive.setOnAction(event -> Competitive.setSelected(false));

        //setting up a back button, to return to menu
        BackButton = new Button("Back");
        createLayout.getChildren().add(BackButton);
        GridPane.setConstraints(BackButton,1,10);
        GridPane.setHalignment(BackButton, HPos.RIGHT);

    }
    //Displays the user input data and waits for confirm to save to file
    public void reviewMember(){
        IOWriter ioWriter = new IOWriter();
        reviewLayout = new GridPane();
        reviewLayout.setAlignment(Pos.CENTER);
        reviewLayout.setVgap(10);
        reviewLayout.setHgap(5);
        CreateScene.setRoot(reviewLayout);

        String text = "Name: "+InputName.getText()
                +"\nPhone Number: " +InputPhoneNumber.getText()
                +"\nEmail: "+InputEmail.getText()
                +"\nBalance: "+InputBalance.getText()
                +"\nBirthday: "+InputBirthday.getValue()
                +"\nStart Date: "+InputStartDate.getValue()
                +"\nMembership Type: "
                +"\nMembership Status: ";
        ReviewText = new Label(text);

        reviewLayout.getChildren().add(ReviewText);
        GridPane.setConstraints(ReviewText,0,0);

        ConfirmButton = new Button("Confirm");
        reviewLayout.getChildren().add(ConfirmButton);
        GridPane.setConstraints(ConfirmButton,1,1);
        ConfirmButton.setOnAction(event -> ioWriter.writeFile(createMember()));

        BackToCreateButton = new Button("Edit");
        reviewLayout.getChildren().add(BackToCreateButton);
        GridPane.setConstraints(BackToCreateButton,2,1);
        BackToCreateButton.setOnAction(event -> CreateScene.setRoot(createLayout));

    }
    //Creates the member object and returns it.
    public Member createMember(){

        GridPane saved = new GridPane();
        saved.setAlignment(Pos.CENTER);
        CreateScene.setRoot(saved);
        Label savedText = new Label("Member.txt file saved in directory: .../data/");
        savedText.setStyle("-fx-font-size: 15;");
        saved.getChildren().add(savedText);
        saved.getChildren().add(BackToCreateButton);
        BackToCreateButton.setText("Back");

        //run Member class constructor with data from input fields, and return it
        Member newMember = new Member(InputName.getText(), InputPhoneNumber.getText(), InputEmail.getText(),
                InputBirthday.getValue().atStartOfDay(), InputStartDate.getValue().atStartOfDay(), Active.isPressed(), false,
                Competitive.isPressed(), Integer.parseInt(InputBalance.getText()));
        InputName.clear();
        InputPhoneNumber.clear();
        InputEmail.clear();
        InputBirthday.setValue(null);
        InputStartDate.setValue(null);
        Active.setSelected(false);
        Competitive.setSelected(false);
        InputBalance.clear();
        return newMember;
    }

    public void setReviewScene(Scene reviewScene) {
        ReviewScene = reviewScene;
    }

    public void setBackButton(Button backButton) {
        BackButton = backButton;
    }

    public void setCreateButton(Button createButton) {
        CreateButton = createButton;
    }

    public Button getResetButton() {
        return ResetButton;
    }

    public void setResetButton(Button resetButton) {
        ResetButton = resetButton;
    }

    public void setConfirmButton(Button confirmButton) {
        ConfirmButton = confirmButton;
    }

    public void setBackToCreateButton(Button backToCreateButton) {
        BackToCreateButton = backToCreateButton;
    }

    public Label getReviewText() {
        return ReviewText;
    }

    public void setReviewText(Label reviewText) {
        ReviewText = reviewText;
    }

    public TextField getInputName() {
        return InputName;
    }

    public void setInputName(TextField inputName) {
        InputName = inputName;
    }

    public TextField getInputPhoneNumber() {
        return InputPhoneNumber;
    }

    public void setInputPhoneNumber(TextField inputPhoneNumber) {
        InputPhoneNumber = inputPhoneNumber;
    }

    public TextField getInputEmail() {
        return InputEmail;
    }

    public void setInputEmail(TextField inputEmail) {
        InputEmail = inputEmail;
    }

    public TextField getInputBalance() {
        return InputBalance;
    }

    public void setInputBalance(TextField inputBalance) {
        InputBalance = inputBalance;
    }

    public DatePicker getInputBirthday() {
        return InputBirthday;
    }

    public void setInputBirthday(DatePicker inputBirthday) {
        InputBirthday = inputBirthday;
    }

    public DatePicker getInputStartDate() {
        return InputStartDate;
    }

    public void setInputStartDate(DatePicker inputStartDate) {
        InputStartDate = inputStartDate;
    }

    public RadioButton getActive() {
        return Active;
    }

    public void setActive(RadioButton active) {
        Active = active;
    }

    public RadioButton getPassive() {
        return Passive;
    }

    public void setPassive(RadioButton passive) {
        Passive = passive;
    }

    public RadioButton getCompetitive() {
        return Competitive;
    }

    public void setCompetitive(RadioButton competitive) {
        Competitive = competitive;
    }

    public RadioButton getNonCompetitive() {
        return NonCompetitive;
    }

    public void setNonCompetitive(RadioButton nonCompetitive) {
        NonCompetitive = nonCompetitive;
    }

    public GridPane getCreateLayout() {
        return createLayout;
    }

    public void setCreateLayout(GridPane createLayout) {
        this.createLayout = createLayout;
    }

    public GridPane getReviewLayout() {
        return reviewLayout;
    }

    public void setReviewLayout(GridPane reviewLayout) {
        this.reviewLayout = reviewLayout;
    }
}
