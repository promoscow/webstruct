package ru.xpendence.webstruct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import ru.xpendence.webstruct.dto.AbstractDto;
import ru.xpendence.webstruct.service.CrudService;

import java.util.List;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 11.05.19
 * Time: 20:23
 * e-mail: 2262288@gmail.com
 */
public abstract class AbstractController<D extends AbstractDto, S extends CrudService<D>> implements CrudController<D> {

    private final S service;

    @Autowired
    protected AbstractController(S service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<D> save(D dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @Override
    public ResponseEntity<List<D>> saveAll(List<D> dtoList) {
        return ResponseEntity.ok(service.saveAll(dtoList));
    }

    @Override
    public ResponseEntity<D> update(D dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @Override
    public ResponseEntity<D> get(Long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @Override
    public ResponseEntity<Page<D>> getAll(Pageable pageable) {
        return ResponseEntity.ok(service.getAll(pageable));
    }

    @Override
    public ResponseEntity<Boolean> delete(Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

    @Override
    public ResponseEntity<Boolean> deleteAll() {
        return ResponseEntity.ok(service.deleteAll());
    }
}
