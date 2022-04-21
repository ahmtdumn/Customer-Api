package com.duman.customer.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "document")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private Customer customer;

    @Column(name = "document", nullable = false)
    private byte[] document;
}
