package br.com.rbp;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;

public class ImagemArquivo {

	public void criarImagem(byte bytes[], int nome) throws IOException {

		InputStream in = new ByteArrayInputStream(bytes);
		BufferedImage imagem = ImageIO.read(in);
		ImageIO.write(imagem, "PNG", new File(nome + ".PNG"));
		in.close();

	}

	public void criarImagem(InputStream stream, int nome) throws IOException {
		BufferedImage imagem = ImageIO.read(stream);
		ImageIO.write(imagem, "PNG", new File(nome + ".PNG"));
		stream.close();
	}

	// apenas como exemplo

	public byte[] lerImagens() throws IOException {
		BufferedImage imagem = ImageIO.read(new File("images.jpg"));
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(imagem, "jpg", baos);
		baos.flush();
		byte[] imageInByte = baos.toByteArray();
		baos.close();
		return imageInByte;
	}

}
