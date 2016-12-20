package io.reactivesw.order.zone.infrastructure.repository;

import io.reactivesw.order.zone.domain.entity.ZoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by umasuo on 16/12/8.
 */
@Repository
public interface ZoneRepository extends JpaRepository<ZoneEntity, String>,
    CrudRepository<ZoneEntity, String> {

}
