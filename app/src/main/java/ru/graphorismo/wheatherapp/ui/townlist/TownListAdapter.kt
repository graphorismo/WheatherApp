package ru.graphorismo.wheatherapp.ui.townlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.graphorismo.wheatherapp.R
import ru.graphorismo.wheatherapp.ui.activity.MainViewModel
import ru.graphorismo.wheatherapp.ui.activity.TownState
import ru.graphorismo.wheatherapp.ui.activity.UIState

class TownListAdapter(val viewModel: MainViewModel):
    RecyclerView.Adapter<TownListAdapter.TownListViewHolder>()
{


    class TownListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView

        init {
            title = itemView.findViewById(R.id.townListItem_title)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TownListViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.town_list_item,parent,false)
        return TownListViewHolder(view)
    }

    override fun onBindViewHolder(holder: TownListViewHolder, position: Int) {
        holder.title.text = TownState.values()[position].value
        holder.itemView.setOnClickListener(){
            viewModel.currentTown.value = TownState.values()[position]
            viewModel.uiState.value=UIState.MAIN
        }
    }

    override fun getItemCount(): Int {
        return TownState.values().size
    }
}