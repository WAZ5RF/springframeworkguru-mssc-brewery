package guru.springframework.springframeworkmsscbrewery.web.controller;

import guru.springframework.springframeworkmsscbrewery.services.CustomerService;
import guru.springframework.springframeworkmsscbrewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("api/v1/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId) {
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody CustomerDto customerDto) {
        CustomerDto dto = customerService.saveNewCustomer(customerDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "api/v1/customer" + dto.getId().toString());
        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDto customerDto) {
        customerService.updateCustomerById(customerId, customerDto);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{customerId}")
    public void DeleteCustomer(@PathVariable("customerId") UUID customerId) {
        customerService.deleteById(customerId);
    }

}
