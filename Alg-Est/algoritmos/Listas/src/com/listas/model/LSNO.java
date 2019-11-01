package com.listas.model;

import java.util.Scanner;

import com.listas.ElementoDuplo;
import com.listas.ElementoSimples;

public class LSNO {
	public ElementoSimples inicio = null, fim = null, aux = null, novo = null, anterior = null;
	public boolean sair = false;
	private Scanner in = new Scanner(System.in);
	public int opcao, busca;

	public void run() {
		do {
			System.out.println("\nLSNO"
					+ "\nDigite uma opção:\n" + "0 - Sair\n" + "1 - Inserir no inicio\n"
					+ "2 - Inserir no final\n" + "3 - Buscar\n" + "4 - Excluir\n" + "5 - Esvaziar\n"+ "6 - Ordenar (com outra lista)\n"+ "7 - Ordenar (na mesma lista)\n" + "8 - Listar\n");
			opcao = in.nextInt();
			switch (opcao) {
			case 0:
				sair = true;
				break;
			case 1:
				novo = new ElementoSimples();
				System.out.println("Digite um número:");
				novo.numero = in.nextInt();
				if (inicio == null) {
					// lista vazia
					inicio = novo;
					fim = novo;
				} else {
					// lista não vazia
					novo.prox = inicio;
					inicio = novo;
				}
				break;
			case 2:
				novo = new ElementoSimples();
				System.out.println("Digite um número:");
				novo.numero = in.nextInt();
				if (inicio == null) {
					// lista vazia
					inicio = novo;
					fim = novo;
				} else {
					// lista não vazia
					fim.prox = novo;
					fim = novo;
				}
				break;
			case 3:
				// buscar
				System.out.println("Digite um número para procurar:");
				busca = in.nextInt();
				aux = inicio;
				while (aux != null && aux.numero != busca) {
					aux = aux.prox;
				}
				if (aux == null)
					System.out.println("não tem");
				else
					System.out.println("achei: " + busca);

				break;
			case 4:
				// excluir elemento
				System.out.println("Digite um número para procurar:");
				busca = in.nextInt();
				aux = inicio;
				if(aux != null && aux.numero == busca) {
					if(inicio == fim) {
						fim = null;
						inicio = null;
					}else
						inicio = aux.prox;//removi o primeiro
					break;
				}else {
					aux = aux.prox;
					anterior = inicio;
				}
				//faz a busca
				while (aux != null && aux.numero != busca) {
					aux = aux.prox;
				}
				
				if (aux == null)
					System.out.println("não tem");
				else {
					if(aux == fim) {
						fim = anterior;
						fim.prox = null;
					}else {
						anterior.prox = aux.prox;
					}
				}
				break;
			case 5:
				// esvaziar a lista
				inicio = null;
				fim = null;
				break;
			case 6:
				LDO listaOrdenada = new LDO();
				aux= inicio;
				while(aux != null) {
					listaOrdenada.inserir(aux.numero);
					aux = aux.prox;
				}
				inicio = null;
				
				ElementoDuplo auxLDO = new ElementoDuplo();
				auxLDO = listaOrdenada.inicio;
				while(auxLDO != null) {
					inserirFinal(auxLDO.numero);
					auxLDO = auxLDO.prox;
				}

			case 8:
				if (inicio == null)
					System.out.println("Lista vazia");
				else {
					aux = inicio;
					
					while (aux != null) {
						System.out.print(aux.numero + " ");
						aux = aux.prox;
					}
				}
				break;
			default:
				sair = true;
				break;
			}
		} while (!sair);
		
	}
	public void inserirFinal(int n) {
		novo = new ElementoSimples();
		novo.numero = n;
		if (inicio == null) {
			// lista vazia
			inicio = novo;
			fim = novo;
		} else {
			// lista não vazia
			fim.prox = novo;
			fim = novo;
		}
	}


}