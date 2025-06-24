package org.echoplay.echoplay.repository;

import org.echoplay.echoplay.entity.ListeningHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListeningHistoryRepository extends JpaRepository<ListeningHistory,Long> {
}
