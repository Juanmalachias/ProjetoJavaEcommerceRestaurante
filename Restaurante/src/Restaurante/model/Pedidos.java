package Restaurante.model;

public class Pedidos {
	private static int count=1;
	
	private int numeroPedido;
	private String nomePrato;
	private Double preço;
	
	
	
	public Pedidos(int numeroPedido, String nomePrato, Double preço) {
		super();
		this.numeroPedido = count;
		this.nomePrato = nomePrato;
		this.preço = preço;
		Pedidos.count+=1;
		
		
		
	}


	public int getNumeroPedido() {
		return numeroPedido;
	}


	public String getNomePrato() {
		return nomePrato;
	}


	public Double getPreço() {
		return preço;
	}


	public void setNomePrato(String nomePrato) {
		this.nomePrato = nomePrato;
	}


	public void setPreço(Double preço) {
		this.preço = preço;
	}
	
	public String toString() {
		return "NumeroPedido: "+this.getNumeroPedido()+
				"\nNome: "+this.getNomePrato()+
				"\nPreço: "+ultis.nfMoeda(this.getPreço());
	}
	
}
