package com.api.resourcecontrol.services;

import com.api.resourcecontrol.models.FoodModel;
import com.api.resourcecontrol.repositories.FoodRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FoodService {

    final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository){
        this.foodRepository = foodRepository;
    }

    @Transactional
    public FoodModel save(FoodModel foodModel) {
        return foodRepository.save(foodModel);
    }

    public List<FoodModel> findAll() {
        return foodRepository.findAll();
    }

    public Optional<FoodModel> findById(UUID id) {
        return foodRepository.findById(id);
    }

    @Transactional
    public void delete(FoodModel foodModel) {
        foodRepository.delete(foodModel);
    }
}
