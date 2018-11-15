package br.edu.ifsp.bra.teste;

import java.text.SimpleDateFormat;

public class TestaData {
	public static void main(String[] args) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			java.sql.Date data = new java.sql.Date(format.parse("01/02/1999").getTime());
			System.out.println(data.toString());
		} catch (Exception ex) {
			System.out.println("Erro no parse para date da string");
		}
	}
}
