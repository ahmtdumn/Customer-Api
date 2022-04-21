package com.duman.customer.model.dto;

import lombok.Data;

@Data
public class DocumentListDTO {

    private Long id;

    private byte[] document;

    private Long customerId;

    private String name;

    private String surname;
}
