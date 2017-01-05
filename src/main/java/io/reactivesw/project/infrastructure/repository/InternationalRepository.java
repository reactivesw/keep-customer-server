package io.reactivesw.project.infrastructure.repository;

import io.reactivesw.project.domain.entity.InternationalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by umasuo on 17/1/5.
 */
public interface InternationalRepository extends JpaRepository<InternationalEntity, String>,
    CrudRepository<InternationalEntity, String> {
}
