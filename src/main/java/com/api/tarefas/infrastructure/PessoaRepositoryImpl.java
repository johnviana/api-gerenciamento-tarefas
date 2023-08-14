package com.api.tarefas.infrastructure;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.api.tarefas.domain.model.Pessoa;
import com.api.tarefas.domain.repository.PessoaReposioryQuery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;



@Repository
public class PessoaRepositoryImpl implements PessoaReposioryQuery {
	
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Pessoa> find(String nome, 
			BigDecimal periodoInicial, BigDecimal periodoFinal){
		
		var jpql  = new StringBuilder();
		jpql.append("from Pessoa where 0 = 0 ");
		
		var paramentros = new HashMap<String, Object>();
		
		if(StringUtils.hasLength(nome)) {
			jpql.append("and nome like :nome ");
			paramentros.put("nome", "%" + nome + "%");
		}
		
		if(periodoInicial != null) {
			jpql.append(" and periodo >= :periodoInicio " );
			paramentros.put("periodoInicio", periodoInicial);
		}
		
		if(periodoFinal != null) {
			jpql.append("and periodo <= :periodoFim ");
			paramentros.put("periodoFim", periodoFinal);
		}
		
		TypedQuery<Pessoa> query = manager.createQuery(jpql.toString(), Pessoa.class);
		
		paramentros.forEach((chave, valor) -> query.setParameter(chave, valor));
		
		return query.getResultList();
		
	}

}
