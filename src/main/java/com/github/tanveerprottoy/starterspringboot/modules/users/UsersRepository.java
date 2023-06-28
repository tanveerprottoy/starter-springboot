package com.github.tanveerprottoy.starterspringboot.modules.users;

import com.github.tanveerprottoy.starterspringboot.modules.users.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

    @Query(value = """
      SELECT * FROM Users AS u LEFT JOIN contents AS c\s
      on c.user_id.id = u.id\s
      where u.is_active = true\s
      """)
    List<User> findAllUsersWithContents(Integer id);
}
