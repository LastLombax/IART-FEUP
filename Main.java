


public class Main {
	public static void main(String[] args) {
		System.out.println("hello world!");
		
		//Algoritmos de evolu��o
		
		//1 - popula��o inicial
		
		//2 - alguns s�o selecionados (selected[] )
		
		//3 - os selected s�o emparelhados e cruzam entre si, criando os descendents[] -> reprodu��o
		
		//4 - possibilidade de os descendents[] sofrerem muta��o
		
		//5 - Se solu��o, end; se n�o, 2;
		
		
		// Indiv�duos -> acho que sao as sess�es(most likely) ou ent�o os dias.
		
		//Numero de Genes = Numero de atributos
		
		/*
		 * Sess�o tem:
		 * dura��o, tema, papers(2 full papers no minimo), apresentador 	
		 * Cada elemento seria um gene. 
		 */
		
		/*
		 * H� no maximo M sess�es. Logo, s�o 1...M individuos selecionados
		 * OU 1...M cromossomas como popula��o inicial(most likely)
		 * Durante 3 dias e, por dia, no m�ximo 4 horarios para sess�es, com coffee breaks e almo�o.
		 */
		
		//escala-se as variaveis para inteiros multiplicando-as por 10^n, onde n = precis�o
		//precis�o pode ser usada para diferentes desempenhos
		
		//Transformar novas vari�veis em forma bin�ria
		
		
		
		/*
		 * SELE��O
		 * fa(Ci) -> adapta��o do Cromossoma Ci(fun��o de adapta��o)
		 * Sum(fa(ci)) -> soma das adapta��es de toda a popula��o
		 * P(Ci escolhido) = fa(Ci)/Sum(fa(ci))
		 * S�o selecionados alguns daqui
		 */
		
		
		/*
		 * REPRODU��O
		 * Os eelcionados sao emparelhados aleatoriamente
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
		

	}

}
