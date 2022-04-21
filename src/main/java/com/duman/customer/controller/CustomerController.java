package com.duman.customer.controller;

import com.duman.customer.model.dto.CustomerDTO;
import com.duman.customer.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/customer")//pre-path
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping //api/customer
    public List<CustomerDTO> findAll() {
        return customerService.findAll();
    }

    @GetMapping("/{id}") //api/customer/{id}
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return new ResponseEntity<>(customerService.findById(id), HttpStatus.OK);
    }

    @PostMapping //api/customer
    public ResponseEntity<?> saveCustomer(@RequestBody @Valid CustomerDTO dto) {
        return new ResponseEntity<>(customerService.save(dto), HttpStatus.OK);
    }

    @PutMapping("/{id}") //api/customer/{id}
    public ResponseEntity<?> updateCustomer(@PathVariable Long id, @RequestBody @Valid CustomerDTO dto) {
        return new ResponseEntity<>(customerService.update(dto, id), HttpStatus.OK);

    }

    @DeleteMapping("/{id}") //api/customer/{id}
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
        return new ResponseEntity<>(customerService.delete(id), HttpStatus.OK);
    }
}
