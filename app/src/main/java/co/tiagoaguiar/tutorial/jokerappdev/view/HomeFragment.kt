package co.tiagoaguiar.tutorial.jokerappdev.view

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.tiagoaguiar.tutorial.jokerappdev.R
import co.tiagoaguiar.tutorial.jokerappdev.model.JokeCategory
import co.tiagoaguiar.tutorial.jokerappdev.presentation.HomePresenter
import com.xwray.groupie.GroupieAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var presenter: HomePresenter
    private val groupieAdapter = GroupieAdapter()
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = HomePresenter(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressBar = view.findViewById(R.id.progress_bar)

        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_main)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = groupieAdapter
        }

        if (adapterListIsEmpty())
            presenter.findAllCategories()

        groupieAdapter.setOnItemClickListener { item, _ ->
            passCategoryTitleTo(item)
        }
    }

    private fun adapterListIsEmpty() = groupieAdapter.itemCount == 0

    private fun passCategoryTitleTo(item: Item<GroupieViewHolder>) {
        val categoryName = (item as JokeCategoryItem).category.name
        val bundle = Bundle().apply {
            putString(JokeFragment.CATEGORY_KEY, categoryName)
        }

        findNavController().navigate(R.id.action_nav_home_to_nav_joke, bundle)
    }

    fun showCategories(response: List<JokeCategory>) {
        val categories = response.map { jokeCategory -> JokeCategoryItem(jokeCategory) }
        groupieAdapter.addAll(categories)
        groupieAdapter.notifyItemRangeChanged(0, groupieAdapter.groupCount)
    }

    fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

    fun showFailure(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

}