package ru.xpendence.webstruct.service;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.xpendence.webstruct.dto.AbstractDto;
import ru.xpendence.webstruct.entity.AbstractEntity;
import ru.xpendence.webstruct.enumeration.ErrorType;
import ru.xpendence.webstruct.exception.DatabaseException;
import ru.xpendence.webstruct.mapper.EntityDtoMapper;
import ru.xpendence.webstruct.repository.AbstractRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 11.05.19
 * Time: 19:20
 * e-mail: 2262288@gmail.com
 */
public abstract class AbstractService<
        E extends AbstractEntity,
        D extends AbstractDto,
        M extends EntityDtoMapper<E, D>,
        R extends AbstractRepository<E>
        > implements CrudService<D> {


    private final R repository;
    private final M mapper;

    @Autowired
    public AbstractService(R repository, M mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public D save(D dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public List<D> saveAll(List<D> dtoList) {
        return repository.saveAll(dtoList.stream().map(mapper::toEntity).collect(Collectors.toList()))
                .stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public D get(Long id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(
                        () -> new DatabaseException(String.format(ErrorType.ENTITY_NOT_FOUND.getDescription(), id))
                )
        );
    }

    @Override
    public Page<D> getAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);
    }

    @Override
    public Boolean delete(Long id) {
        repository.deleteById(id);
        return !repository.findById(id).isPresent();
    }

    @Override
    public Boolean deleteAll() {
        repository.deleteAll();
        return Lists.newArrayList(repository.findAll()).isEmpty();
    }
}
