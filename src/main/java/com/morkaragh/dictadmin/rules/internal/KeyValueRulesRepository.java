package com.morkaragh.dictadmin.rules.internal;

import com.morkaragh.dictadmin.rules.KeyValueRule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface KeyValueRulesRepository extends CrudRepository<KeyValueRule, Long> {

    Optional<KeyValueRule> findByCreatedBy_LoginIgnoreCase(String login);

    KeyValueRule findByEndDateNullAndKey(@NonNull String key);
    List<KeyValueRule> findByKey(@NonNull String key);

}
