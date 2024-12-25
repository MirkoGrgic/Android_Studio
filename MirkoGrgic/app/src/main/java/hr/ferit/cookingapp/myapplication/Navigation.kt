package hr.ferit.cookingapp.myapplication

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import hr.ferit.cookingapp.myapplication.data.RecipeViewModel
import hr.ferit.cookingapp.myapplication.ui.theme.RecipeDetailsScreen
import hr.ferit.cookingapp.myapplication.ui.theme.RecipesScreen

object Routes {
    const val SCREEN_ALL_RECIPES = "recipeList"
    const val SCREEN_RECIPE_DETAILS = "recipeDetails/{recipeId}"
    fun getRecipeDetailsPath(recipeId: Int?) : String {
        if (recipeId != null && recipeId != -1) {
            return "recipeDetails/$recipeId"
        }
        return "recipeDetails/0"
    }
}
@Composable
fun NavigationController(
    viewModel: RecipeViewModel
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination =
    Routes.SCREEN_ALL_RECIPES) {
        composable(Routes.SCREEN_ALL_RECIPES) {
            RecipesScreen(
                viewModel = viewModel,
                navigation = navController
            )
        }
        composable(
            Routes.SCREEN_RECIPE_DETAILS,
            arguments = listOf(
                navArgument("recipeId") {
                    type = NavType.IntType
                }
            )
        ) {backStackEntry ->
            backStackEntry.arguments?.getInt("recipeId")?.let {
                RecipeDetailsScreen(
                    viewModel = viewModel,
                    navigation = navController,
                    recipeId = it
                )
            }
        }
    }
}