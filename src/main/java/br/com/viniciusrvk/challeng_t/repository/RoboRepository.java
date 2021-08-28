package br.com.viniciusrvk.challeng_t.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.viniciusrvk.challeng_t.domain.Robo;

@Repository
public interface RoboRepository extends JpaRepository<Robo, Integer> {
}
