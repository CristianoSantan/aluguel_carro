package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Aluga {
	private int id;
	private LocalDate retirada;
	private LocalDate devolucao;
	private double valor_total;
	private long dias;
	
	private Cliente cliente;
	private Carro carro;
	
	// classe responsavel por formatar um padrao diferente do formato ISO
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Aluga() {
		super();
	}

	public Aluga(int id, String retirada, String devolucao, Cliente cliente, Carro carro) {
		super();
		this.id = id;
		this.retirada = LocalDate.parse(retirada, formatter);
		this.devolucao = LocalDate.parse(devolucao, formatter);	
		// retorna a quantidade de dias entre as datas 
		this.dias = ChronoUnit.DAYS.between(this.retirada, this.devolucao);
		// metodo faz a operação de mutiplicação do valor de aluguel do carro vezes os dias.
		this.valor_total = setValor_total(carro.getValor());	
		this.cliente = cliente;
		this.carro = carro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRetirada() {
		return formatter.format(retirada);
	}

	public void setRetirada(String retirada) {
		this.retirada = LocalDate.parse(retirada, formatter);
	}

	public String getDevolucao() {
		return formatter.format(devolucao);
	}

	public void setDevolucao(String devolucao) {
		this.devolucao = LocalDate.parse(devolucao, formatter);
	}

	public double getValor_total() {
		return valor_total;
	}

	public double setValor_total(double valor_total) {
		this.valor_total = valor_total * dias;
		return this.valor_total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public long getDias() {
		return dias;
	}

	public void setDias(long dias) {
		this.dias = dias;
	}		
	
}
