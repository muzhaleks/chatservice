package com.infopulse.repository;

import com.infopulse.entity.ChatUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ChatUserRepository extends JpaRepository<ChatUser, Long> {

    //@Query("select cu from ChatUser cu where cu.login = :login")
    ChatUser findByLogin(String login);
}
