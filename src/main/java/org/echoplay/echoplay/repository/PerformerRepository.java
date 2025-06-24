package org.echoplay.echoplay.repository;

import org.echoplay.echoplay.entity.Performer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformerRepository extends JpaRepository<Performer,Long> {
}
