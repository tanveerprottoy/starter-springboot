package com.github.tanveerprottoy.starterspringboot.modules.contents;

import com.github.tanveerprottoy.starterspringboot.modules.contents.dto.ContentDto;
import com.github.tanveerprottoy.starterspringboot.modules.contents.entities.Content;
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
public class ContentsService {
    private final ContentsRepository repository;

    public ContentsService(ContentsRepository repository) {
        this.repository = repository;
    }

    public Content create(ContentDto dto) throws ResponseStatusException {
        try {
            // convert dto to entity
            Content entity = new Content();
            entity.setTitle(dto.getTitle());
            entity.setDetail(dto.getDetail());
            this.repository.save(entity);
            return entity;
        }
        catch(Exception e) {
            throw ErrorUtils.throwHttpError(
                HttpStatus.INTERNAL_SERVER_ERROR,
                Constants.INTERNAL_SERVER_ERROR,
                e
            );
        }
    }

    public Page<Content> readAll(int page, int limit) {
        try {
            Pageable pageable = PaginationUtils.buildPageRequest(page, limit);
            if(pageable == null) {
                throw ErrorUtils.throwError("Failed to build page request");
            }
            Page<Content> pagedData = this.repository.findAll(pageable);
            return pagedData;
        }
        catch(Exception e) {
            return Page.empty();
        }
    }

    public Content readOne(long id) throws ResponseStatusException {
        try {
            Optional<Content> result = this.repository.findById(id);
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

    public Content update(long id, ContentDto dto) throws ResponseStatusException {
        try {
            Optional<Content> result = this.repository.findById(id);
            if(result.isEmpty()){
                throw ErrorUtils.throwHttpError(
                    HttpStatus.NOT_FOUND,
                    Constants.NOT_FOUND
                );
            }
            Content entity = result.get();
            entity.setTitle(dto.getTitle());
            entity.setDetail(dto.getDetail());
            this.repository.save(entity);
            return entity;
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
