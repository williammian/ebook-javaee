package com.wm.financeiro.controller;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.wm.financeiro.model.Pessoa;
import com.wm.financeiro.relatorio.Relatorio;
import com.wm.financeiro.repository.Pessoas;

@Named
@RequestScoped
public class RelatorioPessoasBean {
	
	@Inject
	private Pessoas pessoas;
	
	public void relatorioBD() {
		Relatorio<Pessoa> report = new Relatorio<Pessoa>();
		
		List<Pessoa> lista = pessoas.todas(); 
		
		if (lista.size() > 0) {
			report.getRelatorio();
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não há registros!"));
		}
	}
	
	public void relatorioLista() {
		Relatorio<Pessoa> report = new Relatorio<Pessoa>();
		
		List<Pessoa> lista = pessoas.todas(); 
		
		if (lista.size() > 0) {
			report.getRelatorio(lista);
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não há registros!"));
		}
	}

}
