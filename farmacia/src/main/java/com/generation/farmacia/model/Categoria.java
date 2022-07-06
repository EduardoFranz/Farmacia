package com.generation.farmacia.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_categoria")
public class Categoria {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@NotBlank(message = "A categoria é obrigatória e não pode conter espaços em branco")
		private String medicamentos;
		
		@NotBlank(message = "A categoria é obrigatória e não pode conter espaços em branco")
		private String genericos;
		
		@NotBlank(message = "A categoria é obrigatória e não pode conter espaços em branco")
		private String dermocosmeticos;
		
		@NotBlank(message = "A categoria é obrigatória e não pode conter espaços em branco")
		private String servicos;
		
		@NotBlank(message = "A categoria é obrigatória e não pode conter espaços em branco")
		private String infantil;
		
		@NotBlank(message = "A categoria é obrigatória e não pode conter espaços em branco")
		private String promocoes;
		
		
		/*  @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL): indica 
		 *  que a Classe Categoria terá um relacionamento do tipo One To Many (Um para Muitos) com a Classe 
		 *  Produto
		 * 
		 *  @JsonIgnore para ignorar um dos lados do relacionamento , quebrando assim a cadeia de recursão infinita.
		 *  
		 *  mappedBy = "categoria": Indica qual Objeto será utilizado como "chave estrangeira" no relacionamento,
		 *  entre o objeto categoria inserido na Classe Produto
		 *  
		 *  cascade = CascadeType.REMOVE: Se apagar algum objeto da classe Categoria, automaticamente 
		 *  propagará para todos os respectivos objetos associados ao Objeto Tema apagado.
		 *  
		 *  private List<Produto> produto listará todas os produtos associados com os respectivas categorias.
		 */
		
		@OneToMany(mappedBy = "categoria", cascade = CascadeType.REMOVE)
		@JsonIgnoreProperties("categoria")
		private List<Produto> produto;
		
		
		
		public List<Produto> getProduto() {
			return produto;
		}
		public void setProduto(List<Produto> produto) {
			this.produto = produto;
		}
		//Getters e Setters
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getMedicamentos() {
			return medicamentos;
		}
		public void setMedicamentos(String medicamentos) {
			this.medicamentos = medicamentos;
		}
		public String getGenericos() {
			return genericos;
		}
		public void setGenericos(String genericos) {
			this.genericos = genericos;
		}
		public String getDermocosmeticos() {
			return dermocosmeticos;
		}
		public void setDermocosmeticos(String dermocosmeticos) {
			this.dermocosmeticos = dermocosmeticos;
		}
		public String getServicos() {
			return servicos;
		}
		public void setServicos(String servicos) {
			this.servicos = servicos;
		}
		public String getInfantil() {
			return infantil;
		}
		public void setInfantil(String infantil) {
			this.infantil = infantil;
		}
		public String getPromocoes() {
			return promocoes;
		}
		public void setPromocoes(String promocoes) {
			this.promocoes = promocoes;
		}
		
		
		
		
	
}
