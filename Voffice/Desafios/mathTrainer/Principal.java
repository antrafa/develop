import java.util.Scanner;
import java.util.Random;

public class Principal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String text = "";
		int perguntaAtual = 1,
			maxPerguntas = 1,
			answer = 0, 
			num = 0;
			
		Player jogador = new Player();

		boolean subiuNivel = false;

		String[][] regras = new String[10][3];

		//REGRAS PARA MOSTRAR AO USUÁRIO
		regras[0][0] = "10 perguntas. 1 ponto por acerto. \nPara atingir o próximo nível, faça 6 pontos.";
 		regras[1][0] = "10 perguntas. 2 pontos por acerto e -1 ponto por erro. \nPara atingir o próximo nível, faça 6 pontos.";
		regras[2][0] = "10 perguntas. 1 ponto por acerto. \nPara atingir o próximo nível, faça 6 pontos.";
		regras[3][0] = "10 perguntas. 1 ponto por acerto e mais 2 pontos se acertar 3 seguidas. -1 ponto por erro. Para atingir o próximo nível, você precisa acertar pelo menos 5.";
		regras[4][0] = "15 perguntas. 1 ponto por acerto e mais 2 pontos se acertar 3 seguidas. -1 ponto por erro. Você vs Computador. O computador deve acertar aleatoriamente entre 3 e 12 perguntas em cada rodada. O jogador vence se acertar mais que o computador;";
		regras[5][0] = "15 perguntas envolvendo os operadores de divisão, o resto de divisão e o operador ternário. Os operandos são números de ponto flutuante. Pontuação equivalente à do nível 4;";
		regras[6][0] = "15 perguntas envolvendo operadores de deslocamento de bits. Pontuação equivalente à do nível 4;";
		regras[7][0] = "15 perguntas envolvendo os operadores lógicos e os operadores de incremento e decremento. Pontuação equivalente à do nível 4;";
		regras[8][0] = "15 perguntas envolvendo os operadores bit a bit e o operador de inversão. Pontuação equivalente à do nível 4;";
		regras[9][0] = "Todos os operadores usados nos níveis anteriores. 2 pontos a mais para cada pergunta correta respondida em menos de 10 segundos. Usar o seguinte método para recuperar o momento atual:";
		
		//PERGUNTAS MÁXIMAS
		regras[0][1] = "10";
		regras[1][1] = "10";
		regras[2][1] = "10";
		regras[3][1] = "10";
		regras[4][1] = "15";
		regras[5][1] = "15";
		regras[6][1] = "15";
		regras[7][1] = "15";
		regras[8][1] = "15";
		regras[9][1] = "1000";

		Principal.limparTela();

		System.out.println("----------------------------------------------------");
		System.out.println("Bem-vindo ao Math Trainer.\nPreparado para superar seus limites?");
		System.out.println("----------------------------------------------------\n");

		System.out.print("Para começar, insira seu nome: ");
		text = sc.next();
		System.out.println("----------------------------------------------------");
		System.out.print("Seja bem vindo " + text + ". \n\nVocê está preparado para testar seus conhecimentos? (s/n) ");
		text = sc.next();

		if(text.equals("s")){

			Principal.limparTela();

			System.out.println("----------------------------------------------------");
			System.out.println("Show de bola. Atualmente seu nível é " + jogador.level + ", e " + jogador.score + " pontos.");
			System.out.println("Para subir de nível é fácil, basta acertar perguntas :P . ");
			System.out.println("A cada nível seus pontos serão zerados, e uma vez atingido, um nível \nsuperior, não há possibilidades de  retornar ao nível anterior.\n");
			System.out.println("Bora começaaaaar!!! ");
			System.out.println("----------------------------------------------------");
			System.out.println("\n\n");

			while(true){

				Principal.limparTela();

				if(jogador.level != jogador.levelAnterior){
					jogador.levelAnterior = jogador.level;
					System.out.println("----------------------------------------------------");
					System.out.println("Regras deste nível.");
					System.out.println(regras[(jogador.level - 1)][0]);
					System.out.println("----------------------------------------------------");
					System.out.println("\n\n");
				}

				num = Principal.gerarPergunta(jogador.level,perguntaAtual);
				
				text = sc.next();
				answer = Integer.parseInt(text);

				if(answer == num){
					String mensagem = "";
					switch(jogador.level){
						case 1:
						case 3:
							mensagem = "Certa resposta !!!!\nVocê acaba de marcar um ponto.\n";
							jogador.score++;
						break;
						case 2:
							mensagem = "Certa resposta !!!!\nVocê acaba de marcar dois ponto.\n";
							jogador.score += 2;
						break;
					}
					System.out.println(mensagem);
				}else{
					String mensagem = "";
					switch(jogador.level){
						case 1:
						case 3:
							mensagem = "Puts, errou !!!!\nVocê não marcou pontos agora.\n";
						break;
						case 2:
							mensagem = "Puts, errou !!!!\nVocê acaba de perder um ponto.\n";
							jogador.score--;
							if(jogador.score < 0) jogador.score = 0;
						break;
					}
					System.out.println(mensagem);
				}

				subiuNivel = Principal.subirNivel(jogador.level,jogador.score);

				if(subiuNivel){
					subiuNivel = false;
					jogador.level++;
					jogador.score = 0;
					perguntaAtual = 0;
				}

				System.out.print("Deseja continuar?(s/n) ");
				text = sc.next();

				if(text.equals("n")){
					break;
				}else{
					perguntaAtual++;
					if(perguntaAtual > Integer.parseInt(regras[(jogador.level - 1)][1])){ //CHEGOU NA ULTIMA PERGUNTA DO NÍVEL
						
						Principal.limparTela();

						System.out.println("Opa, você acabou de responder a última pergunta deste nível.");
						System.out.println("Estamos analizando seu progresso.");
						Principal.subirNivel(jogador.level,jogador.score);

						System.out.println("Infelizmente seus créditos acabaram  ¯\\_(ツ)_/¯.");
						System.out.println("Você terminou sua jornada no nível " + jogador.level + " e com " + jogador.score + " pontos.");
						System.out.println("----------------------------------------------------");
						System.out.println("----------------------------------------------------");
						System.out.println("----------------------------------------------------\n\n");
						break;
					}
				}

			}

		}else{
			System.out.println("----------------------------------------------------");
			System.out.println("Que pena. Estava apostando minhas fichas em você. ¯\\_(ツ)_/¯");
			System.out.println("Quem sabe na próxima.");
			System.out.println("----------------------------------------------------");
		}


	}

	public static void limparTela(){
		//LIMPAR A TELA ¯\_(ツ)_/¯
		for (int i = 0; i < 30 ; i++) {
			System.out.println("");
		}
	}

	public static int gerarPergunta(int level, int perguntaAtual){
		int num = 0, 
			operando1 = 0, 
			operando2 = 0, 
			min = 0, 
			max = 100;

		operando1 = min + (new Random().nextInt(max - min));
		operando2 = min + (new Random().nextInt(max - min));

		switch(level){
			case 1:
				System.out.print("Pergunta " + perguntaAtual + " - Quanto é " + operando1 + " + " + operando2 + "? ");
				num = operando1 + operando2;
				break;

			case 2:
				System.out.print("Pergunta " + perguntaAtual + " - Quanto é " + operando1 + " + " + operando2 + "? ");
				num = operando1 + operando2;
				break;

			case 3:
				System.out.print("Pergunta " + perguntaAtual + " - Quanto é " + operando1 + " + " + operando2 + "? ");
				num = operando1 + operando2;
				break;
		}

		return num;
	}

	public static boolean subirNivel(int levelAtual, int score){
		System.out.println("Seu nível atual é "+levelAtual+" e você possui "+score+" pontos.");

		switch(levelAtual){
			case 1:
			case 2:
			case 3:
				if(score >= 6) {//subiu de nível
					System.out.println("\n----------------------------------------------------");
					System.out.println("Você acaba de subir de nível.");
					System.out.println("Seu nível atual é "+(levelAtual + 1)+" e seus pontos foram reiniciados.");
					System.out.println("----------------------------------------------------\n");
					return true;
				}
			break;
		}

		return false;

	}

}