package org.echoplay.echoplay.repository;

import org.echoplay.echoplay.entity.Performer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PerformerRepository extends JpaRepository<Performer,Long> {

    @Query("select p from Performer p where p.firstName=?1 and p.lastName=?2")
    Performer findPerformerByFullName(String firstName,String lastName);
}
