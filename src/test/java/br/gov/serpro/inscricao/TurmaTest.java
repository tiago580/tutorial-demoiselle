package br.gov.serpro.inscricao;

import javax.inject.Inject;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;

@RunWith(DemoiselleRunner.class)
public class TurmaTest {

	@Inject 
	Turma turma;
	
	@Test
	public void matricularAlunoComSucesso() {
		String matricula = "Tiago Vieira";
		turma.matricular(matricula);
		Assert.assertTrue(turma.estaMatriculado(matricula));
	}

	@Test(expected = RuntimeException.class)
	public void falhaAoTentarMatricularAlunoDuplicado() {
		String matricula = "Tiago Vieira";
		turma.matricular(matricula);
		turma.matricular(matricula);
	}
	
	@Test(expected = RuntimeException.class)
	public void falhaAoTentarMatricularAlunoTurmaCheia() {
		for (int i = 1; i <= 5; i++) {
			turma.matricular("Aluno " + i);
		}
		turma.matricular("Aluno 6");
	}

}
