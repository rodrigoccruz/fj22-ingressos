package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

import br.com.caelum.ingresso.desconto.Desconto;
import br.com.caelum.ingresso.desconto.DescontoParaBancos;
import br.com.caelum.ingresso.desconto.DescontoParaEstudantes;
import br.com.caelum.ingresso.desconto.SemDesconto;

public enum TipoDeIngresso {
	INTEIRO(new SemDesconto()), ESTUDANTE(new DescontoParaEstudantes()), BANCO(new DescontoParaBancos());

	private final Desconto desconto;

	TipoDeIngresso(Desconto desconto) {
		this.desconto = desconto;
	}

	public BigDecimal aplicaDesconto(BigDecimal valor) {
		return desconto.aplicarDescontoSobre(valor);
	}

	public String getDescricao() {
		return desconto.getDescricao();
	}
}
