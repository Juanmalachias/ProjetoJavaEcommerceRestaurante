package Restaurante;

import java.util.ArrayList;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;

import Restaurante.model.Pedidos;
import Restaurante.model.ultis;
import Restaurante.util.Cores;



public class RestauranteApp {

	private static Scanner leia = new Scanner(System.in);
	private static ArrayList<Pedidos>Pedido;
	private static Map<Pedidos, Integer>carrinho;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 
		  
		  Pedido= new ArrayList<>();
		  carrinho = new HashMap<>();
		  menu();}
		  
		  private static void menu() {
				// TODO Auto-generated method stub
	      	  

			  	System.out.println(Cores.TEXT_YELLOW_BOLD+Cores.ANSI_RED_BACKGROUND_BRIGHT+
						           "*******************************************************"); 
			  	System.out.println("*                                                     *");
			  	System.out.println("*                 .·:*¨¨* ≈☆≈ *¨¨*:·.                 *");
			  	System.out.println("*               ⋆✦⋆ Gastronomic Magic ⋆✦⋆              *");
			  	System.out.println("*                 .·:*¨¨* ≈☆≈ *¨¨*:·.                 *");
			  	System.out.println("*                                                     *");
	            System.out.println(Cores.TEXT_YELLOW_BOLD+Cores.ANSI_WHITE_BACKGROUND+"*******************************************************");
	            System.out.println("*                                                     *");
	            System.out.println("*            1 - Cadastra Pratos                      *");
	            System.out.println("*            2 - Mostrar Cardapio                     *");
	            System.out.println("*            3 - Comprar                              *");
	            System.out.println("*            4 - Carrinho                             *");
	            System.out.println("*            5 - Sair                                 *");
	            System.out.println("*                                                     *");
	            System.out.println(Cores.TEXT_YELLOW_BOLD+Cores.ANSI_RED_BACKGROUND_BRIGHT+"*******************************************************");
	            System.out.println("*             Entre com a opção desejada:             *");
	            System.out.println("*                                                     *"+Cores.TEXT_RESET);
	            
	            int opcao = leia.nextInt();
	                      
	            switch(opcao) {
	            case 1:
	            	cadastraPratos();
	            	break;
	            case 2:
	            	mostrarCardapio();
	            	break;
	            case 3:
	            	comprarPratos();
	            	break;
	            case 4:
	            	verCarrinho();
	            	break;
	            case 5:
	            	System.out.println("Volte Sempre!");
	            	System.exit(0);
	            	default:
	            		System.out.println("Opção invalida!");
	            		menu();
	            		break;	
	     }
	     		
	}
    
	private static void cadastraPratos() {
		
		
		System.out.println("Nome do Prato: ");
		leia.nextLine();
		String nome = leia.nextLine();
		System.out.println();
		System.out.println("Preço do Prato: ");
		double preço = leia.nextDouble();
		
		Pedidos pedido = new Pedidos(0, nome,preço);
		Pedido.add(pedido);
		
		System.out.println(pedido.getNomePrato()+ " cadastrado com sucesso!");
		System.out.println();
		menu();
	}
	
	private static void mostrarCardapio() {
		if (Pedido.size()>0) {
			System.out.println("Cardapio: \n");
			for(Pedidos P : Pedido) {
			System.out.println(P);
			System.out.println();
			}
		}else {
			System.out.println("Não tem nenhum prato cadastrado!");
			System.out.println();
		}
		menu();
		
	}
	
	private static void comprarPratos() {
		if (Pedido.size()>0) {
			System.out.println("Cardapio: \n");
			
			System.out.println("Pratos disponiveis");
			for(Pedidos P : Pedido) {
			System.out.println(P+"\n");
	
			
			}
			int numeroPedido = Integer.parseInt(leia.next());
			boolean isPresent = false;
			
			for(Pedidos P : Pedido) {
				if (P.getNumeroPedido()==numeroPedido) {
					int qtd = 0;
					try {
						qtd = carrinho.get(P);
						carrinho.put(P, qtd +1);
						
					}catch(NullPointerException e) {
						carrinho.put(P, 1);
					}
					System.out.println(P.getNomePrato()+"Adicionado ao carrinho");
					isPresent = true;
					
					if (isPresent ) {
						System.out.println("Deseja adicionar mais algum prato? ");
						System.out.println("Digite 1  para sim , ou 0 para finalizar a compra.");
						int opção = Integer.parseInt(leia.next());
						
						if (opção ==1) {
							comprarPratos();
						}else {
							finalizarCompra();
						}
					}
				}else {
					System.out.println("Prato prato não encontrado");
					menu();
					
				}
			}
		}else {
			System.out.println("Prato não cadastrado");
			menu();
		}
	}
	
	private static void verCarrinho() {
		System.out.println("Pratos no carrinho");
		if ( carrinho.size()>0 ) {
			for (Pedidos P : carrinho.keySet()) {
				System.out.println(" Prato: "+P+ "quantidade: "+carrinho.get(P));
				
			}
		
		}else {
				System.out.println("Carrinho vazio");
		}
		menu();
	}
	
	private static void finalizarCompra() {
		double valortotal = 0.0;
		System.out.println("Seus Pratos selecionados");
		
		for(Pedidos P : carrinho.keySet()) {
			int qtd = carrinho.get(P);
			valortotal+=P.getPreço()*qtd;
			System.out.println(P);
			System.out.println("Quantidade: " +qtd);
			
		}
		System.out.println(" O valor do seu pedido é : "+ultis.nfMoeda(valortotal));
		carrinho.clear();
		System.out.println("Obrigado por escolher nosso restaurante");
	}
}


