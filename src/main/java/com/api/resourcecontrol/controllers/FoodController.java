package com.api.resourcecontrol.controllers;

import com.api.resourcecontrol.dtos.FoodDto;
import com.api.resourcecontrol.models.FoodModel;
import com.api.resourcecontrol.services.FoodService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/food")
public class FoodController {

    final FoodService foodService;
    public FoodController(FoodService foodService){
        this.foodService = foodService;
    }

    @PostMapping
    public ResponseEntity<Object> saveFood(@RequestBody @Valid FoodDto foodDto){

        var foodModel = new FoodModel();
        BeanUtils.copyProperties(foodDto, foodModel); // Converte dados da camada dto (a mais externa do backend) a dados no modelo do Model
        foodModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(foodService.save(foodModel));
    }

    @GetMapping
    public ResponseEntity<List<FoodModel>> getAllFoods(){

        return ResponseEntity.status(HttpStatus.OK).body(foodService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneFood(@PathVariable(value = "id")UUID id){
        Optional<FoodModel> foodModelOptional = foodService.findById(id);

        if(!foodModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Food not found");
        }

        return ResponseEntity.status((HttpStatus.OK)).body(foodModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteFood(@PathVariable(value = "id") UUID id){
        Optional<FoodModel> foodModelOptional = foodService.findById(id);

        if(!foodModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Food not found");
        }

        foodService.delete(foodModelOptional.get());

        return ResponseEntity.status(HttpStatus.OK).body("Food deleted successfully.");

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateFood(@PathVariable(value = "id") UUID id,
                                             @RequestBody  FoodDto foodDto ){

        Optional<FoodModel> foodModelOptional = foodService.findById(id);

        if(!foodModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Food not found");
        }

        /*
        var foodModel = foodModelOptional.get();

        foodModel.setFoodName(foodDto.getFoodName());
        foodModel.setPlaceOfOrigin(foodDto.getPlaceOfOrigin());
        foodModel.setDestination(foodDto.getDestination());
        foodModel.setResponsibleForTransport(foodDto.getResponsibleForTransport());
        */

        var foodModel = new FoodModel();
        BeanUtils.copyProperties(foodDto, foodModel);
        foodModel.setId(foodModelOptional.get().getId());
        foodModel.setRegistrationDate(foodModelOptional.get().getRegistrationDate());

        return ResponseEntity.status(HttpStatus.OK).body(foodService.save(foodModel));
    }

}
