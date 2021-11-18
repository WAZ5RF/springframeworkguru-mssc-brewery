package guru.springframework.springframeworkmsscbrewery.services;

import guru.springframework.springframeworkmsscbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;


public interface BeerService {
    BeerDto getBeerById(UUID beerId);

}
