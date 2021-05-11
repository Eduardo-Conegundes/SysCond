package br.upe.syscond.dao;

import java.util.List;

import br.upe.syscond.models.FluxoAlmoxarifado;

public interface InterfaceFluxoAlmoxarifado {
	FluxoAlmoxarifado salvar(FluxoAlmoxarifado e) throws Exception;
    List<FluxoAlmoxarifado> listar() throws Exception;
    FluxoAlmoxarifado buscar(FluxoAlmoxarifado e) throws Exception;
    FluxoAlmoxarifado atualizar(FluxoAlmoxarifado e) throws Exception;
    void deletar(FluxoAlmoxarifado e) throws Exception;
}
