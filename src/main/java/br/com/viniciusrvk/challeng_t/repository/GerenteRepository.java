package br.com.viniciusrvk.challeng_t.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.viniciusrvk.challeng_t.domain.Gerente;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente, Integer> {
}
