package com.duman.customer.controller;

import com.duman.customer.model.dto.DocumentDTO;
import com.duman.customer.model.dto.DocumentListDTO;
import com.duman.customer.service.IDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(
        produces = "application/json; charset=UTF-8",
        path = "api/document")//pre-path
public class DocumentController {
    @Autowired
    private IDocumentService documentService;

    @GetMapping //api/document
    public List<DocumentDTO> findAll() {
        return documentService.findAll();
    }

    @GetMapping("/customer/{id}") //api/document/customer/id
    public List<DocumentListDTO> findByCustomerId(@PathVariable Long id) {
        return documentService.findByCustomerId(id);
    }

    @GetMapping("/{id}") //api/document/{id}
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return new ResponseEntity<>(documentService.findById(id), HttpStatus.OK);
    }

    @PostMapping //api/document
    public ResponseEntity<?> saveDocument(@RequestBody @Valid DocumentDTO dto) throws ParseException {
        return new ResponseEntity<>(documentService.save(dto), HttpStatus.OK);
    }

    @PutMapping("/{id}") //api/document/{id}
    public ResponseEntity<?> updateDocument(@RequestBody @Valid DocumentDTO dto, @PathVariable Long id) {
        return new ResponseEntity<>(documentService.update(dto, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}") //api/document/{id}
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return new ResponseEntity<>(documentService.delete(id), HttpStatus.OK);
    }
}
