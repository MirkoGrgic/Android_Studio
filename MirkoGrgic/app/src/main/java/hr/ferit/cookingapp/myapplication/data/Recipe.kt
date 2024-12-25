package hr.ferit.cookingapp.myapplication.data

data class Recipe(
    var id: String = "",
    val image: String = "",
    val title: String = "",
    val category: String = "",
    val cookingTime: String = "",
    val energy: String = "",
    val rating: String = "",
    val description: String = "",
    val reviews: String = "",
    val ingredients: List<Ingredient> = listOf(),
    var isFavorited: Boolean = false
)
data class Ingredient(
    val image: String = "",
    val title: String = "",
    val subtitle: String = ""
)
