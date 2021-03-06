package co.tiagoaguiar.tutorial.jokerappdev.view

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import co.tiagoaguiar.tutorial.jokerappdev.R
import co.tiagoaguiar.tutorial.jokerappdev.abstracts.AbstractFragment
import co.tiagoaguiar.tutorial.jokerappdev.model.Joke
import co.tiagoaguiar.tutorial.jokerappdev.presentation.JokePresenter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.squareup.picasso.Picasso

class JokeFragment : AbstractFragment(R.layout.fragment_joke) {

    companion object {
        const val CATEGORY_KEY = "category"
    }

    private lateinit var imgJoke: ImageView
    private lateinit var txtJoke: TextView
    private lateinit var fab: FloatingActionButton
    private lateinit var presenter: JokePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = JokePresenter(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val categoryName = arguments?.getString(CATEGORY_KEY)
        setToolbarTitleTo(categoryName)
        bind(view)

        categoryName?.let {
            requestJokeBy(it)
            refreshJokeListener(it)
        }
    }

    private fun setToolbarTitleTo(categoryName: String?) {
        activity?.findViewById<Toolbar>(R.id.toolbar)?.title = categoryName
    }

    private fun bind(view: View) {
        txtJoke = view.findViewById(R.id.txt_joke)
        imgJoke = view.findViewById(R.id.img_joke)
        fab = view.findViewById(R.id.fab_refresh)
    }

    private fun requestJokeBy(categoryName: String) = presenter.findJokeBy(categoryName)

    private fun refreshJokeListener(categoryName: String) {
        fab.setOnClickListener {
            txtJoke.text = String.format(getString(R.string.label_txt_joke))
            requestJokeBy(categoryName)
        }
    }

    fun showJoke(response: Joke) {
        txtJoke.text = response.text
        Picasso.get().load(response.iconUrl).into(imgJoke)
    }

}