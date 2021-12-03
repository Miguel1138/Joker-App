package co.tiagoaguiar.tutorial.jokerappdev.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.tiagoaguiar.tutorial.jokerappdev.R
import co.tiagoaguiar.tutorial.jokerappdev.viewmodel.LocalDatabase
import com.xwray.groupie.GroupieAdapter

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View =
        inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val groupieAdapter = GroupieAdapter()
        mockCategoryListIn(groupieAdapter)

        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_main)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = groupieAdapter
        }
    }

    private fun mockCategoryListIn(groupieAdapter: GroupieAdapter) {
        val jokeCategories = LocalDatabase.getJokeCategories()
        groupieAdapter.addAll(jokeCategories)
        groupieAdapter.notifyItemRangeChanged(0, groupieAdapter.groupCount)
    }

}