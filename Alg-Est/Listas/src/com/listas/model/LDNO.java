package com.listas.model;

import java.util.Scanner;

import com.listas.ElementoDuplo;

public class LDNO {
	public ElementoDuplo inicio = null, fim = null, aux = null, novo = null;
	public boolean sair = false;
	private Scanner in = new Scanner(System.in);
	public int opcao, busca;

	public void run() {
		do {
			System.out.println("\nDigite uma opção:\n" + "0 - Sair\n" + "1 - Inserir no inicio\n"
					+ "2 - Inserir no final\n" + "3 - Buscar\n" + "4 - Excluir\n" + "5 - Esvaziar\n"+ "6 - Ordenar (com outra lista)\n"+ "7 - Ordenar (na mesma lista)\n" + "8 - Listar\n");
			opcao = in.nextInt();
			switch (opcao) {
			case 0:
				sair = true;
				break;
			case 1:
				novo = new ElementoDuplo();
				System.out.println("Digite um número:");
				novo.numero = in.nextInt();
				if (inicio == null) {
					// lista vazia
					inicio = novo;
					fim = novo;
				} else {
					// lista não vazia
					novo.prox = inicio;
					inicio.ant = novo;
					inicio = novo;
				}
				break;
			case 2:
				inserirFinal();
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
				while (aux != null && aux.numero != busca) {
					aux = aux.prox;
				}
				if (aux == null)
					System.out.println("não tem");
				else {
					if (aux != inicio)
						aux.ant.prox = aux.prox;
					else
						inicio = aux.prox;

					if (aux != fim)
						aux.prox.ant = aux.ant;
					else
						fim = aux.ant;
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
				break;
			case 8:
				if (inicio == null)
					System.out.println("Lista vazia");
				else {
					aux = inicio;
					// circular
					/*
					 * do { System.out.println(aux.numero); aux = aux.prox; }while(aux != inicio);
					 */

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
	
	public void inserirFinal() {
		novo = new ElementoDuplo();
		System.out.println("Digite um número:");
		novo.numero = in.nextInt();
		if (inicio == null) {
			// lista vazia
			inicio = novo;
			fim = novo;
		} else {
			// lista não vazia
			fim.prox = novo;
			novo.ant = fim;
			fim = novo;
		}
	}
	
	public void inserirFinal(int n) {
		novo = new ElementoDuplo();
		novo.numero = n;
		if (inicio == null) {
			// lista vazia
			inicio = novo;
			fim = novo;
		} else {
			// lista não vazia
			fim.prox = novo;
			novo.ant = fim;
			fim = novo;
		}
	}

}
