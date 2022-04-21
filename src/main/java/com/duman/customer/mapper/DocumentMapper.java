package com.duman.customer.mapper;

import com.duman.customer.model.dto.DocumentDTO;
import com.duman.customer.model.entity.Document;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DocumentMapper {
    DocumentDTO toDTO(Document document);

    List<DocumentDTO> toListDTO(List<Document> documentList);

    Document toEntity(DocumentDTO dto);

    List<Document> toListEntity(List<DocumentDTO> dtoList);
}
