package com.duman.customer.service;

import com.duman.customer.model.dto.DocumentDTO;
import com.duman.customer.model.dto.DocumentListDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IDocumentService {
    List<DocumentDTO> findAll();

    List<DocumentListDTO> findByCustomerId(Long id);

    DocumentDTO findById(Long id);

    @Transactional
    DocumentDTO save(DocumentDTO dto);

    @Transactional
    DocumentDTO update(DocumentDTO dto, Long id);

    @Transactional
    Long delete(Long id);
}
