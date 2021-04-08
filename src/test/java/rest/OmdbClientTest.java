package rest;


import java.math.BigDecimal;
import java.time.Duration;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.rest.OmdbClient;

public class OmdbClientTest {

	@Test
	public void testEncodeTituloFilmeSemEspacos() {
		OmdbClient client = new OmdbClient();
		Filme filme = new Filme("Rambo", Duration.ofMinutes(100), "Ação", new BigDecimal("10.00"));
		String tituloEncoded = client.encodeTituloFilme(filme);
		Assert.assertEquals("Rambo", tituloEncoded);
	}
	
	@Test
	public void testEncodeTituloFilmeComEspacos() {
		OmdbClient client = new OmdbClient();
		Filme filme = new Filme("Rambo a missão", Duration.ofMinutes(100), "Ação", new BigDecimal("10.00"));
		String tituloEncoded = client.encodeTituloFilme(filme);
		Assert.assertEquals("Rambo+a+miss%C3%A3o", tituloEncoded);
	}
	
	@Test
	public void testEncodeTituloFilmeComEComercial() {
		OmdbClient client = new OmdbClient();
		Filme filme = new Filme("Thelma & Luiza", Duration.ofMinutes(100), "Ação", new BigDecimal("10.00"));
		String tituloEncoded = client.encodeTituloFilme(filme);
		Assert.assertEquals("Thelma+%26+Luiza", tituloEncoded);
	}

}
