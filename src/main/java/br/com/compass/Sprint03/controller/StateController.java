package br.com.compass.Sprint03.controller;

import br.com.compass.Sprint03.models.dto.StateDto;
import br.com.compass.Sprint03.models.entity.State;
import br.com.compass.Sprint03.models.form.StateForm;
import br.com.compass.Sprint03.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

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

    @GetMapping("/states")
    public List<StateDto> getAllStates() {
        List<State> states = stateRepository.findAll();
        return StateDto.toStateDto(states);
    }
}
