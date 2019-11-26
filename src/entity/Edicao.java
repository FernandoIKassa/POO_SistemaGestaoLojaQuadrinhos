package entity;

import java.util.Date;

public class Edicao {
	private int id;
	private int edicao;
	private Date lan�amento;
	private String descricao;
	private Titulo titulo;
	
	public int getEdicao() {
		return edicao;
	}
	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}
	public Date getLan�amento() {
		return lan�amento;
	}
	public void setLan�amento(Date lan�amento) {
		this.lan�amento = lan�amento;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Titulo getTitulo() {
		return titulo;
	}
	public void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(getEdicao());
	}
}
