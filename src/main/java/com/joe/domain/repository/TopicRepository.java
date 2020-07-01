package com.joe.domain.repository;

import com.joe.domain.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic ,Long> {
}
