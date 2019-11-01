package control;

import entity.Edi��o;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EdicaoControl {
	
	private ObservableList<Edi��o> lista = 
			FXCollections.observableArrayList();
	
	public void adicionar(Edi��o e) { 
		getLista().add(e);
	}
	
	public Edi��o pesquisarPorTipo(int edicao) { 
		for (Edi��o e : getLista()) { 
			if (e.getEdicao() == edicao){ 
				return e;
			}
		}
		return null;
	}

	public ObservableList<Edi��o> getLista() {
		return lista;
	}
}
