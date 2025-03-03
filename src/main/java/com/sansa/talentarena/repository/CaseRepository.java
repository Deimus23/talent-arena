package com.sansa.talentarena.repository;

import com.sansa.talentarena.model.entity.Case;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CaseRepository extends CrudRepository<Case, UUID> {
}
