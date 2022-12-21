package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contatos;

public class ContatoDAO {
	/*
	 * CRUD: Creat (INSERT TO), Read (SELECT FROM), Update (UPDATE), Delete (DELETE)
	 */
	
	//Método para CREAT
	public void save(Contatos contato) {
		String sql = "INSERT INTO clientes(nome, cpf) VALUES(?,?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar uma conexão com o banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//Criar uma PreparedStatement para executar o uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			//Adicionar os valores que são esperados
			pstm.setString(1, contato.getNome());
			pstm.setString(2, contato.getCpf());
						
			//Executar a query
			pstm.execute();
			System.out.println("Contato salvo com sucesso!");
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			//fechar as conexões
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	//Método para READ
	public List<Contatos> getContatos () {

		String sql = "SELECT * FROM clientes";
		
		List<Contatos> contatos = new ArrayList<Contatos>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		//Recupera os dados do banco de dados
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			while (rset.next()) {
				Contatos contato = new Contatos();
				
				//recuperar o ID
				contato.setId(rset.getInt("idCliente"));
				
				//recuperar o nome
				contato.setNome(rset.getString("nome"));
				
				//recuperar a CPF
				contato.setCpf(rset.getString("cpf"));
				
				contatos.add(contato);
			}
		} catch (Exception ex){
			ex.printStackTrace();
		}finally {
			try {
				if(rset!=null) {
					rset.close();
					}
				if(pstm!=null) {
					pstm.close();
					}
				if(conn!=null) {
					conn.close();
					}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}return contatos;
	} 

	//Método para UPDATE
	public void update (Contatos contato) {

		String sql = "UPDATE clientes SET nome =?, cpf=?"+"WHERE idCliente=?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar conexão com o banco
			conn = ConnectionFactory.createConnectionToMySQL();

			//Para executar a query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			//Adicionar os valores para atualizar
			pstm.setString(1, contato.getNome());
			pstm.setString(2, contato.getCpf());
						
			//Qual o ID do registro que deseja atualizar
			pstm.setInt(3, contato.getId());
			
			//Executar a Query
			pstm.execute();
			System.out.println("Contato atualizado com sucesso!");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	//Método para DELETE
	public void deleteByID(int id) {
		String sql = "DELETE FROM clientes WHERE idCliente = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			pstm.execute();
			System.out.println("Contato id deletado com sucesso!");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
