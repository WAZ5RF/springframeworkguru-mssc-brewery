package guru.springframework.springframeworkmsscbrewery.web.controller.v2;

import guru.springframework.springframeworkmsscbrewery.services.v2.BeerServiceV2;
import guru.springframework.springframeworkmsscbrewery.web.model.v2.BeerDtoV2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Validated
@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {


    private final BeerServiceV2 beerServiceV2;

    public BeerControllerV2(BeerServiceV2 beerServiceV2) {
        this.beerServiceV2 = beerServiceV2;
    }


    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDtoV2> getBeer(@NotNull  @PathVariable("beerId") UUID beerId){

        return new ResponseEntity<>(beerServiceV2.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping  // POST- create new beer
    public  ResponseEntity handlePost(@Valid @NotNull @RequestBody BeerDtoV2 beerDtoV2){
        BeerDtoV2 dtoV2 = beerServiceV2.saveNewBeer(beerDtoV2);
        HttpHeaders httpHeaders = new HttpHeaders();
        // to add hostname to url
        httpHeaders.add("Location", "/api/v1/beer"+dtoV2.getId().toString());

        return new ResponseEntity(httpHeaders,HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleUpdate(@NotNull @PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDtoV2 beerDtoV2){
        beerServiceV2.updateBeer(beerId,beerDtoV2);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@NotNull @PathVariable("beerId") UUID beerId){
        beerServiceV2.deleteBeer(beerId);
    }
}
