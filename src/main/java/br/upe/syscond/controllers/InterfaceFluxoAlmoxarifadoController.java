package br.upe.syscond.controllers;

import java.util.List;
import br.upe.syscond.models.FluxoAlmoxarifado;

public interface InterfaceFluxoAlmoxarifadoController {
	public FluxoAlmoxarifado criar(FluxoAlmoxarifado conta) throws Exception;
	public List<FluxoAlmoxarifado> listar() throws Exception;
	public FluxoAlmoxarifado buscar(FluxoAlmoxarifado conta) throws Exception;
	public FluxoAlmoxarifado atualizar(FluxoAlmoxarifado nova) throws Exception;
	public void deletar(FluxoAlmoxarifado conta) throws Exception;
}
