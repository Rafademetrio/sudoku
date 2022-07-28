package sudoku.visao;

import java.util.List;
import java.util.Map;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sudoku.modelo.Tabuleiro;

public class TelaPrincipal extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Tabuleiro tabuleiro = new Tabuleiro();
		Map<Integer, List<Integer>> tabela = tabuleiro.gerarTabuleiro2();

		tabuleiro.imprimirTodas();
		
		

		
		GridPane grid = new GridPane();
		grid.setGridLinesVisible(true);
		
		grid.getColumnConstraints().addAll(criarColunas(), criarColunas(), criarColunas(), criarColunas(), criarColunas(), criarColunas(), criarColunas(), criarColunas(), criarColunas());
		grid.getRowConstraints().addAll(criarLinhas(), criarLinhas(), criarLinhas(), criarLinhas(), criarLinhas(), criarLinhas(), criarLinhas(), criarLinhas(), criarLinhas());
		
		grid.add(fabricaCaixa(0), 0, 0 , 3, 3);
		grid.add(fabricaCaixa(1), 3, 0 , 3, 3);
		grid.add(fabricaCaixa(0), 6, 0 , 3, 3);
		grid.add(fabricaCaixa(1), 0, 3 , 3, 3);
		grid.add(fabricaCaixa(0), 3, 3 , 3, 3);
		grid.add(fabricaCaixa(1), 6, 3 , 3, 3);
		grid.add(fabricaCaixa(0), 0, 6 , 3, 3);
		grid.add(fabricaCaixa(1), 3, 6 , 3, 3);
		grid.add(fabricaCaixa(0), 6, 6 , 3, 3);
		
		
		for (int i = 0 ; i < 9 ; i++) { // esse percore as colunas
			for (int i2 = 1 ; i2 < 10 ; i2++ ) { // esse percorre as linhas
				String nomeLabel = tabela.get(i2).get(i).toString();
				//grid.add(new Button(nomeBotao), i, i2-1);
				grid.add(new Label(nomeLabel), i, i2-1);
			}
			
		}
		
		
		
		System.out.println(((Label) grid.getChildren().get(18)).getText());
		
		grid.getChildren().get(18).setVisible(false);
		
		Scene palco = new Scene(grid);
		
		primaryStage.setTitle("Sudoku");
		primaryStage.setScene(palco);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private HBox fabricaCaixa(int cor) {
		HBox caixa = new HBox();
		caixa.setPrefHeight(100.0);
		caixa.setPrefWidth(100.0);
		caixa.setAlignment(Pos.CENTER);
		BackgroundFill fill = new BackgroundFill( Color.RED , CornerRadii.EMPTY , Insets.EMPTY);						
		if(cor == 1) {
			fill = new BackgroundFill( Color.AQUA , CornerRadii.EMPTY , Insets.EMPTY);			
		}
		caixa.setBackground(new Background(fill));
		return caixa;
	}
	
	
	private ColumnConstraints criarColunas() {
		ColumnConstraints cc = new ColumnConstraints();
		cc.setPercentWidth(100);
		
		return cc;		
	}
	
	private RowConstraints criarLinhas() {
		RowConstraints cr = new RowConstraints();
		cr.setPercentHeight(100);
		
		return cr;
	}

}
