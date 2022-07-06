package com.generation.farmacia.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.farmacia.model.Produto;
import com.generation.farmacia.repository.ProdutoRepository;



@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*", allowedHeaders = "*" )
public class ProdutoController {
	
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public ResponseEntity<List<Produto>> getAll(){
		return ResponseEntity.ok(produtoRepository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> getById(@PathVariable Long id) {
		return produtoRepository.findById(id)
			.map(resposta -> ResponseEntity.ok(resposta))
			.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Produto>> getByNome(@PathVariable String nome){
		return ResponseEntity.ok(produtoRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	/*
	 * @PostMapping: Anotação que indica que o método abaixo responderá todas
	 * as requisições do tipo POST que forem enviadas no endpoint /produto
	 * 
	 * Método ResponseEntity<Produto> postProduto (@RequestBody Produto produto) será do tipo 
	 * ResponseEntity porque ele responderá a requisição (Request), com uma HTTP Response (Resposta http), 
	 * neste caso Response Status 201 => CREATED
	 * 
	 */
	
	
	//Metodo antigo de fazer post, ocorre que com esse metodo voce consegue fazer a criação de um produto mesmo que ele já exista
	//att esse metodo com if
	@PostMapping
	public ResponseEntity<Produto> postProduto (@Valid @RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
	}
	
	
	/* Editar uma postagem 
	 * 
	 * @PutMapping:indica que o método abaixo responderá todas as requisições do tipo PUT que forem enviadas no endpoint /postagens
	 * 
	 * @Valid: Valida o Objeto Produto enviado no corpo da requisição (Request Body), conforme as regras
	 * definidas na Model Produto. Caso algum atributo não seja validado, o método retornará um status
	 * 400 => Bad Request.
	 * 
	 * @RequestBody Produto produto: Anntotation (anotação) que insere o objeto do tipo Produto enviado
	 * no corpo da requisição (Request Body) e insere no parâmetro produto do método postProduto
	 * 
	 * .map(resposta -> ResponseEntity.ok().body(produtoRepository.save(produto))): Se a produto existir, a função 
	 *  map (tipo Optional), executa o método save(produto) e retorna o status OK = 200 se o objeto Produto foi 
	 *  atualizado na tabela produto no Banco de dados.
	 * 
	 * .orElse(ResponseEntity.notFound().build());: Se o produto não for encontrada pelo método findById(poroduto.getId()), 
	 * retorna o status Not Found = 404
	 */
	
	@PutMapping
	public ResponseEntity<Produto> putProduto (@Valid @RequestBody Produto produto){
		
		return produtoRepository.findById(produto.getId())
			.map(resposta -> ResponseEntity.ok().body(produtoRepository.save(produto)))
			.orElse(ResponseEntity.notFound().build());
	}
	
    /*Deletar uma produto
	 *   
	 * @DeleteMapping("/{id}"):indica que o método abaixo responderá todas
	 * as requisições do tipo DELETE que forem enviadas no endpoint /produto/id
	 * 
	 * @PathVariable Long id: insere a variável de path (caminho ou url do endpoint), 
	 * passada no endereço da requisição, e insere no parâmetro id do método deleteProduto
	 * 
	 * <?>: O ?, no contexto de genéricos, basicamente serve como um coringa, ou seja, ele representa "qualquer tipo".
	 * logo você não está definindo um tipo específico 
	 * para retorno. Como Delete não retorna nada, o tipo ResponseEntity<Void> é o tipo genérico que será retornado.
	 * 
	 *  */
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduto(@PathVariable Long id) {
		
		return produtoRepository.findById(id)
				.map(resposta -> {
					produtoRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
	
	
}
