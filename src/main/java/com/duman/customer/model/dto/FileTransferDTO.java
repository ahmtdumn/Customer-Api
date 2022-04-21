package com.duman.customer.model.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class FileTransferDTO{
    @NotNull
    private String fileName;
    @NotNull
    private String fileBase64Str;
}
