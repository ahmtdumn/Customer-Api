package com.duman.customer.service;

import com.duman.customer.model.dto.CustomerDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ICustomerService {
    List<CustomerDTO> findAll();

    CustomerDTO findById(Long id);

    @Transactional
    CustomerDTO save(CustomerDTO dto);

    @Transactional
    CustomerDTO update(CustomerDTO dto, Long id);

    @Transactional
    Long delete(Long id);
}
