package co.tiagoaguiar.tutorial.jokerappdev.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import co.tiagoaguiar.tutorial.jokerappdev.BuildConfig
import co.tiagoaguiar.tutorial.jokerappdev.R
import co.tiagoaguiar.tutorial.jokerappdev.datasource.Config

class AboutFragment : Fragment(R.layout.fragment_about) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind(view)
    }

    private fun bind(view: View) {
        view.findViewById<TextView>(R.id.txt_version).text = showBuildVersion()
        view.findViewById<TextView>(R.id.txt_site_link).setOnClickListener {
            try {
                startActivity(myWebLink())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun showBuildVersion() = getString(R.string.build_version, BuildConfig.VERSION_NAME)

    private fun myWebLink() = Intent(Intent.ACTION_VIEW).apply {
        type = "text/plain"
        data = Uri.parse(Config.getMyWebsite())
    }
}



