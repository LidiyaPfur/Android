package com.example.labone

import android.os.Bundle

interface MainFragmentController {
    fun openAnotherActivity(bundle: Bundle)
    fun openFragment(bundle: Bundle)
}