package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.awt.*;


public class Main extends Application {

    private boolean play = true;
    private boolean turnX = true;

   private Parent createContent(){
       Pane root = new Pane();
       root.setPrefSize(900, 600);

      for (int i = 0; i < 3; i++){
           for (int j = 0; j < 3; j++) {
            Tile tile = new Tile();
            tile.setTranslateX(j* 200);
            tile.setTranslateY(i * 200);

               Button btn = new Button("Reset");
               btn.setTranslateX(800);
               btn.setTranslateY(500);

               RadioButton MCrb = new RadioButton("Mensch - Computer");
               MCrb.setTranslateX(700);
               btn.setTranslateY(150);

               RadioButton MMrb = new RadioButton("Mensch - Mensch");
               MCrb.setTranslateX(700);
               btn.setTranslateY(200);

            root.getChildren().add(tile);
            root.getChildren().add(btn);
            root.getChildren().add(MCrb);
            root.getChildren().add(MMrb);

           }
       }

       return root;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        primaryStage.setTitle("Tic Tac Toe JavaFx");
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();

   }


    private class Tile extends StackPane{
    // final JLabel label = new JLabel();
     private Text text = new Text();

        public Tile(){
            Rectangle border = new Rectangle(200, 200);
            border.setFill(null);
            border.setStroke(Color.BLACK);

            text.setFont(Font.font(72));

            setAlignment(Pos.CENTER);
            getChildren().addAll(border, text);

          setOnMouseClicked(event -> {
          if (!play)
              return;
               if (event.getButton() == MouseButton.PRIMARY){
                   if(!turnX)
                       return;

                   drawX();
                   turnX=false;
               }
               else if (event.getButton() == MouseButton.SECONDARY){
                   if(turnX)
                       return;

                   drawO();
                   turnX=true;
               }
            });
        }

       private void drawX(){
            text.setText("X");
        }

        private void drawO(){
            text.setText("O");
        }
    }
}

