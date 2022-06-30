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

import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StateController {

    @Autowired
    StateRepository stateRepository;

    @PostMapping("/states")
    @Transactional
    public ResponseEntity<StateDto> createState(@RequestBody @Valid StateForm form, UriComponentsBuilder uriBuilder) {
        State state = form.toState();
        stateRepository.save(state);
        URI uri = uriBuilder.path("/api/states/{id}").buildAndExpand(state.getId()).toUri();
        return ResponseEntity.created(uri).body(new StateDto(state));
    }

    @GetMapping("/states")
    public List<StateDto> getAllStates() {
        List<State> states = stateRepository.findAll();
        return StateDto.toStateDto(states);
    }
}
