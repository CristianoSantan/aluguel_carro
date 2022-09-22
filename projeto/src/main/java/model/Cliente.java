package model;

public class Cliente {
	private int id;
	private String nome;
	private String cidade;
	private String cpf;
	
	public Cliente() {
		super();
	}
	
	public Cliente(int id, String nome, String cidade, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.cidade = cidade;
		this.cpf = cpf;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cidade=" + cidade + ", cpf=" + cpf + "]";
	}
	
	
}
