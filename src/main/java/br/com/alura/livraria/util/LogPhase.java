package br.com.alura.livraria.util;

import javax.enterprise.event.Observes;
import javax.faces.event.PhaseEvent;

import br.com.alura.livraria.jsf.phaselistener.After;
import br.com.alura.livraria.jsf.phaselistener.Phase;
import br.com.alura.livraria.jsf.phaselistener.Phase.Phases;

public class LogPhase {

	public void log(@Observes @After @Phase(Phases.RESTORE_VIEW) PhaseEvent phaseEvent) {
		System.out.println("FASE: " + phaseEvent.getPhaseId());
	}
}
