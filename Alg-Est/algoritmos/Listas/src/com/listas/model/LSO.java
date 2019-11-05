package com.listas.model;

import java.util.Scanner;

import com.listas.ElementoDuplo;
import com.listas.ElementoSimples;

public class LSO {
	public ElementoSimples inicio = null, fim = null, aux = null, novo = null;
	public boolean sair = false;
	private Scanner in = new Scanner(System.in);
	public int opcao, busca;

	public void run() {
		do {
			System.out.println("\nDigite uma op��o:\n" + "0 - Sair\n" + "1 - Inserir no inicio\n"
					+ "2 - Inserir no final\n" + "3 - Buscar\n" + "4 - Excluir\n" + "5 - Esvaziar\n"+ "6 - Ordenar (com outra lista)\n"+ "7 - Ordenar (na mesma lista)\n" + "8 - Listar\n");
			opcao = in.nextInt();
			switch (opcao) {
			case 0:
				sair = true;
				break;
			case 1:
				novo = new ElementoSimples();
				System.out.println("Digite um n�mero:");
				novo.numero = in.nextInt();
				if (inicio == null) {
					// lista vazia
					inicio = novo;
					fim = novo;
				} else {
					// lista n�o vazia
					novo.prox = inicio;
					inicio = novo;
				}
				break;
			case 2:
				novo = new ElementoSimples();
				System.out.println("Digite um n�mero:");
				novo.numero = in.nextInt();
				if (inicio == null) {
					// lista vazia
					inicio = novo;
					fim = novo;
				} else {
					// lista n�o vazia
					fim.prox = novo;
					fim = novo;
				}
				break;
			case 3:
				// buscar
				System.out.println("Digite um n�mero para procurar:");
				busca = in.nextInt();
				aux = inicio;
				while (aux != null && aux.numero != busca) {
					aux = aux.prox;
				}
				if (aux == null)
					System.out.println("n�o tem");
				else
					System.out.println("achei: " + busca);

				break;
			
		}
			} while(!sair);		
	
		}
	
	public void inserir(int numero) {
		novo = new ElementoSimples();
		novo.numero = numero;
		aux = inicio;
		
		if (inicio == null) {
			inicio = novo;
			fim = novo;
		} else {
			if (novo.numero < inicio.numero) {
				novo.prox = inicio;
				
				inicio = novo;
			} else if (novo.numero > fim.numero) {
				fim.prox = novo;
				fim = novo;
			} else {
				// #TODO busca
				while (aux.prox.numero < novo.numero) {
					aux = aux.prox;
				}
				 //troca
				 novo.prox = aux.prox;
				 aux.prox = novo;
			}
		}
	}

	}
