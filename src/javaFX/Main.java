package javaFX;


import javafx.application.Application;
import javafx.stage.Stage;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;
import java.io.FileInputStream;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        MenuPage menu = new MenuPage();
        CreatePage create = new CreatePage();
        EditPage edit = new EditPage();
        DepositPage deposit = new DepositPage();
        ViewPage view = new ViewPage();

        //play underwater sounds during entire runtime
        AudioData audioData = new AudioStream(new FileInputStream("assets/sound.wav")).getData();
        ContinuousAudioDataStream sound = new ContinuousAudioDataStream(audioData);
        AudioPlayer.player.start(sound);

        //setup main windows settings
        primaryStage.setTitle("Delfinen - Administrativt System");
        primaryStage.setScene(menu.getMenuScene());
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.setOnCloseRequest(event -> {
            AudioPlayer.player.stop(sound);
            primaryStage.close();
        });

        //menu button actions
        menu.getMenuCreateButton().setOnAction(event -> primaryStage.setScene(create.getCreateScene()));
        menu.getMenuEditButton().setOnAction(event -> primaryStage.setScene(edit.getEditScene()));
        menu.getMenuDepositButton().setOnAction(event -> primaryStage.setScene(deposit.getDepositScene()));
        menu.getMenuViewButton().setOnAction(event -> primaryStage.setScene(view.getViewScene()));
        menu.getMenuExitButton().setOnAction(event -> {
            AudioPlayer.player.stop(sound);
            primaryStage.close();
        });
//        back button actions
        create.getBackButton().setOnAction(event -> primaryStage.setScene(menu.getMenuScene()));
        edit.getBackButton().setOnAction(event -> primaryStage.setScene(menu.getMenuScene()));
        deposit.getBackButton().setOnAction(event -> primaryStage.setScene(menu.getMenuScene()));
        view.getBackButton().setOnAction(event -> primaryStage.setScene(menu.getMenuScene()));

    }


    public static void main(String[] args) {
        launch(args);
    }
}
