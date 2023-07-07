package com.morkaragh.dictadmin.rules;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RulesRepository extends CrudRepository<Rule, Long> {


}
