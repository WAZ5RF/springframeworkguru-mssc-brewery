package guru.springframework.springframeworkmsscbrewery.web.controller;

import guru.springframework.springframeworkmsscbrewery.services.BeerService;
import guru.springframework.springframeworkmsscbrewery.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {


    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId){

        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping  // POST- create new beer
    public  ResponseEntity handlePost(@RequestBody BeerDto beerDto){
            BeerDto saveDto = beerService.saveNewBeer(beerDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        // to add hostname to url
        httpHeaders.add("Location", "/api/v1/beer"+saveDto.getId().toString());

        return new ResponseEntity(httpHeaders,HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto){
          beerService.updateBeer(beerId,beerDto);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId){
        beerService.deleteBeer(beerId);
    }
}









