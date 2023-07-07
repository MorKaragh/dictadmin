package com.morkaragh.dictadmin.rules;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RepositoryRestResource
public interface KeyValueRulesRepository extends CrudRepository<KeyValueRule, Long> {

    Optional<KeyValueRule> findByCreatedBy_LoginIgnoreCase(String login);

    @RestResource(path = "byKey", rel = "findByKey")
    List<KeyValueRule> findByEndDateNullAndKey(@NonNull String key);



}
