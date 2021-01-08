package ru.itis.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.dtos.DocsData;
import ru.itis.services.DocsService;

@RestController
@AllArgsConstructor
public class DocsRestController {
    private DocsService docsService;

    @PostMapping("/create_docs")
    public void createDocs(@RequestBody DocsData docsData) {
        docsService.createDocs(docsData);
    }
}
