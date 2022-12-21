package br.com.agenda.aplicacao;

import java.util.Date;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

public class Main {

	public static void main(String[] args) {
		ContatoDAO contatoDao = new ContatoDAO();
		Contato contato = new Contato();
		
		//Testes CREATE:
		/*contato.setNome("João");
		contato.setIdade(20);
		contato.setDataCadastro(new Date());
		contatoDao.save(contato);
		*/
		
		//Testes READ:
		//Visualização dos registros do banco de dados
		
		/*forEach
		 * Sintaxe: for(<Tipo> <identificação> : <array ou coleção>){
		 				comando
		 			}
		 */
		
		
		//Atualizar cadastro
	/*	Contato c1 = new Contato();
		c1.setNome("Manuela");
		c1.setIdade(55);
		c1.setDataCadastro(new Date());
		c1.setId(2);
		
		contatoDao.update(c1);
		
		for(Contato c: contatoDao.getContatos()) {
			System.out.println("Contato: "+c.getNome());
			System.out.println("Idade: "+c.getIdade());
			System.out.println("Data Cadastro: "+c.getDataCadastro());
			System.out.println("Id: "+c.getId());
			System.out.println();
		}*/
		
		//delete
		//contatoDao.deleteByID(5);
	}

}
