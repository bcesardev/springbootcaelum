package br.com.cesar.bruno.projectBC.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.cesar.bruno.projectBC.models.Aluno;

@Repository
public interface AlunoDao extends MongoRepository<Aluno, String> {
	
	Aluno findByIdade(Integer idade);

}
