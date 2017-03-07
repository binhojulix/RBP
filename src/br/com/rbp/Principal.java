package br.com.rbp;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws SQLException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		logicaSalvarID();

	}

	public void testeSimples() throws InterruptedException {
		Scanner entrada = new Scanner(System.in);

		ControlePorta arduino = new ControlePorta("COM5", 9600);

		int dadosEnviados = 10;
		System.out.println("Digite 0 para sair ou qualquer outro numero para somar:");
		do {

			System.out.println("Digite o numero");
			dadosEnviados = entrada.nextInt();

			System.out.println("Enviando enviados ....");
			arduino.enviaDados(dadosEnviados);
			Thread.sleep(100);

			System.out.println("Recebendo dados ... ");
			int dadosRecebidos = arduino.receberDados(0);
			Thread.sleep(100);

			System.out.println("A multiplicação de " + dadosEnviados + " * 2 é: " + dadosRecebidos + " ...");

		} while (dadosEnviados != 0);

		arduino.close();
		System.out.println("Acabou...");
		System.exit(0);
	}

	public static void logicaSalvarID() throws IOException, InterruptedException {

		ImagemArquivo imagemArquivo = new ImagemArquivo();
		ControlePorta arduino = new ControlePorta("COM5", 9600);

		 byte[] bytesOriginal = imagemArquivo.lerImagens();//bytes da imagem original
		 System.out.println("tamanho " + bytesOriginal.length);
		 
		arduino.escreverImagem(bytesOriginal);
		byte[] bytesArduino = arduino.lerDigital(1);
		arduino.close();

		for (byte b : bytesArduino) {
			System.out.print(b + ",");
		}
		System.out.println(".");
		Thread.sleep(100);

		imagemArquivo.criarImagem(bytesArduino, 12);
		new ImagemDao().salvar(bytesArduino);

		
		System.out.println("\nAcabou...");
		System.exit(0);
	}

}
