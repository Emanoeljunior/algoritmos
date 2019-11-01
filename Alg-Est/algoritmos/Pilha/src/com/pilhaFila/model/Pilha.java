package com.pilhaFila.model;

import java.util.Scanner;

public class Pilha {
	
	public boolean sair = false;
	private Scanner in = new Scanner(System.in);
	public int opcao, busca;
	public String imprimir="";
	int numero;
	Elemento topo, aux, novo;
	
	public void run() {
		do {
			System.out.println("\nDigite uma opção:\n" 
					+ "0 - Sair\n" 
					+ "1 - Empilhar\n" 
					+ "2 - Desempilhar\n"
					+ "3 - Consultar\n" 
					+ "4 - Esvaziar\n" 
					+ "5 - Listar\n");
			opcao = in.nextInt();
			switch (opcao) {
			case 0:
				System.out.println("Tchau");
				sair = true;
				break;
			case 1:
				novo = new Elemento();
				System.out.println("Qual o número?");
				novo.numero = in.nextInt();
				if(topo == null) {
					topo = novo;
				}else {
					novo.prox = topo;
					topo = novo;
				}
				break;
			case 2:
				//Desempilhar
				if(topo==null)
				{
					System.out.println("Pilha vazia");
				}
				else {
					topo = topo.prox;
				}
				
				break;
			case 3:
				//consultar
				if(topo==null) {
					System.out.println("Pilha vazia");
				}
				else {
					aux=topo;
					System.out.println("Qual o número?");
					numero= in.nextInt();
					while(aux != null && numero != aux.numero) {
						aux = aux.prox;
					}	
					if(aux==null) {
						System.out.println("nao acho");
					}
					else {
						System.out.println(aux.numero);
					}
					
					
					
				}
				break;
	
			case 4:
				topo=null;
				break;
				
			case 5:
				//listar
				imprimir = "";
				if (topo==null)
					System.out.println("Pilha vazia");
				aux=topo;
				while(aux!=null)
				{
					imprimir += aux.numero+"\n";
					aux=aux.prox;
				}
				System.out.println(imprimir);
				break;
			default:
				System.out.println("Tchau");
				sair = true;
				break;
			}
		} while (!sair);
	}
}
