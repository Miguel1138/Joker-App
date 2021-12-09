package co.tiagoaguiar.tutorial.jokerappdev.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import co.tiagoaguiar.tutorial.jokerappdev.R
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var appBarConfig: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_main)
        setActionBarConfiguration()
    }

    private fun setActionBarConfiguration() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        createDrawerLayoutConfig()
    }

    private fun createDrawerLayoutConfig() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.main_nav_view)

        initiateController()
        passNameAndOpenFunctionalityTo(drawerLayout)
        addControllerTo(navView)
    }

    private fun initiateController() {
        navController = findNavController(R.id.nav_host_fragment_content_main)
    }

    private fun passNameAndOpenFunctionalityTo(drawerLayout: DrawerLayout) {
        appBarConfig = AppBarConfiguration(
            setOf(R.id.nav_home, R.id.nav_joke_day, R.id.nav_about),
            drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfig)
    }

    private fun addControllerTo(navView: NavigationView) =
        navView.setupWithNavController(navController)

    override fun onSupportNavigateUp(): Boolean =
        navController.navigateUp(appBarConfig) || super.onNavigateUp()

}