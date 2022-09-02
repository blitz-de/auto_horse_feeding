package com.accenture.horse_auto_manager.model.dto.food;

import java.util.List;

public class FoodContainer<T extends FoodDTO> {

    private List<T> foods;

}
