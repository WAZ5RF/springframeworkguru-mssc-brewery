package guru.springframework.springframeworkmsscbrewery.services;

import guru.springframework.springframeworkmsscbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("kingfisher")
                .beerStyle("pale")
                .build();
    }
}
