package guru.springframework.springframeworkmsscbrewery.services;

import guru.springframework.springframeworkmsscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {

    CustomerDto getCustomerById(UUID customerId);

    CustomerDto saveNewCustomer(CustomerDto customerDto);

    void updateCustomerById(UUID customerId, CustomerDto customerDto);

    void deleteById(UUID customerId);

}
