package br.com.agenda.aplicacao;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contatos;

public class Main {

	public static void main(String[] args) {
		ContatoDAO contatoDao = new ContatoDAO();
		Contatos contato = new Contatos();
		
		//Testes CREATE:
		/*contato.setNome("Charles");
		contato.setCpf("11111111111");
		contatoDao.save(contato);*/
		
		
		//Testes READ:
		//Visualização dos registros do banco de dados
		
		/*forEach
		 * Sintaxe: for(<Tipo> <identificação> : <array ou coleção>){
		 				comando
		 			}
		 */
		
		
		//Atualizar cadastro
		/*Contatos c1 = new Contatos();
		c1.setNome("Rosa");
		c1.setCpf("22222222222");
		c1.setId(1);
		
		contatoDao.update(c1);
		
		for(Contatos c: contatoDao.getContatos()) {
			System.out.println("Nome: "+c.getNome());
			System.out.println("CPF: "+c.getCpf());
			System.out.println("Id: "+c.getId());
			System.out.println();
		}*/
		
		//delete
		//contatoDao.deleteByID(1);
	}

}
