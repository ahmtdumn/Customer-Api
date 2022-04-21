package com.duman.customer.service.impl;

import com.duman.customer.exception.GenericException;
import com.duman.customer.exception.errors.ErrorCode;
import com.duman.customer.mapper.CustomerMapper;
import com.duman.customer.model.dto.CustomerDTO;
import com.duman.customer.model.entity.Customer;
import com.duman.customer.repository.CustomerRepository;
import com.duman.customer.service.ICustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerService implements ICustomerService {
    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;

    @Override
    public List<CustomerDTO> findAll() {
        return customerRepository.findAll().stream().map(customerMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public CustomerDTO findById(Long id) {
        return customerMapper.toDTO(customerRepository.findById(id).orElseThrow(() ->
                new GenericException(ErrorCode.ENTITY_NOT_FOUND_EXCEPTION, id, Customer.class.getSimpleName())));
    }

    @Override
    @Transactional
    public CustomerDTO save(CustomerDTO dto) {
        Customer customer = customerMapper.toEntity(dto);
        return customerMapper.toDTO(customerRepository.save(customer));
    }

    @Override
    @Transactional
    public CustomerDTO update(CustomerDTO dto, Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() ->
                new GenericException(ErrorCode.ENTITY_NOT_FOUND_EXCEPTION, id, Customer.class.getSimpleName()));
        customer.setName(dto.getName());
        customer.setSurname(dto.getSurname());
        return customerMapper.toDTO(customerRepository.save(customer));
    }

    @Override
    @Transactional
    public Long delete(Long id) {
        customerRepository.deleteById(id);
        return id;
    }
}
