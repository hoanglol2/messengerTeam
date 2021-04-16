package com.example.messager.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.messager.R
import com.example.messager.adapter.MessageHorizontalAdapter
import com.example.messager.adapter.MessageVerticalAdapter
import com.example.messager.model.MessageHorizontalModel
import com.example.messager.model.MessageVerticalModel
import kotlinx.android.synthetic.main.fragment_home.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : BaseFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var messageHorizontal = mutableListOf<MessageHorizontalModel>()
        var messageVertical = mutableListOf<MessageVerticalModel>()

        for (item in 0 until 20) {
            val idResource =
                this.resources.getIdentifier(
                    "avatar_${item % 5 + 1}",
                    "drawable",
                    activity?.packageName
                )
            messageHorizontal.add(
                MessageHorizontalModel(
                    idResource,
                    "Selma $item"
                )
            )
            messageVertical.add(
                MessageVerticalModel(
                    idResource,
                    "Emeline $item",
                    "Hello how are you? I am going to market. Do you want burgers $item",
                    item,
                    5,
                    item == 0
                )
            )
        }

        // Initialize adapter
        val adapter = MessageHorizontalAdapter(
            messageHorizontal
        )
        // set layout manager
        rvMessageHorizontal.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        // set adapter
        rvMessageHorizontal.adapter = adapter

        val adapterBig =
            MessageVerticalAdapter(messageVertical)
        rvMessageVertical.adapter = adapterBig
        rvMessageVertical.layoutManager =
            LinearLayoutManager(activity)

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}