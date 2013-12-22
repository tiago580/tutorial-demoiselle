package br.gov.serpro.inscricao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;

import br.gov.frameworkdemoiselle.util.ResourceBundle;

public class Turma {
	
	private List<String> alunosMatriculados = new ArrayList<String>();
	
	@Inject
	ResourceBundle bundle;
	
	@Inject
	private Logger logger;
	
	public void matricular(String matricula){
		if(estaMatriculado(matricula) || alunosMatriculados.size() == 5){
			throw new RuntimeException();
		}
		alunosMatriculados.add(matricula);
		logger.info(bundle.getString("matricula.sucesso", matricula));;
	}
	
	public boolean estaMatriculado(String matricula){
		return alunosMatriculados.contains(matricula);
	}
}
