package ru.xpendence.webstruct.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.xpendence.webstruct.dto.AbstractDto;
import ru.xpendence.webstruct.service.CrudService;

import java.util.List;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 11.05.19
 * Time: 18:34
 * e-mail: 2262288@gmail.com
 */
public interface CrudController<D extends AbstractDto> {

    @PostMapping
    ResponseEntity<D> save(@RequestBody D dto);

    @PostMapping("/all")
    ResponseEntity<List<D>> saveAll(@RequestBody List<D> dtoList);

    @PutMapping
    ResponseEntity<D> update(@RequestBody D dto);

    @GetMapping
    ResponseEntity<D> get(@RequestParam Long id);

    @GetMapping("/all")
    ResponseEntity<Page<D>> getAll(Pageable pageable);

    @DeleteMapping
    ResponseEntity<Boolean> delete(@RequestParam Long id);

    @DeleteMapping("/all")
    ResponseEntity<Boolean> deleteAll();
}
