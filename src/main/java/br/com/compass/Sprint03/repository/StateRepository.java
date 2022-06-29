package br.com.compass.Sprint03.repository;

import br.com.compass.Sprint03.models.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
