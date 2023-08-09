package com.example.relishrhapsody.ui.explore

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.relishrhapsody.R // Import your R class for resources
import com.example.relishrhapsody.database.RecipeApplication
import com.example.relishrhapsody.database.RecipeItemModelFactory
import com.example.relishrhapsody.database.RecipeViewModel

class ExploreFragment : Fragment() {

    private lateinit var listView: ListView
    private lateinit var recipeArrayList: ArrayList<Recipe>
    private val recipeViewModel: RecipeViewModel by viewModels {
        RecipeItemModelFactory((requireActivity().application as RecipeApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val exploreViewModel =
            ViewModelProvider(this).get(ExploreViewModel::class.java)

        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_explore, container, false)



        // Sample data for the ListView

        // Get the reference to the ListView
        listView = root.findViewById(R.id.recipe_list_view)

//        val recipeViewModel = ViewModelProvider(this).get(RecipeViewModel::class.java)

        val adapter = RecipeAdapter(requireContext() as Activity, ArrayList())
        listView.adapter = adapter

        // Observe changes in the database and update the list
        recipeViewModel.allRecipeItems.observe(this, Observer { recipes ->
            adapter.clear()
            adapter.addAll(recipes)
        })
        // Set item click listener
        listView.setOnItemClickListener { parent, view, position, id ->
            val clickedRecipe = adapter.getItem(position)
            clickedRecipe?.let {
                val intent = Intent(requireContext(), RecipeActivity::class.java)
                intent.putExtra("meal_type", it.meal_type)
                intent.putExtra("difficulty", it.difficulty)
                intent.putExtra("image_id", it.imageId)

                intent.putExtra("recipe_title", it.recipe_title)
                intent.putExtra("people_served", it.number_of_people)
                intent.putExtra("ingredients", it.ingredients)
                intent.putExtra("preparation_steps", it.preparation_steps)
                // Add other data as needed
                startActivity(intent)
            }
        }
        return root
    }

}
