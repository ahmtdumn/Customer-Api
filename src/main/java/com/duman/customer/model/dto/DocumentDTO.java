package com.duman.customer.model.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DocumentDTO {

    private Long id;

    @NotNull
    private Long customerId;

    private byte[] document;

    @NotNull
    private FileTransferDTO fileTransferData;

}
