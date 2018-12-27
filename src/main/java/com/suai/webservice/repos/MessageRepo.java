package com.suai.webservice.repos;


import com.suai.webservice.domain.Message;
import com.suai.webservice.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message, Long> {

    List<Message> findByTag(String tag);

    List<Message>findByAuthor(User user);

}