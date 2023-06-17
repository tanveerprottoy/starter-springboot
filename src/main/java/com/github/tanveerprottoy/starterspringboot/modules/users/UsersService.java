package com.github.tanveerprottoy.starterspringboot.modules.users;

import com.github.tanveerprottoy.starterspringboot.modules.users.entities.User;
import com.github.tanveerprottoy.starterspringboot.utils.AdapterUtils;
import com.github.tanveerprottoy.starterspringboot.utils.ErrorUtils;
import com.github.tanveerprottoy.starterspringboot.utils.PaginationUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private final UsersRepository repository;

    public UsersService(UsersRepository repository) {
        this.repository = repository;
    }

    public Page<User> create(
        String page,
        String limit
    ) {
        try {
            int pageVal = AdapterUtils.stringToInt(page);
            int limitVal = AdapterUtils.stringToInt(limit);
            Pageable pageable = PaginationUtils.buildPageRequest(pageVal, limitVal);
            if(pageable == null) {
                throw ErrorUtils.throwError("Failed to build page request");
            }
            return this.repository.findAll(pageable);
        }
        catch(Exception e) {
            return Page.empty();
        }
    }

    public Page<User> readAll(
        String page,
        String limit
    ) {
        try {
            int pageVal = AdapterUtils.stringToInt(page);
            int limitVal = AdapterUtils.stringToInt(limit);
            Pageable pageable = PaginationUtils.buildPageRequest(pageVal, limitVal);
            if(pageable == null) {
                throw ErrorUtils.throwError("Failed to build page request");
            }
            return this.repository.findAll(pageable);
        }
        catch(Exception e) {
            return Page.empty();
        }
    }
}
