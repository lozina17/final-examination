package example.tatyana.myfinalexaminationapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val LAST_SELECTED_ITEM = "item"
private val RANDOMIZER_FRAGMENT = RandomizerFragment().javaClass.name
private val INFO_FRAGMENT = InfoFragment().javaClass.name

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener { item ->
            var fragment: Fragment? = null
            when (item.itemId) {
                R.id.numbers -> {
                    fragment = if (savedInstanceState != null) supportFragmentManager.getFragment(
                        savedInstanceState,
                        RANDOMIZER_FRAGMENT
                    ) else RandomizerFragment()
                }

                R.id.info -> {
                    fragment = if (savedInstanceState != null) supportFragmentManager.getFragment(
                        savedInstanceState,
                        INFO_FRAGMENT
                    ) else InfoFragment()
                }
            }

            replaceFragment(fragment!!)
            true
        }

        bottomNavigationView.selectedItemId =
            if (savedInstanceState != null) savedInstanceState.getInt(
                LAST_SELECTED_ITEM
            ) else R.id.numbers
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_SELECTED_ITEM, bottomNavigationView.selectedItemId)

        val currentFragment = supportFragmentManager.fragments.last()
        supportFragmentManager.putFragment(
            outState,
            currentFragment.javaClass.name,
            currentFragment
        )
    }


    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()


    }
}