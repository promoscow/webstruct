package ru.xpendence.webstruct.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.xpendence.webstruct.dto.AbstractDto;

import java.util.List;
import java.util.Optional;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 11.05.19
 * Time: 11:21
 * e-mail: 2262288@gmail.com
 */
public interface CrudService<D extends AbstractDto> {

    D save(D dto);

    List<D> saveAll(List<D> dtoList);

    D get(Long id);

    Page<D> getAll(Pageable pageable);

    Boolean delete(Long id);

    Boolean deleteAll();
}
