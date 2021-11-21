package guru.springframework.springframeworkmsscbrewery.services;

import guru.springframework.springframeworkmsscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Root")
                .build();
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateCustomerById(UUID customerId, CustomerDto customerDto) {
        log.debug("updated the customer..");
    }

    @Override
    public void deleteById(UUID customerId) {
        log.debug("Deleted the customer..");
    }
}
