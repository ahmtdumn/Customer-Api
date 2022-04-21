package com.duman.customer.service.impl;

import com.duman.customer.exception.GenericException;
import com.duman.customer.exception.errors.ErrorCode;
import com.duman.customer.mapper.DocumentMapper;
import com.duman.customer.model.dto.DocumentDTO;
import com.duman.customer.model.dto.DocumentListDTO;
import com.duman.customer.model.entity.Customer;
import com.duman.customer.model.entity.Document;
import com.duman.customer.repository.CustomerRepository;
import com.duman.customer.repository.DocumentCustomRepository;
import com.duman.customer.repository.DocumentRepository;
import com.duman.customer.service.IDocumentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class DocumentService implements IDocumentService {
    private final DocumentMapper documentMapper;
    private final DocumentRepository documentRepository;
    private final CustomerRepository customerRepository;
    @Autowired
    private final DocumentCustomRepository documentCustomRepository;

    @Override
    public List<DocumentDTO> findAll() {
        List<DocumentDTO> documentDTOList = documentCustomRepository.findAll();
        return documentDTOList;
    }

    @Override
    public List<DocumentListDTO> findByCustomerId(Long id) {
        List<DocumentListDTO> documentListDTOList = documentCustomRepository.findByPersonelId(id);
        return documentListDTOList;
    }

    @Override
    public DocumentDTO findById(Long id) {
        Document document = documentRepository.findById(id)
                .orElseThrow(() -> new GenericException(ErrorCode.ENTITY_NOT_FOUND_EXCEPTION, id, Document.class.getSimpleName()));
        DocumentDTO documentDTO = documentMapper.toDTO(document);
        documentDTO.setCustomerId(document.getCustomer().getId());
        return documentDTO;
    }

    @Override
    @Transactional
    public DocumentDTO save(DocumentDTO dto) {
        Document document = new Document();
        document.setCustomer(customerRepository.findById(dto.getCustomerId()).orElseThrow(() ->
                new GenericException(ErrorCode.ENTITY_NOT_FOUND_EXCEPTION, dto.getCustomerId(), Customer.class.getSimpleName())));
        document.setDocument(Base64.getDecoder().decode(dto.getFileTransferData().getFileBase64Str()));
        return documentMapper.toDTO(documentRepository.save(document));

    }

    @Override
    @Transactional
    public DocumentDTO update(DocumentDTO dto, Long id) {
        Document document = documentRepository.findById(id).orElseThrow(() ->
                new GenericException(ErrorCode.ENTITY_NOT_FOUND_EXCEPTION, id, Document.class.getSimpleName()));
        document.setDocument(Base64.getDecoder().decode(dto.getFileTransferData().getFileBase64Str()));
        document.setCustomer(customerRepository.findById(dto.getCustomerId()).orElseThrow(() ->
                new GenericException(ErrorCode.ENTITY_NOT_FOUND_EXCEPTION, dto.getCustomerId(), Customer.class.getSimpleName())));
        return documentMapper.toDTO(documentRepository.save(document));
    }

    @Override
    @Transactional
    public Long delete(Long id) {
        documentRepository.deleteById(id);
        return id;
    }
}
