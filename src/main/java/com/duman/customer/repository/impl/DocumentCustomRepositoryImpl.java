package com.duman.customer.repository.impl;

import com.duman.customer.model.dto.DocumentDTO;
import com.duman.customer.model.dto.DocumentListDTO;
import com.duman.customer.model.entity.Document;
import com.duman.customer.model.entity.QCustomer;
import com.duman.customer.model.entity.QDocument;
import com.duman.customer.repository.DocumentCustomRepository;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DocumentCustomRepositoryImpl extends QuerydslRepositorySupport implements DocumentCustomRepository {

    public DocumentCustomRepositoryImpl() {
        super(Document.class);
    }

    @Override
    public List<DocumentDTO> findAll() {
        QDocument document = QDocument.document1;
        QCustomer customer = QCustomer.customer;
        JPQLQuery<DocumentDTO> query = from(document)
                .select(Projections.bean(DocumentDTO.class,
                        document.id,
                        document.document,
                        customer.id.as("customerId")
                        )
                )
                .innerJoin(customer).on(customer.id.eq(document.customer.id));
        return query.fetch();
    }

    @Override
    public List<DocumentListDTO> findByPersonelId(Long id) {
        QDocument document = QDocument.document1;
        QCustomer customer = QCustomer.customer;
        JPQLQuery<DocumentListDTO> query = from(document)
                .select(Projections.bean(DocumentListDTO.class,
                        document.id,
                        document.document,
                        customer.id.as("customerId"),
                        customer.name,
                        customer.surname
                        )
                )
                .innerJoin(customer).on(customer.id.eq(document.customer.id))
                .where(document.customer.id.eq(id));
        return query.fetch();
    }
}
