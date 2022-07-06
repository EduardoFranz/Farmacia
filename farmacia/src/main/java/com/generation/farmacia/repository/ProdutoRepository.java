package com.generation.farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.farmacia.model.Produto;

/* @Repository: é responsável pela comunicação com o Banco de dados através dos métodos
 * padrão e das Method Queries (Métodos Personalizados), que são as consultas personalizadas 
 * criadas através de palavras chave que representam as instruções da linguagem SQL.
 * 
 */

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	/**
	 * Method Query equivalente a instrução SQL: 
	 * SELECT * FROM tb_postagem where nome like "%nome%";
	 * 
	 */
	public List<Produto>findAllByNomeContainingIgnoreCase(@Param("nome") String nome);

	
	
}
