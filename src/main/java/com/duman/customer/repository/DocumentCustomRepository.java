package com.duman.customer.repository;

import com.duman.customer.model.dto.DocumentDTO;
import com.duman.customer.model.dto.DocumentListDTO;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface DocumentCustomRepository {
    List<DocumentDTO> findAll();
    List<DocumentListDTO> findByPersonelId(Long id);
}
