package com.infopulse.repository;

import com.infopulse.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long>{

    List<Message> findByReceiver_Login(String login);

    @Modifying
    void deleteByReceiver_Login(String login);
}
