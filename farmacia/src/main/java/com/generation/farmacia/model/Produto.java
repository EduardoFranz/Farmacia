package com.generation.farmacia.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;


/* @Entity indica que a classe é uma entidade,vai gerar uma tabela
 * @Table indica o nome da tabela no Banco de dados
 */

@Entity 					
@Table(name = "tb_produto") 
public class Produto {


		//atributos da minha tabela produto
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@NotBlank(message = "O atributo nome é Obrigatório e não pode utilizar espaços em branco!") 
		@Size(min = 5, max = 100, message = "O atributo nome deve conter no mínimo 05 e no máximo 100 caracteres")
		private String nome;
		
		@NotNull
		@Column(columnDefinition = "decimal(10,2)")
		private double valorUnitario;
		
		//Indica se o atributo receberá um Timestamp (Data e hora do sistema)
		@UpdateTimestamp
		private LocalDateTime data;
		
		@NotNull
		@Size (min = 10 , max = 500)
		private String descricao;
		
		@Min(1)
		private int quantidade;
		
		

		//Getters e Setters
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public double getValorUnitario() {
			return valorUnitario;
		}
		public void setValorUnitario(double valorUnitario) {
			this.valorUnitario = valorUnitario;
		}
		public LocalDateTime getData() {
			return data;
		}
		public void setData(LocalDateTime data) {
			this.data = data;
		}
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		public int getQuantidade() {
			return quantidade;
		}
		public void setQuantidade(int quantidade) {
			this.quantidade = quantidade;
		}

	}

