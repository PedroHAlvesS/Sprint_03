package br.com.compass.Sprint03.controller;

import br.com.compass.Sprint03.models.entity.State;
import br.com.compass.Sprint03.models.form.StateForm;
import br.com.compass.Sprint03.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api")
public class StateController {

    @Autowired
    StateRepository stateRepository;

    @PostMapping("/states")
    @Transactional
    public ResponseEntity<?> createState(@RequestBody StateForm form) {
        State state = form.toState();
        stateRepository.save(state);
        return ResponseEntity.ok().build();
    }

    
}
