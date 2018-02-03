package br.com.cesar.bruno.projectBC.controller;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cesar.bruno.projectBC.dao.AlunoDao;
import br.com.cesar.bruno.projectBC.models.Aluno;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	private AlunoDao dao;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;

	@PostMapping
	public void cadastrar(@RequestBody Aluno aluno) {
		dao.save(aluno);
		rabbitTemplate.convertAndSend("topico-eventos", "evento.aluno", aluno);	}
	
	@GetMapping({"idade"})
	public Aluno findBy(@PathVariable("idade") Integer idade){
		return dao.findByIdade(idade);
	}

	@GetMapping
	public List<Aluno> findAll(){
		return dao.findAll();
	}
}
