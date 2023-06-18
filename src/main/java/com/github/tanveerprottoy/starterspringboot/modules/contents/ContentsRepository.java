package com.github.tanveerprottoy.starterspringboot.modules.contents;

import com.github.tanveerprottoy.starterspringboot.modules.contents.entities.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentsRepository extends JpaRepository<Content, Long> {

}
