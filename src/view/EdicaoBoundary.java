package view;

import java.text.SimpleDateFormat;
import java.util.Date;

import control.EdicaoControl;
import entity.Edi��o;
import entity.Titulo;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class EdicaoBoundary implements BoundaryContent, EventHandler<ActionEvent> {

	public static EdicaoControl controlEd = new EdicaoControl(); 
	//criando uma variavel do tipo Titulo para alimentar a combo
	ObservableList<Titulo> titulos = TituloBoundary.controlTi.getLista(); 
	private ComboBox<Titulo> comboTitulo = new ComboBox<>();

	private GridPane panGrid;
	
	private TextField txtEdicao= new TextField();
	private TextField txtLan�amento = new TextField();
	private TextField txtValorCompra = new TextField();
	private TextField txtValorVenda = new TextField();
	private TextField txtDescricao = new TextField();
	
	private Button btnAdicionar = new Button("Adicionar");
	private Button btnPesquisar = new Button("Pesquisar");
	private Button btnExcluir = new Button("Excluir");
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public EdicaoBoundary() { 
		panGrid = new GridPane();
		panGrid.add(comboTitulo, 0, 0);
		
		panGrid.add(new Label("Edi��o"), 2, 0);
		panGrid.add(txtEdicao, 3, 0);
		
		panGrid.add(new Label("Lan�amento"), 0, 1);
		panGrid.add(txtLan�amento, 1, 1);
		
		panGrid.add(new Label("Valor Compra"), 0, 2);
		panGrid.add(txtValorCompra, 1, 2);
		
		panGrid.add(new Label("Valor Venda"), 2, 2);
		panGrid.add(txtValorVenda, 3, 2);
		
		panGrid.add(new Label("Descri��o"), 0, 3);
		panGrid.add(txtDescricao, 1, 3);
		
		panGrid.add(btnAdicionar, 0, 4);
		panGrid.add(btnPesquisar, 1, 4);
		panGrid.add(btnExcluir, 2, 4);
		
		panGrid.setHgap(10);
		panGrid.setVgap(10);
		
		// deixar a comboBox nao editavel 
		comboTitulo.setEditable(false);
		// adicionar a lista de titulos na combo
		comboTitulo.setItems(titulos);
		
		
		btnAdicionar.addEventHandler(ActionEvent.ANY, this);
		btnPesquisar.addEventHandler(ActionEvent.ANY, this);
	}
	public Pane generateForm() { 
		return panGrid;
	}
	
	// a��o ao clicar um bot�o
	@Override
	public void handle(ActionEvent event) {
		if (event.getTarget() == btnAdicionar) { 
			controlEd.adicionar(boundaryParaEntidade());
		} else if (event.getTarget() == btnPesquisar) {
			int edicao = Integer.parseInt(txtEdicao.getText());
			Edi��o t = controlEd.pesquisarPorTipo(edicao);			
			entidadeParaBoundary(t);
		}
		
	}
	//mover da entidade para a tela
	private void entidadeParaBoundary(Edi��o e) {
		if (e != null) {
			txtEdicao.setText(String.valueOf(e.getEdicao()));
			String strData = sdf.format(e.getLan�amento());
			txtLan�amento.setText(strData);
			txtValorCompra.setText(String.valueOf(e.getValorCompra()));
			txtValorVenda.setText(String.valueOf(e.getValorVenda()));
			txtDescricao.setText(e.getDescricao());
			
		}
		
	}
	
	//mover da tela para a entidade
	private Edi��o boundaryParaEntidade() {
		Edi��o e = new Edi��o();
		try {
			e.setEdicao(Integer.parseInt(txtEdicao.getText()));
			Date d = sdf.parse(txtLan�amento.getText());
			e.setLan�amento(d);
			e.setValorCompra(Double.parseDouble(txtValorCompra.getText()));
			e.setValorVenda(Double.parseDouble(txtValorVenda.getText()));
			e.setDescricao(txtDescricao.getText());
		} catch (Exception f) {
			f.printStackTrace();
		}
		return e;
	}
}
