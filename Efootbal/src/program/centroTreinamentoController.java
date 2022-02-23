package program;

import javax.swing.Icon;

import views.CentroTreinamento;

public class centroTreinamentoController {
	
	public void abrirCentroTreinamento(String nomeTime, Icon imagemtime) {
		CentroTreinamento centro = new CentroTreinamento(nomeTime);
		centro.setVisible(true);
	}
	
	
}
