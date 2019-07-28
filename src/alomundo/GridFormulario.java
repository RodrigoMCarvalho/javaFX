package alomundo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author rodri_000
 */
public class GridFormulario extends Application {

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Formulário");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text tituloCena = new Text("Bem-vindo");
        tituloCena.setFont(Font.font("Tohama", FontWeight.NORMAL, 20));
        grid.add(tituloCena, 0, 0, 2, 1); //posição do título no grid

        Label nomeUsuario = new Label("Usuário: ");
        grid.add(nomeUsuario, 0, 1);

        TextField campoTextoUsuario = new TextField();
        grid.add(campoTextoUsuario, 1, 1);

        Label senha = new Label("Senha: ");
        grid.add(senha, 0, 2);

        PasswordField campoSenha = new PasswordField();
        grid.add(campoSenha, 1, 2);

        Button btn = new Button("Acessar");
        HBox hbBtn = new HBox(10); //painel para alinhar o botão
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);  //adicionado o painel por ser filho
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);  //controle de alinhamento ao grid

        final Text actionTarget = new Text(); //cria um texto sem caracteres
        grid.add(actionTarget, 1, 6);   //posiciona no grid

        btn.setOnAction(new EventHandler<ActionEvent>() {  //evento responsável pelo click no botão
            @Override
            public void handle(ActionEvent event) {
                actionTarget.setFill(Color.FIREBRICK);  //altera a cor do texto
                actionTarget.setText("Botão acessar pressionado!");  //informa uma string quando o botão é presionado
            }
        });

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
