package sudoku.modelo;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tabuleiro {

	private List<Integer> tab = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

	
	
	private Map<Integer, List<Integer>> tabela = new HashMap<Integer, List<Integer>>(9);
	private Map<Integer, List<Integer>> t1 = new HashMap<Integer, List<Integer>>(9);

	//teste
	
	
	private boolean colunaOK(int linha) {
		for (int i = 0; i < 9; i++) {
			for (int j = 1; j < linha; j++) {
				if (tabela.get(linha).get(i) == tabela.get(j).get(i)) {
					return false;
				}
			}

		}
		
		return true;
	}
	
	private boolean ajustarColuna(int linha) {

		int contador = 0;

		for (int i = 0; i < 9; i++) {
			for (int j = 1; j < linha; j++) {
				if (tabela.get(linha).get(i) == tabela.get(j).get(i)) {
					//System.out.println("tem repetido na coluna" + linha);
					tabela.put(linha, listaEmbaralhada());
					i = 0;
					j = 1;
					contador++;
				}
			}

		}
		
		System.out.println(contador);

		return true;
	}

	public Map<Integer, List<Integer>> gerarTabuleiro2() {

		listasEmbaralhadas();
		
		System.out.println("entrando no gerar tabuleiro...");
		
		while (tabela.get(2).subList(0, 3).stream().anyMatch(n -> tabela.get(1).subList(0, 3).contains(n))
				|| tabela.get(2).subList(3, 6).stream().anyMatch(n -> tabela.get(1).subList(3, 6).contains(n))
				|| tabela.get(2).subList(6, 9).stream().anyMatch(n -> tabela.get(1).subList(6, 9).contains(n))) {
			
			tabela.put(2, listaEmbaralhada());
			
		}
		

		while (tabela.get(3).subList(0, 3).stream().anyMatch(n -> tabela.get(1).subList(0, 3).contains(n))
				|| tabela.get(3).subList(3, 6).stream().anyMatch(n -> tabela.get(1).subList(3, 6).contains(n))
				|| tabela.get(3).subList(6, 9).stream().anyMatch(n -> tabela.get(1).subList(6, 9).contains(n))
				|| tabela.get(3).subList(0, 3).stream().anyMatch(n -> tabela.get(2).subList(0, 3).contains(n))
				|| tabela.get(3).subList(3, 6).stream().anyMatch(n -> tabela.get(2).subList(3, 6).contains(n))
				|| tabela.get(3).subList(6, 9).stream().anyMatch(n -> tabela.get(2).subList(6, 9).contains(n))) {
			
			tabela.put(3, listaEmbaralhada());
		}

		ajustarColuna(4);
		
		System.out.println("ajustado até a 4 linha");

		ajustarColuna(5);
		
		
		while ( tabela.get(5).subList(0, 3).stream().anyMatch(n -> tabela.get(4).subList(0, 3).contains(n))
				|| tabela.get(5).subList(3, 6).stream().anyMatch(n -> tabela.get(4).subList(3, 6).contains(n))
				|| tabela.get(5).subList(6, 9).stream().anyMatch(n -> tabela.get(4).subList(6, 9).contains(n))) {
			
			tabela.put(5, listaEmbaralhada());
			ajustarColuna(5);
		}

		ajustarColuna(6);
		
		
		System.out.println("entrando na linha 6 " + Date.from(Instant.now()).toString() );
		while (!colunaOK(6) 
				|| tabela.get(6).subList(0, 3).stream().anyMatch(n -> tabela.get(4).subList(0, 3).contains(n))
				|| tabela.get(6).subList(3, 6).stream().anyMatch(n -> tabela.get(4).subList(3, 6).contains(n))
				|| tabela.get(6).subList(6, 9).stream().anyMatch(n -> tabela.get(4).subList(6, 9).contains(n))
				|| tabela.get(6).subList(0, 3).stream().anyMatch(n -> tabela.get(5).subList(0, 3).contains(n))
				|| tabela.get(6).subList(3, 6).stream().anyMatch(n -> tabela.get(5).subList(3, 6).contains(n))
				|| tabela.get(6).subList(6, 9).stream().anyMatch(n -> tabela.get(5).subList(6, 9).contains(n))) {
			
			//System.out.println("while linha 6");
			tabela.put(6, listaEmbaralhada());
			ajustarColuna(6);
		}
		
		System.out.println("Saindo do 6 " + Date.from(Instant.now()).toString());

		ajustarColuna(7);

		ajustarColuna(8);
		
	
		while (tabela.get(8).subList(0, 3).stream().anyMatch(n -> tabela.get(7).subList(0, 3).contains(n))
				|| tabela.get(8).subList(3, 6).stream().anyMatch(n -> tabela.get(7).subList(3, 6).contains(n))
				|| tabela.get(8).subList(6, 9).stream().anyMatch(n -> tabela.get(7).subList(6, 9).contains(n))) {
			tabela.put(8, listaEmbaralhada());
			ajustarColuna(8);
		}

		ultimaLinha();

//		ajustarColuna(9);
//		
//		while(  tabela.get(9).subList(0, 3).stream().anyMatch(n -> tabela.get(7).subList(0, 3).contains(n)) || 
//				tabela.get(9).subList(3, 6).stream().anyMatch(n -> tabela.get(7).subList(3, 6).contains(n)) ||
//				tabela.get(9).subList(6, 9).stream().anyMatch(n -> tabela.get(7).subList(6, 9).contains(n)) ||
//				tabela.get(9).subList(0, 3).stream().anyMatch(n -> tabela.get(8).subList(0, 3).contains(n)) || 
//				tabela.get(9).subList(3, 6).stream().anyMatch(n -> tabela.get(8).subList(3, 6).contains(n)) ||
//				tabela.get(9).subList(6, 9).stream().anyMatch(n -> tabela.get(8).subList(6, 9).contains(n))){
//			tabela.put(9, listaEmbaralhada());                                
//			ajustarColuna(9);
//		}

		
		confirmarTabuleiro();
		
		return tabela;
	}
	
	
	public void confirmarTabuleiro() {
		
		int somatorio = 0;
		
		for (int i = 0; i < 9; i++) {
			for (int i2 = 1; i2 < 10; i2++) {
				somatorio += tabela.get(i2).get(i).intValue();
			}

			if(somatorio != 45) {
				System.out.println("tabela inválida");
			}
			System.out.println("o somatorio da coluna  " + (i+1) + somatorio);
			somatorio = 0;
			
		}
		
	}

	private void ultimaLinha() {
		int somatorio = 45;

		for (int i = 0; i < 9; i++) {
			for (int i2 = 1; i2 < 9; i2++) {
				//System.out.println(somatorio + " inicio  - " + tabela.get(i2).get(i).intValue());
				somatorio = somatorio - tabela.get(i2).get(i).intValue();
				tabela.get(9).set(i, somatorio);
				//System.out.println(somatorio + " Linha " + i + " Coluna " + i2);
			}

			somatorio = 45;
		}
		System.out.println("ultima linha");
	}

	public void imprimirTodas() {

		for (int i = 1; i < 10; i++) {
			tabela.get(i).stream().forEach(n -> System.out.print(n + ", "));
			System.out.println();
		}

	}

	private List<Integer> listaEmbaralhada() {
		Collections.shuffle(tab);
		List<Integer> l1 = new ArrayList<Integer>();
		tab.stream().forEach(f -> l1.add(f));
		return l1;
	}
	
	
	
	private void tabelaDeTeste() {
		t1.put(0, Arrays.asList(6, 1, 7, 9, 5, 3, 2, 8, 4));
		t1.put(1, Arrays.asList(2, 4, 9, 1, 8, 6, 5, 3, 7));
		t1.put(2, Arrays.asList(8, 3, 5, 7, 4, 2, 9, 1, 6));
		t1.put(3, Arrays.asList(3, 9, 2, 4, 7, 5, 1, 6, 8));
		t1.put(4, Arrays.asList(4, 6, 8, 2, 9, 1, 7, 5, 3));
		t1.put(5, Arrays.asList(5, 7, 1, 6, 3, 8, 4, 9, 2));
		t1.put(6, Arrays.asList(7, 5, 6, 3, 2, 9, 8, 4, 1));
		t1.put(7, Arrays.asList(1, 8, 4, 5, 6, 7, 3, 2, 9));
		t1.put(8, Arrays.asList(9, 2, 3, 8, 1, 4, 6, 7, 5));
		
	}
	
	private void listasEmbaralhadas() {

		for (int i = 1; i < 10; i++) {
			Collections.shuffle(tab);
			List<Integer> l1 = new ArrayList<Integer>();
			tab.stream().forEach(f -> l1.add(f));
			tabela.put(i, l1);
		}

	}

	public static void main(String[] args) {

		Tabuleiro tab = new Tabuleiro();
		tab.gerarTabuleiro2();
		tab.imprimirTodas();
		
		System.out.println(tab.tabela.get(1).get(2));
		
		tab.tabelaDeTeste();
		System.out.println(tab.t1.get(2).get(0));

	}

}
