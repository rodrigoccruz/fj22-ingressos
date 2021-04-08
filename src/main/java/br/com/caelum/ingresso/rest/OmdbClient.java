package br.com.caelum.ingresso.rest;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import br.com.caelum.ingresso.model.Filme;

@Component
public class OmdbClient {

	public <T> Optional<T> request(Filme filme, Class<T> tClass) {

		RestTemplate client = new RestTemplate();

		String titulo = encodeTituloFilme(filme);
		
		String url = String.format("https://omdb-fj22.herokuapp.com/movie?title=%s", titulo);

		try {
//			DetalhesDoFilme detalhesDoFilme = client.getForObject(url, DetalhesDoFilme.class);
			return Optional.of(client.getForObject(url, tClass));
		} catch (RestClientException e) {
			return Optional.empty();
		}

	}

	public String encodeTituloFilme(Filme filme) {
		String tituloEncoded;

		try {
			tituloEncoded = URLEncoder.encode(filme.getNome(), StandardCharsets.UTF_8.toString());
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}

		return tituloEncoded;
	}
}