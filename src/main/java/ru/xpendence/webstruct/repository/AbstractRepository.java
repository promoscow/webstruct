package ru.xpendence.webstruct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ru.xpendence.webstruct.entity.AbstractEntity;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 11.05.19
 * Time: 11:20
 * e-mail: 2262288@gmail.com
 */
@NoRepositoryBean
public interface AbstractRepository<E extends AbstractEntity> extends JpaRepository<E, Long> {
}
