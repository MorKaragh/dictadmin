package com.morkaragh.dictadmin.rules.internal;

import com.morkaragh.dictadmin.rules.FixedProgramForAgent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KeyValueRulesRepository extends CrudRepository<FixedProgramForAgent, Long> {

    FixedProgramForAgent findByEndDateNullAndKey(@NonNull String key);

    List<FixedProgramForAgent> findByKey(@NonNull String key);


}
