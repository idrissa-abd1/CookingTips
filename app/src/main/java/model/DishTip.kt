package model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.cookingtips.R

data class DishTip(
   @StringRes val day: Int,
   @StringRes  val dishName: Int,
   @DrawableRes val imageResourceId: Int,
   @StringRes val description: Int
)