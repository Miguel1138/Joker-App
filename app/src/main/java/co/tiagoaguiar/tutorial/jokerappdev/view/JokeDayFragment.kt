package co.tiagoaguiar.tutorial.jokerappdev.view

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import co.tiagoaguiar.tutorial.jokerappdev.R
import co.tiagoaguiar.tutorial.jokerappdev.model.Joke
import co.tiagoaguiar.tutorial.jokerappdev.presentation.JokeDayPresenter
import com.squareup.picasso.Picasso

class JokeDayFragment : Fragment(R.layout.fragment_joke_day) {

    private lateinit var jokeTxt: TextView
    private lateinit var jokeIcon: ImageView
    private lateinit var progressBar: ProgressBar
    private lateinit var presenter: JokeDayPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = JokeDayPresenter(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind(view)
        presenter.findJokeDay()
    }

    private fun bind(view: View) {
        jokeTxt = view.findViewById(R.id.txt_joke_day)
        jokeIcon = view.findViewById(R.id.img_joke_day)
        progressBar = view.findViewById(R.id.progress_bar)
    }

    fun showRandomJoke(response: Joke) {
        jokeTxt.text = response.text
        Picasso.get().load(response.iconUrl).into(jokeIcon)
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