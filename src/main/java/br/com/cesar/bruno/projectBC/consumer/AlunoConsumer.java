package br.com.cesar.bruno.projectBC.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import br.com.cesar.bruno.projectBC.models.Aluno;

@Component
public class AlunoConsumer {

	@RabbitListener(queues = "queue.alunos")
	public void leMensagem(Aluno aluno) {
		System.out.println("[Consumer Alunos] recebendo mensagem: " + aluno);
	}
}
