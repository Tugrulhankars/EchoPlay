package org.echoplay.echoplay.repository;

import org.echoplay.echoplay.entity.PlayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayListRepository extends JpaRepository<PlayList,Long> {
}
