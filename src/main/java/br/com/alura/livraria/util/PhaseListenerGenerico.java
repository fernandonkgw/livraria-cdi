package br.com.alura.livraria.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.alura.livraria.jsf.phaselistener.PhaseListenerObserver;

public class PhaseListenerGenerico implements PhaseListener {

	private static final long serialVersionUID = 1222756582732323860L;

	private PhaseListenerObserver observer = new PhaseListenerObserver();
	
	@Override
	public void afterPhase(PhaseEvent event) {
		observer
			.after()
			.fire(event);
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		observer
			.before()
			.fire(event);
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}
	
}
