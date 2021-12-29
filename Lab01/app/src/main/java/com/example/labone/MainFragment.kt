package com.example.labone

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import java.text.SimpleDateFormat
import java.util.*

class MainFragment : Fragment(R.layout.fragment_main) {

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    private var editText: EditText? = null
    private var textView: TextView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editText = view.findViewById(R.id.editText)
        textView = view.findViewById(R.id.currentTimeTv)

        view.findViewById<Button>(R.id.nextScreenBtn).setOnClickListener {
            if (MainActivity.SHOULD_OPEN_FRAGMENT) {
                (activity as? MainFragmentController)?.openFragment(getBungle())
            } else {
                (activity as? MainFragmentController)?.openAnotherActivity(getBungle())
            }
        }

        view.findViewById<Button>(R.id.currentTimeBtn).setOnClickListener {
            val currentDate = SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(Date())
            textView?.text = currentDate
        }
    }

    private fun getBungle() = bundleOf(MainActivity.SHARED_TEXT to editText?.text.toString())
}