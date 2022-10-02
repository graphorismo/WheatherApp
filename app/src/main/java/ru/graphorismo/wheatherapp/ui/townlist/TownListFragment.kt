package ru.graphorismo.wheatherapp.ui.townlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.graphorismo.wheatherapp.R
import ru.graphorismo.wheatherapp.ui.activity.MainViewModel

class TownListFragment : Fragment() {

    val activityViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =
            inflater.inflate(R.layout.fragment_town_list, container, false)
        var recyclerView =
            view.findViewById<RecyclerView>(R.id.townListFragment_recyclerView)
        recyclerView.layoutManager =
            LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = TownListAdapter(activityViewModel)
        return view
    }

}