package com.generation.farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.farmacia.model.Categoria;

/* @Repository: indica que a Interface é do tipo repositório
 * é responsável pela comunicação com o Banco de dados através dos métodos
 * padrão e das Method Queries
 * 
 * 1) A Classe Categoria, que é a Entidade (Tabela) que será mapeada em nosso Banco de dados 
 * (Classe Categoria foi quem gerou a nossa tabela tb_categoria)
 * 
 * 2) O Long representa a nossa (Primary Key), que é o atributo que 
 * recebeu a anotação @Id na Classe Produto (o atributo se chama id em nossa Classe Produto).
 * 
 */

@Repository
public interface CategoriaRepository  extends JpaRepository<Categoria, Long>{
	
	public List<Categoria> findAllByCategoriaContainingIgnoreCase (@Param("medicamentos") String medicamentos);

	

}
