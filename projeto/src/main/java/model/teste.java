package model;

public class teste {

	public static void main(String[] args) {
		
		Cliente c1 = new Cliente(1, "João", "Campinas", "12345678910");

		Carro ca1 = new Carro(1, "compass", "lkj1234", 25);
		
		System.out.println(c1.toString() + "\n" + ca1.toString());
	}
}
