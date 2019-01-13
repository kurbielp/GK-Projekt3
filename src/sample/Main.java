package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.geometry.Insets;


import java.awt.*;

public class Main extends Application {

    public double ip = 1.0;
    public double ia = 0.1;
    public static double[] ka;
    ////współczynnik odbicia światła rozproszonego
    public static double[] kd ;
    ////współczynnik odbicia światła kierunkowego
    public static double[] ks ;
    //współczynnik gładkości
    public static double[] m ;
    Canvas canvas;
    Canvas canvas2;
    Canvas canvas3;
    Canvas canvas4;

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //StackPane root = new StackPane();
        GridPane root = new GridPane();
        GridPane midGrid = new GridPane();
        GridPane upperGrid = new GridPane();
        GridPane lowerGrid = new GridPane();

        primaryStage.setTitle("Grafika komputerowa-projekt 3");
        int material = 0;

        setupCanvas();

        javafx.scene.control.Button btnIpInc = new Button();
        btnIpInc.setText("Zwiększ nateżenie światła w  punktcie");
        btnIpInc.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ip+=0.1;
                setupCanvas();
                setupScene(primaryStage,  new GridPane(),lowerGrid,midGrid);
            }
        });
        javafx.scene.control.Button btnIpDec = new Button();
        btnIpDec.setText("Zmniejsz nateżenie światła w  punktcie");
        btnIpDec.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ip-=0.1;
                setupCanvas();
                setupScene(primaryStage,  new GridPane(),lowerGrid,midGrid);
            }
        });
        javafx.scene.control.Button btnIaInc = new Button();
        btnIaInc.setText("Zwiększ nateżenie światła w  otoczeniu");
        btnIaInc.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ia+=0.1;
                setupCanvas();
                setupScene(primaryStage,  new GridPane(),lowerGrid,midGrid);
            }
        });
        javafx.scene.control.Button btnIaDec = new Button();
        btnIaDec.setText("Zmniejsz nateżenie światła w  otoczeniu");
        btnIaDec.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ia-=0.1;
                setupCanvas();
                setupScene(primaryStage,  new GridPane(),lowerGrid,midGrid);
            }
        });

        upperGrid.add(canvas,0,0,1,1);
        upperGrid.add(canvas2,1,0,1,1);
        upperGrid.add(canvas3,2,0,1,1);
        upperGrid.add(canvas4,3,0,1,1);

        setupLabels(midGrid);

        lowerGrid.add(btnIpInc,0,0,1,1);
        lowerGrid.add(btnIpDec,1,0,1,1);
        lowerGrid.add(btnIaInc,2,0,1,1);
        lowerGrid.add(btnIaDec,3,0,1,1);
        root.add(upperGrid,0,0,1,1);
        root.add(midGrid,0,1,1,1);
        root.add(lowerGrid,0,2,1,1);
        midGrid.setMargin(root,new Insets(5, 5, 5, 5));
        Scene scene = new Scene(root, 1600, 550, Color.rgb(178, 207, 255));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setupLabels(GridPane midGrid) {
        RysownikScene rs = new RysownikScene(0,ip,ia);
        Label wspolOdbSwiatodOtocz0 = new Label("wspol odb swiat od otocz: " +rs.getKa()[0]);
        Label wspolOdbSwiatodOtoczRozpr0 = new Label("wspol odb swiat rozpr: "+ rs.getKd()[0]);
        Label wspolOdbSwiatodOtoczKierunk0 = new Label("wspol odb swiat kierunkowego: "+ rs.getKs()[0]);
        Label wspolGladkosc0 = new Label("wspol gladkosci: "+ rs.getM()[0]);
        midGrid.add(new Label("materiał 1"),0,0,1,1);
        midGrid.add(wspolOdbSwiatodOtocz0,0,1,1,1);
        midGrid.add(wspolOdbSwiatodOtoczRozpr0,0,2,1,1);
        midGrid.add(wspolOdbSwiatodOtoczKierunk0,0,3,1,1);
        midGrid.add(wspolGladkosc0,0,4,1,1);

        Label wspolOdbSwiatodOtocz1 = new Label("wspol odb swiat od otocz: " +rs.getKa()[1]);
        Label wspolOdbSwiatodOtoczRozpr1 = new Label("wspol odb swiat rozpr: "+ rs.getKd()[1]);
        Label wspolOdbSwiatodOtoczKierunk1 = new Label("wspol odb swiat kierunkowego: "+ rs.getKs()[1]);
        Label wspolGladkosc1 = new Label("wspol gladkosci: "+ rs.getM()[1]);
        midGrid.add(new Label("materiał 2"),1,0,1,1);
        midGrid.add(wspolOdbSwiatodOtocz1,1,1,1,1);
        midGrid.add(wspolOdbSwiatodOtoczRozpr1,1,2,1,1);
        midGrid.add(wspolOdbSwiatodOtoczKierunk1,1,3,1,1);
        midGrid.add(wspolGladkosc1,1,4,1,1);

        Label wspolOdbSwiatodOtocz2 = new Label("wspol odb swiat od otocz: " +rs.getKa()[2]);
        Label wspolOdbSwiatodOtoczRozpr2 = new Label("wspol odb swiat rozpr: "+ rs.getKd()[2]);
        Label wspolOdbSwiatodOtoczKierunk2 = new Label("wspol odb swiat kierunkowego: "+ rs.getKs()[2]);
        Label wspolGladkosc2 = new Label("wspol gladkosci: "+ rs.getM()[2]);
        midGrid.add(new Label("materiał 3"),2,0,1,1);
        midGrid.add(wspolOdbSwiatodOtocz2,2,1,1,1);
        midGrid.add(wspolOdbSwiatodOtoczRozpr2,2,2,1,1);
        midGrid.add(wspolOdbSwiatodOtoczKierunk2,2,3,1,1);
        midGrid.add(wspolGladkosc2,2,4,1,1);

        Label wspolOdbSwiatodOtocz3 = new Label("wspol odb swiat od otocz: " +rs.getKa()[3]);
        Label wspolOdbSwiatodOtoczRozpr3 = new Label("wspol odb swiat rozpr: "+ rs.getKd()[3]);
        Label wspolOdbSwiatodOtoczKierunk3 = new Label("wspol odb swiat kierunkowego: "+ rs.getKs()[3]);
        Label wspolGladkosc3 = new Label("wspol gladkosci: "+ rs.getM()[3]);
        midGrid.add(new Label("materiał 4"),3,0,1,1);
        midGrid.add(wspolOdbSwiatodOtocz3,3,1,1,1);
        midGrid.add(wspolOdbSwiatodOtoczRozpr3,3,2,1,1);
        midGrid.add(wspolOdbSwiatodOtoczKierunk3,3,3,1,1);
        midGrid.add(wspolGladkosc3,3,4,1,1);
    }

    private void setupScene(Stage primaryStage, GridPane upperGrid, GridPane lowerGrid, GridPane midGrid) {
        upperGrid.add(canvas,0,0,1,1);
        upperGrid.add(canvas2,1,0,1,1);
        upperGrid.add(canvas3,2,0,1,1);
        upperGrid.add(canvas4,3,0,1,1);
        GridPane root = new GridPane();
        root.add(upperGrid,0,0,1,1);
        root.add(midGrid,0,1,1,1);
        root.add(lowerGrid,0,2,1,1);
        Scene scene = new Scene(root, 1600, 550, Color.rgb(178, 207, 255));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setupCanvas() {
        this.canvas = new RysownikScene(0,ip,ia).getCanvas();
        this.canvas2 = new RysownikScene(1,ip,ia).getCanvas();
        this.canvas3 = new RysownikScene(2,ip,ia).getCanvas();
        this.canvas4 = new RysownikScene(3,ip,ia).getCanvas();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
