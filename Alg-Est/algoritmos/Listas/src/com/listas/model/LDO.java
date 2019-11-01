package com.listas.model;

import java.util.Scanner;

import com.listas.ElementoDuplo;

public class LDO {
	public ElementoDuplo inicio = null, fim = null, aux = null, novo = null;
	public boolean sair = false;
	private Scanner in = new Scanner(System.in);
	public int opcao, busca;

	public void run() {
		do {
			System.out.println("\nDigite uma opção:\n" + "0 - Sair\n" + "1 - Inserir\n" + "3 - Buscar\n"
					+ "4 - Excluir\n" + "5 - Esvaziar\n" + "6 - Ordenar (com outra lista)\n"
					+ "7 - Ordenar (na mesma lista)\n" + "8 - Listar\n");
			opcao = in.nextInt();
			switch (opcao) {
			case 0:
				sair = true;
				break;
			case 1:
				inserir();
				break;
			case 3:
				// buscar
				System.out.println("Digite um número para procurar:");
				busca = in.nextInt();
				aux = inicio;
				while (aux != null && aux.numero < busca) {
					aux = aux.prox;
				}
				if (aux == null || aux.numero > busca)
					System.out.println("não tem");
				else
					System.out.println("achei: " + busca);

				break;
			case 4:
				// excluir elemento
				System.out.println("Digite um número para procurar:");
				busca = in.nextInt();
				aux = inicio;
				while (aux != null && aux.numero < busca) {
					aux = aux.prox;
				}
				if (aux == null || aux.numero > busca)
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

	public void inserir() {
		novo = new ElementoDuplo();
		System.out.println("qual numero a inserir");
		novo.numero = in.nextInt();
		aux = inicio;
		if (inicio == null) {
			inicio = novo;
			fim = novo;
		} else {
			if (novo.numero < inicio.numero) {
				novo.prox = inicio;
				inicio.ant = novo;
				inicio = novo;
			} else if (novo.numero > fim.numero) {
				novo.ant = fim;
				fim.prox = novo;
				fim = novo;
			} else {
				// #TODO busca
				while (aux.numero < novo.numero) {
					aux = aux.prox;
				}
				// troca
				novo.prox = aux;
				novo.ant = aux.ant;
				aux.ant.prox = novo;
				aux.ant = novo;
			}
		}
	}
	
	public void inserir(int numero) {
		novo = new ElementoDuplo();
		novo.numero = numero;
		aux = inicio;
		if (inicio == null) {
			inicio = novo;
			fim = novo;
		} else {
			if (novo.numero < inicio.numero) {
				novo.prox = inicio;
				inicio.ant = novo;
				inicio = novo;
			} else if (novo.numero > fim.numero) {
				novo.ant = fim;
				fim.prox = novo;
				fim = novo;
			} else {
				// #TODO busca
				while (aux.numero < novo.numero) {
					aux = aux.prox;
				}
				// troca
				novo.prox = aux;
				novo.ant = aux.ant;
				aux.ant.prox = novo;
				aux.ant = novo;
			}
		}
	}

	
}
