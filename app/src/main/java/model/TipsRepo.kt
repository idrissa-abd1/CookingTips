package model

import com.example.cookingtips.R

object TipsRepo {
    val tips = listOf(
        DishTip(day = R.string.day_1, dishName =  R.string.dish_1, imageResourceId =  R.drawable.hearty_spinach_stew, description =  R.string.description_1),
        DishTip(day = R.string.day_2, dishName =  R.string.dish_2, imageResourceId =  R.drawable.salmon, description =  R.string.description_2),
        DishTip(day = R.string.day_3, dishName =  R.string.dish_3, imageResourceId =  R.drawable.black_bean, description =  R.string.description_3),
        DishTip(day = R.string.day_4, dishName =  R.string.dish_4, imageResourceId =  R.drawable.roasted_salmon, description =  R.string.description_4),
        DishTip(day = R.string.day_5, dishName =  R.string.dish_5, imageResourceId =  R.drawable.healthy_detox_salad, description =  R.string.description_5),
        DishTip(day = R.string.day_6, dishName =  R.string.dish_6, imageResourceId =  R.drawable.zucchinni, description =  R.string.description_6),
        DishTip(day = R.string.day_7, dishName =  R.string.dish_7, imageResourceId =  R.drawable.chicken_with_orzo_salad, description =  R.string.description_7)
    )
}