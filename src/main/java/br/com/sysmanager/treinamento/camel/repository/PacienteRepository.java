package br.com.sysmanager.treinamento.camel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sysmanager.treinamento.camel.entity.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
