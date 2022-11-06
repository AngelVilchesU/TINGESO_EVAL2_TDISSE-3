package com.mueblesStgo.mueblesStgo.repositories;

import com.mueblesStgo.mueblesStgo.entities.AutorizacionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorizacionRepository extends CrudRepository<AutorizacionEntity, Long> {

}
