package com.iriton.urfurate

import MeetAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_meet.*

class MeetFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_meet, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myRecycler.layoutManager = LinearLayoutManager(this.activity)
        val items = listOf(MeetItem("15:00", "17:00", "Поход в музей", "Скоро"),
            MeetItem("16:00", "18:30", "Поход в кино", "Скоро")
        )
        val myAdapter = MeetAdapter(items, object : MeetAdapter.Callback {
            override fun onItemClicked(item: MeetItem) {
                //TODO Сюда придёт элемент, по которому кликнули. Можно дальше с ним работать
            }
        })
        myRecycler.adapter = myAdapter
    }

}