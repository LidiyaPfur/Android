package com.example.labone

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class SharedTextFragment : Fragment(R.layout.activity_shared_text) {

    companion object {
        fun newInstance(bundle: Bundle): SharedTextFragment {
            return SharedTextFragment().apply {
                arguments = bundle
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.sharedText).text =
            arguments?.getString(MainActivity.SHARED_TEXT)
    }
}