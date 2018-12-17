package com.neestell.singleandmultiactivityapp


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import com.neestell.singleandmultiactivityapp.MainActivity.Companion.navigator
import kotlinx.android.synthetic.main.l_content.*
import singlemultiple.neestell.com.singleandmultiactivityapp.R

class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerItems.adapter = ItemsAdapter()
        buttonGo.setOnClickListener {
            if (activity is ChildActivity)
                navigator.navigate(activity as ChildActivity)
            else
                navigator.navigate(activity?.supportFragmentManager!!).let {
                    finishActivityIfLast()
                }

        }
        buttonGo.visibility = if (MainActivity.navigator.autoplay)
            View.INVISIBLE else View.VISIBLE;

    }

    override fun onResume() {
        super.onResume()
        if (navigator.autoplay) {
            navigator.navigate(activity?.supportFragmentManager!!)
            finishActivityIfLast()
        }
    }

    private fun finishActivityIfLast() {
        activity?.let {
            if (it.supportFragmentManager.backStackEntryCount == 1 && navigator.goBack)
                it.finish()
        }
    }


    companion object {
        val TAG = "main_fragment"

        @JvmStatic
        fun newInstance() = MainFragment()
    }

}
