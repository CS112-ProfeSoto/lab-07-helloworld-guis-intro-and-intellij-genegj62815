package edu.miracosta.cs112.lab07;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class HelloApplication extends Application implements EventHandler<ActionEvent> {
    /*** GUI COMPONENTS ***/
    private Button button;
    private Label message;
    private TextField nameField;
    private int clickCount = 0;

    /*** DRIVER main ***/
    public static void main(String[] args) {
        launch(args);
    }

    /*** OVERRIDDEN Application METHODS ***/
    @Override
    public void start(Stage primaryStage) throws Exception {
        //SETUP COMPONENTS
        message = new Label("Hi, User!");
        nameField = new TextField();
        nameField.setPromptText("Enter your name");
        button = new Button("Click me");
        button.setOnAction(this);

        //ADD COMPONENTS
        VBox layout = new VBox();
        layout.getChildren().addAll(message, nameField, button);

        //SETUP SCENE AND SHOW
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Miles"); // Replace with your name
        primaryStage.show();
    }

    /*** OVERRIDDEN EventHandler METHODS ***/
    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == button) {
            clickCount++;
            String name = nameField.getText().isEmpty() ? "User" : nameField.getText();
            message.setText("Hi #" + clickCount + ", " + name + "!");
            System.out.println("Hello CS112");
        }
    }
}
