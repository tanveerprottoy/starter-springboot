package com.github.tanveerprottoy.starterspringboot.modules.users;

import com.github.tanveerprottoy.starterspringboot.modules.users.dto.UserDto;
import com.github.tanveerprottoy.starterspringboot.modules.users.entities.User;
import com.github.tanveerprottoy.starterspringboot.utils.Constants;
import com.github.tanveerprottoy.starterspringboot.utils.ErrorUtils;
import com.github.tanveerprottoy.starterspringboot.utils.PaginationUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UsersService {
    private final UsersRepository repository;

    public UsersService(UsersRepository repository) {
        this.repository = repository;
    }

    public User create(UserDto dto) throws ResponseStatusException {
        try {
            // convert dto to entity
            User user = new User();
            user.setFirstName(dto.getFirstName());
            user.setLastName(dto.getLastName());
            this.repository.save(user);
            return user;
        }
        catch(Exception e) {
            throw ErrorUtils.throwHttpError(
                HttpStatus.INTERNAL_SERVER_ERROR,
                Constants.INTERNAL_SERVER_ERROR,
                e
            );
        }
    }

    public Page<User> readAll(int page, int limit) {
        try {
            Pageable pageable = PaginationUtils.buildPageRequest(page, limit);
            if(pageable == null) {
                throw ErrorUtils.throwError("Failed to build page request");
            }
            Page<User> pagedData = this.repository.findAll(pageable);
            return pagedData;
        }
        catch(Exception e) {
            return Page.empty();
        }
    }

    public User readOne(long id) throws ResponseStatusException {
        try {
            Optional<User> result = this.repository.findById(id);
            if(result.isEmpty()){
                throw ErrorUtils.throwHttpError(
                    HttpStatus.NOT_FOUND,
                    Constants.NOT_FOUND
                );
            }
            return result.get();
        }
        catch(Exception e) {
            throw ErrorUtils.throwHttpError(
                HttpStatus.INTERNAL_SERVER_ERROR,
                Constants.INTERNAL_SERVER_ERROR,
                e
            );
        }
    }

    public User update(long id, UserDto dto) throws ResponseStatusException {
        try {
            Optional<User> result = this.repository.findById(id);
            if(result.isEmpty()){
                throw ErrorUtils.throwHttpError(
                    HttpStatus.NOT_FOUND,
                    Constants.NOT_FOUND
                );
            }
            User user = result.get();
            user.setFirstName(dto.getFirstName());
            user.setLastName(dto.getLastName());
            this.repository.save(user);
            return user;
        }
        catch(Exception e) {
            throw ErrorUtils.throwHttpError(
                HttpStatus.INTERNAL_SERVER_ERROR,
                Constants.INTERNAL_SERVER_ERROR,
                e
            );
        }
    }

    public long delete(long id) throws ResponseStatusException {
        try {
            this.repository.deleteById(id);
            return id;
        }
        catch(Exception e) {
            throw ErrorUtils.throwHttpError(
                HttpStatus.INTERNAL_SERVER_ERROR,
                Constants.INTERNAL_SERVER_ERROR,
                e
            );
        }
    }
}
