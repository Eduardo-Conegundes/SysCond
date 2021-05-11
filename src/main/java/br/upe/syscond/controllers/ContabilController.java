package br.upe.syscond.controllers;

import java.time.LocalDate;
import java.util.List;
import br.upe.syscond.dao.ContabilDAO;
import br.upe.syscond.dao.ContasDAO;
import br.upe.syscond.dao.InterfaceContabil;
import br.upe.syscond.dao.InterfaceContas;
import br.upe.syscond.models.Contabil;
import br.upe.syscond.models.Contas;

public class ContabilController implements InterfaceContabilController{

	private static InterfaceContas contasDAO = ContasDAO.getInstance();
	private static ContabilController instance;
	private InterfaceContabil contabilDAO = ContabilDAO.getInstance();
	private Contabil contabil;
	/**
	 * 
	 * @return--> Se existir uma contabil ele retornara a sua instancia, caso contrario ele criara a contabil.
	 * @throws--> se operacaoo  de verificacao ou de salva falhar, sera lancada uma Exception.
	 */
	public static ContabilController getInstance() throws Exception{
		if(instance == null) {
				instance = new ContabilController();
		}
		return instance;
	}
	public ContabilController() throws Exception {
		if(contabilDAO.listar().size()==0) {
				this.contabil = contabilDAO.salvar(new Contabil(null, 0));
		}else {
			this.contabil = contabilDAO.buscar(1);
		}
	}

	/**
	 * @param --> O metodo criar recebe um parametro conta-com todos atributos internalizados- do tipo conta para salvar no banco de dados.
	 * @return--> Caso a operacao de criar seja bem sucedida, ela retona uma conta salvo no banco de dados.
	 * @throws--> se operacaoo  de salva falhar, sera lancada uma Exception.
	 */ 
	public Contas criar(Contas conta)throws Exception{
			atualizaSaldo(conta, false);
			return contasDAO.salvar(conta);
	}
	
	/**
	 * @return--> Caso a operacao de listar seja bem sucedida, ela retona uma lista com todas as contas salvas no banco de dados.
	 * @throws--> se operacao de listar falhar, sera lancada uma Exception.
	 */
	public List<Contas> listar() throws Exception{
			return contasDAO.listar();
	}
	
	/**
	 * @param --> O metodo buscar recebe um parametro conta -com todos os atributos de uma conta- do tipo conta para realizar uma busca no banco de dados da conta solicitada.
	 * @return--> Caso aoperacao  de Buscar seja bem sucedida, ela retona a conta deseja que esta no Banco de dados. 
	 * @throws Exception--> se operacao de listar falhar, sera lancada uma Exception.
	 */
	public Contas buscar(Contas conta) throws Exception{
			return contasDAO.buscar(conta);
	}
	
	/**
	 * @param --> O metodo buscarPorData recebe um parametro data do tipo LocalDate  para Listar as contas naquela data que est�o cadastrada no banco de dados.
	 * @return--> Caso a operacao de listar por data seja bem sucedida, ela retona uma lista com todas as contas salvas no banco de dados pela data solicitada.
	 */
	public List<Contas> buscarPorData(LocalDate data) throws Exception{
			return contasDAO.listarPorData(data);
	}
	
	/**
	 * @param --> O metodo atualizar recebe um parametro nova-com um ou diversos atributos internalizados- do tipo conta para atualizar a conta antiga no banco de dados.
	 * @return--> Caso a operacao de atualizar seja bem sucedida, ela retona a contas com as informacoes atualizadas no banco de dados.
	 */
	public Contas atualizar(Contas nova) throws Exception{
			atualizaSaldo(nova, false);
			return contasDAO.atualizar(nova);
	}
	
	/**
	 * @param --> O metodo deletar recebe um parametro conta-com todos os atibutos atributos internalizados- do tipo conta para exclusao da conta solicitado banco de dados.
	 * @return--> Caso a operacao de deletar seja bem sucedida, ela retona o valor boleano TRUE.
	 */
	public void deletar(Contas conta) throws Exception{
			atualizaSaldo(conta, true);
			contasDAO.deletar(conta);
	}
	
	/**
	 * @param --> O metodo atualizaSaldo recebe um parametro conta-com todos os atibutos atributos internalizados- do tipo conta para efetuar a operacao solicitada e consequetemente atualizar o saldo da conta solicitado banco de dados.
	 * @return--> Caso a operacao de receber ou pagar uma conta seja efetuada com sucesso o metodo atualizaSaldo atuualizar� o saldo no banco e ela retonara o valor boleano TRUE.
	 * @throws se operacao  de deletar falhar, sera lancada uma Exception.
	 */
	private void atualizaSaldo(Contas conta, Boolean isDeletar) throws Exception {
		if(isDeletar) {
			if(conta.getStatusPaga()) {
				if(conta.getAReceber()) {
					this.contabil.setSaldo(this.contabil.getSaldo()+conta.getValor());
					try {
						contabilDAO.atualizar(contabil);
					} catch (Exception e) {
						throw e;
					}
				}else {
					if(this.contabil.getSaldo() >= conta.getValor()) {
						try {
							this.contabil.setSaldo(this.contabil.getSaldo()-conta.getValor());
							contabilDAO.atualizar(contabil);
						} catch (Exception e) {
							throw e;
						}
					}else {
						throw new Exception("Saldo Insuficiente");
					}
				}
			}
		}else {
			if(conta.getStatusPaga() ) {
				if(conta.getAReceber()) {
					this.contabil.setSaldo(this.contabil.getSaldo()-conta.getValor());
					try {
						contabilDAO.atualizar(contabil);
					} catch (Exception e) {
						throw e;
					}
				}else {
					this.contabil.setSaldo(this.contabil.getSaldo()+conta.getValor());
					try {
						contabilDAO.atualizar(contabil);
					} catch (Exception e) {
						throw e;
					}
				}
			}
		}

	}
}