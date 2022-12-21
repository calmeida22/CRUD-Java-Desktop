package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;

public class ContatoDAO {
	/*
	 * CRUD: Creat (INSERT TO), Read (SELECT FROM), Update (UPDATE), Delete (DELETE)
	 */
	
	//Método para CREAT
	public void save(Contato contato) {
		String sql = "INSERT INTO contatos(nome, idade, dataCadastro) VALUES(?,?,?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar uma conexão com o banco de dados
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//Criar uma PreparedStatement para executar o uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			//Adicionar os valores que são esperados
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
			
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
	public List<Contato> getContatos () {

		String sql = "SELECT * FROM contatos";
		
		List<Contato> contatos = new ArrayList<Contato>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		//Recupera os dados do banco de dados
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			while (rset.next()) {
				Contato contato = new Contato();
				
				//recuperar o ID
				contato.setId(rset.getInt("id"));
				
				//recuperar o nome
				contato.setNome(rset.getString("nome"));
				
				//recuperar a idade
				contato.setIdade(rset.getInt("idade"));
				
				//recuperar a data de cadastro
				contato.setDataCadastro(rset.getDate("datacadastro"));
				
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
	public void update (Contato contato) {

		String sql = "UPDATE contatos SET nome =?, idade=?, datacadastro=?"+"WHERE id=?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar conexão com o banco
			conn = ConnectionFactory.createConnectionToMySQL();

			//Para executar a query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			//Adicionar os valores para atualizar
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
			
			//Qual o ID do registro que deseja atualizar
			pstm.setInt(4, contato.getId());
			
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
		String sql = "DELETE FROM contatos WHERE id = ?";
		
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
