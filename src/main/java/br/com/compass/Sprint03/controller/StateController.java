package br.com.compass.Sprint03.controller;

import br.com.compass.Sprint03.models.domain.Region;
import br.com.compass.Sprint03.models.dto.StateDto;
import br.com.compass.Sprint03.models.entity.State;
import br.com.compass.Sprint03.models.form.StateForm;
import br.com.compass.Sprint03.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/states")
public class StateController {
    @Autowired
    StateRepository stateRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<StateDto> createState(@RequestBody @Valid StateForm form, UriComponentsBuilder uriBuilder) {
        State state = form.toState();
        stateRepository.save(state);
        URI uri = uriBuilder.path("/api/states/{id}").buildAndExpand(state.getId()).toUri();
        return ResponseEntity.created(uri).body(new StateDto(state));
    }

    @GetMapping
    public Page<StateDto> getAllStates(@RequestParam(required = false)String region, Pageable pageable) {
        if (region == null) {
            Page<State> states = stateRepository.findAll(pageable);
            return StateDto.toStateDto(states);
        } else {
            String regionDB = Region.valueOf(region.toUpperCase()).getNameCapitalize();
            Page<State> states = stateRepository.findByRegion(regionDB, pageable);
            return StateDto.toStateDto(states);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<StateDto> getStateFilterById(@PathVariable Long id) {
        Optional<State> stateOptional = stateRepository.findById(id);
        if (stateOptional.isPresent()) {
            return ResponseEntity.ok(new StateDto(stateOptional.get()));
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<StateDto> removeStateById(@PathVariable Long id) {
        Optional<State> stateOptional = stateRepository.findById(id);
        if (stateOptional.isPresent()) {
            stateRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<StateDto> updateState(@PathVariable Long id, @RequestBody @Valid StateForm form) {
        Optional<State> stateOptional = stateRepository.findById(id);
        if (stateOptional.isPresent()) {
            form.updateState(stateOptional.get());
            return ResponseEntity.ok(new StateDto(stateOptional.get()));
        }
        return ResponseEntity.notFound().build();
    }
}
