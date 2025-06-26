package org.echoplay.echoplay.repository;

import org.echoplay.echoplay.entity.Mail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailRepository extends JpaRepository<Mail,Long> {
}
