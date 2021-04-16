package com.example.messager

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_detail_message.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailMessageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailMessageFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_detail_message, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var messengersList = mutableListOf(
            MessageDetailModel(
                1,
                R.drawable.avatar_1,
                "Hi Victor! I am jacob Jones",
                "urdu to English",
                "Hello Jacob, I know you.",
                R.drawable.ic_check_muted
            ),
            MessageDetailModel(
                2,
                R.drawable.avatar_1,
                "Hi Victor! I am jacob Jones",
                "urdu to English",
                "Hello Jacob, I know you.",
                R.drawable.ic_check_muted
            ),
            MessageDetailModel(
                3,
                R.drawable.avatar_1,
                "Hi Victor! I am jacob Jones",
                "urdu to English",
                "Hello Jacob, I know you.",
                R.drawable.ic_check_muted
            ),
            MessageDetailModel(
                4,
                R.drawable.avatar_1,
                "Hi Victor! I am jacob Jones",
                "urdu to English",
                "Hello Jacob, I know you.",
                R.drawable.ic_check_muted
            ),
            MessageDetailModel(
                5,
                R.drawable.avatar_1,
                "Hi Victor! I am jacob Jones",
                "urdu to English",
                "Hello Jacob, I know you.",
                R.drawable.ic_check_muted
            )
        )


        var usersList = listOf(
            UserModel(1, R.drawable.avatar_1, "Selma"),
            UserModel(2, R.drawable.avatar_2, "Kone na"),
            UserModel(3, R.drawable.avatar_3, "jean la"),
            UserModel(4, R.drawable.avatar_4, "Konta"),
            UserModel(5, R.drawable.avatar_5, "Tohoma")
        )

        Log.d("Hoang", usersList.toString())

        val adapter = MessageDetailAdapter(messengersList)
        rvMessenger.adapter = adapter
        rvMessenger.layoutManager =
            LinearLayoutManager(activity)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DetailMessageFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DetailMessageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}