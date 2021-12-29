package com.example.labone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), MainFragmentController {

    companion object {
        const val SHOULD_OPEN_FRAGMENT = true
        const val SHARED_TEXT = "shared_text"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(MainFragment.newInstance())
    }

    override fun openFragment(bundle: Bundle) {
        replaceFragment(SharedTextFragment.newInstance(bundle))
    }

    override fun openAnotherActivity(bundle: Bundle) {
        startActivity(
            Intent(this, SharedTextActivity::class.java).putExtras(bundle)
        )
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack(null)
            .commit()
    }
}