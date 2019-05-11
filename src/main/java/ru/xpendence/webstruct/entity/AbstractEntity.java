package ru.xpendence.webstruct.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 11.05.19
 * Time: 11:07
 * e-mail: 2262288@gmail.com
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    private Long id;
    private LocalDateTime created;
    private LocalDateTime updated;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "created", updatable = false)
    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Column(name = "updated", insertable = false)
    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    @PrePersist
    private void onCreate() {
        this.created = LocalDateTime.now();
    }

    @PreUpdate
    private void onUpdate() {
        this.updated = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity that = (AbstractEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(created, that.created) &&
                Objects.equals(updated, that.updated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, created, updated);
    }

    @Override
    public String toString() {
        return "AbstractEntity{" +
                "id=" + id +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
