package com.duman.customer.mapper;

import com.duman.customer.model.dto.CustomerDTO;
import com.duman.customer.model.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDTO toDTO(Customer customer);

    List<CustomerDTO> toListDTO(List<Customer> customerList);

    Customer toEntity(CustomerDTO dto);

    List<Customer> toListEntity(List<CustomerDTO> dtoList);
}
