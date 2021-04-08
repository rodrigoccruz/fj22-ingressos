package br.com.caelum.ingresso.controller;


import java.math.BigDecimal;
import java.time.Duration;
import java.util.Optional;

import br.com.caelum.ingresso.model.Filme;

public class TesteOptional1 {

	public static void main(String[] args) {
		
		String nome = getFilme(1).map(Filme::getNome).orElse("Filme não encontrado");
		
		System.out.println("O nome é: " + nome);
	}
	
	public static Optional<Filme> getFilme(Integer id) {
		if(id == 1) {
			return Optional.of(new Filme("Rambo", Duration.ofMinutes(100), "Ação", new BigDecimal("10.00")));
		} else {
			return Optional.empty();
		}
	}
}
