package com.morkaragh.dictadmin.rules;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KeyValueRulesRepository extends CrudRepository<KeyValueRule, Long> {

    Optional<KeyValueRule> findByCreatedBy_LoginIgnoreCase(String login);

    List<KeyValueRule> findByEndDateNullAndKey(@NonNull String key);



}
