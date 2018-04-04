import java.math.BigInteger;

public class Main {
	public static void main(String[] args) {
		System.out.println("hello world!");
		
		//Algoritmos de evolu��o
		
		//1 - popula��o inicial
		
		//2 - alguns s�o selecionados (selected[] )
		
		//3 - os selected s�o emparelhados e cruzam entre si, criando os descendents[] -> reprodu��o
		
		//4 - possibilidade de os descendents[] sofrerem muta��o
		
		//5 - Se solu��o, end; se n�o, 2;
		
		
		// Indiv�duos -> acho que sao as sess�es
		
		//Numero de Genes = Numero de atributos
		
		/*
		 * Sess�o tem:
		 * dura��o, tema, papers(2 full papers no minimo), apresentador, dia da apresenta��o
		 * Cada elemento seria um gene. 
		 */
		
		/*
		 * H� no maximo M sess�es. Logo, s�o 1...M individuos selecionados
		 * OU 1...M cromossomas como popula��o inicial(most likely)
		 * Durante 3 dias e, por dia, no m�ximo 4 horarios para sess�es, com coffee breaks e almo�o.
		 */
		
		//escala-se as variaveis para inteiros multiplicando-as por 10^n, onde n = precis�o
		//precis�o pode ser usada para diferentes desempenhos
		
		//Transformar novas vari�veis em forma bin�ria ou usar como ints compridos
		
		/*
		 * SELE��O
		 * fa(Ci) -> adapta��o do Cromossoma Ci(fun��o de adapta��o)
		 * Sum(fa(ci)) -> soma das adapta��es de toda a popula��o
		 * P(Ci escolhido) = fa(Ci)/Sum(fa(ci))
		 * S�o selecionados alguns daqui
		 */
		
		
		/*
		 * REPRODU��O
		 * Os selecionados sao emparelhados aleatoriamente
		 * Por par, com Pcrossover, pelo menos 1 crossover point � escolhido, de 1 a N(Cromossoma.size())
		 * Troca-se o material genetico
		 */
		
		/*
		 * MUTA��O
		 * Pode acontecer com Pm muito baixo
		 */
		
		
		/*
		 * Conclus�es tendo em conta o exemplo dos slides
		 * Cria-se 1...M cromossomas com tamanho = n� de atributos
		 * Estes cromossomas s�o inicializados aleatoriamente e em formato bin�rio
		 * Aplica-se fun��o de adapta��o a esses cromossomas
		 * Calcula-se a P(Ci escolhido) para cada
		 * Roleta para serem selecionados alguns // Ou o 1...M sess�es s�o aqui ou ent�o � no tamanho da popula��o
		 * CONFIRM AFTER ROLETA
		 * 
		 */	
		
		
		/*
		 * Combina��es dos Papers
		 * 30 30
		 1 Hora 	+ 20 + 20 + 20   = 60			111
					+ 30 + 30		 = 60			110
					+ 20 + 30        = 50			101
					+ 20 + 20 	  	 = 40			100
					+ 30			 = 30		 	011
					+ 20 			 = 20			010
				    + 0				 = 0			001
		 */
		
		
	/*
		FUN��O DE ADAPTA��O:
		Ap�s gerir popula��o 
		
		para cada um dos casos que estamos verificando, podemos atribuir um �fator de importancia�, 
		por exemplo, o fator de importancia para os temas de sessoes iguais � 0.2,
		o fator de importancia para o tema da sessao inserido nos papers � 0.5, etc
		dessa forma alem de calcularmos a fitness de cada uma das variantes, temos tamb�m um fator de
		importancia geral em relacao ao resto.
		
		�Filtrar� popula��o por dia. (criar 3 arrays, um por dia, e cada inclui sess�es para esse dia)
		
		* aqui podemos tamb�m comparar os dias e retonar um valor pra funcao fitness conforme a diferenca entre
		* o tempo das duracoes.
		* ou seja, se o primeiro dia tem 3 horas de papers, o segundo tem 6 horas, a diferneca � de 3 horas, 
		* o que retornaria um fitness baixo
		* mas se o priemiro dia tem 3 horas e o segundo tem 2 horas e meia, o retorno seria um finess alto. 
		* talvez isso entre em conflito com o item abaixo, conferir qual o melhor.
		
		Por cada array
			Verificar se h� temas de sess�es iguais
				Se sim, escolher o que tem maior dura��o(da table anterior, o mais acima)
						Se = dura��o, n�o h� problema
			
			Verificar se tema da sess�o est� contido nos temas dos papers
				buscar fitness relacionado com o n� papers associado ao tema
					(retornar valor maior se mais papers relacionados com o tema da sess�o)
					
			
			
			
			
			
							
		
		
	 */
		String a = "5"; //101
		System.out.println(Utilities.transform2Bin(5, 4));

	}
}
