package br.com.compass.Sprint03.repository;

import br.com.compass.Sprint03.models.entity.State;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StateRepository extends JpaRepository<State, Long> {
    Page<State> findByRegion(String Region, Pageable pageable);
}
