package view;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ViewPrincipal extends Application implements EventHandler<ActionEvent>{
	private MenuBar barraMenu = new MenuBar();
	
	private Menu mnuRevista = new Menu("Revista");
	private Menu mnuPessoa = new Menu("Pessoa");
	private Menu mnuVenda = new Menu("Venda");
	private Menu mnuRelatorio = new Menu("Relatorios");
	
	private MenuItem mnuClientes = new MenuItem("Clientes");
	private MenuItem mnuTitulo = new MenuItem("Titulo");
	private MenuItem mnuFuncionarios = new MenuItem("Funcionarios");
	private MenuItem mnuEdicao = new MenuItem("Edi��o");
	private MenuItem mnuExemplar = new MenuItem("Exemplar");
	private MenuItem mnuFolha = new MenuItem("Folha de pagamento");
	private MenuItem mnuBalanco = new MenuItem("Balan�o Geral");
	
	private BorderPane panPrincipal = new BorderPane();
	
	private Map<MenuItem, BoundaryContent> telas = new HashMap<>();
	


	@Override
	public void start(Stage stage) throws Exception {
		panPrincipal.setTop(barraMenu);
		generateMenus();
		Scene scn = new Scene(panPrincipal, 800, 600);
		
		stage.setScene(scn);
		stage.setTitle("Gest�o de Revistas");
		stage.show();
	}
	
	public void generateMenus() {
		// cria��o da barra de menus 
		barraMenu.getMenus().addAll(mnuRevista, mnuPessoa, mnuVenda,mnuRelatorio);
		mnuRevista.getItems().addAll(mnuTitulo, mnuEdicao, mnuExemplar);
		mnuPessoa.getItems().addAll(mnuClientes, mnuFuncionarios);
		mnuRelatorio.getItems().addAll(mnuFolha, mnuBalanco);
		
		// gerar as telas 
		telas.put(mnuTitulo, new TituloBoundary());
		telas.put(mnuEdicao, new EdicaoBoundary());
		telas.put(mnuExemplar, new ExemplarBoundary());
		//telas.put(mnuFuncionarios, new FuncionaroBoundary());
		
		Set<MenuItem> keys = telas.keySet();
		for(MenuItem menu : keys) { 
			menu.addEventHandler(ActionEvent.ANY, this);
		}
	}

	

	// Evento ao clicar em um item gera uma tela
	@Override
	public void handle(ActionEvent event) {
			BoundaryContent tela = telas.get(event.getTarget());
			if (tela != null) { 
				panPrincipal.setCenter(tela.generateForm());
			}			

	}

	
	
	public static void main(String[] args) {
		ViewPrincipal.launch(args);
	}
}
