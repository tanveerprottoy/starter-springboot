package com.github.tanveerprottoy.starterspringboot.modules.contents;

import com.github.tanveerprottoy.starterspringboot.modules.contents.dtos.ContentDto;
import com.github.tanveerprottoy.starterspringboot.modules.contents.entities.Content;
import com.github.tanveerprottoy.starterspringboot.utils.AdapterUtils;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "${v1}/contents")
public class ContentsController {

    private final ContentsService service;

    public ContentsController(ContentsService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseBody
    public Content create(@RequestBody ContentDto dto) {
        return this.service.create(dto);
    }

    @GetMapping
    public @ResponseBody Page<Content> readAll(
        @RequestParam(value = "page", defaultValue = "1") String page,
        @RequestParam(value = "limit", defaultValue = "10") String limit
    ) {
        int pageNumeric = AdapterUtils.stringToInt(page);
        int limitNumeric = AdapterUtils.stringToInt(limit);
        return this.service.readAll(pageNumeric, limitNumeric);
    }

    @GetMapping("/{id}")
    public @ResponseBody Content readOne(@PathVariable(value = "id") String id) {
        long idNumeric = AdapterUtils.stringToLong(id);
        return this.service.readOne(idNumeric);
    }

    @PostMapping("/{id}")
    public @ResponseBody Content update(
        @PathVariable(value = "id") String id,
        @RequestBody ContentDto dto
    ) {
        long idNumeric = AdapterUtils.stringToLong(id);
        return this.service.update(idNumeric, dto);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody long delete(@PathVariable(value = "id") String id) {
        long idNumeric = AdapterUtils.stringToLong(id);
        return this.service.delete(idNumeric);
    }
}
