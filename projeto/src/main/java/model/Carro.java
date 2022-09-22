package model;

public class Carro {
	private int id;
	private String modelo;
	private String placa;
	private double valor;
	
	public Carro() {
		super();
	}
	
	public Carro(int id, String modelo, String placa, double valor) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.placa = placa;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Carro [id=" + id + ", modelo=" + modelo + ", placa=" + placa + ", valor=" + valor + "]";
	}
	
	
	
}
