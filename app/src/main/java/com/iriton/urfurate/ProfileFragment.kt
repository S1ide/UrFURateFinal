package com.iriton.urfurate

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.OvershootInterpolator
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.iriton.urfurate20.LoginActivity
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.recycler_item.view.*
import net.cachapa.expandablelayout.ExpandableLayout
import net.cachapa.expandablelayout.ExpandableLayout.OnExpansionUpdateListener

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        exitButton.setOnClickListener { v: View? ->
            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
        }
        recycler_view.layoutManager = LinearLayoutManager(context)
        recycler_view.adapter = SimpleAdapter(recycler_view, mutableListOf(Mero("Здесь будут ваши мероприятия", 0.0)))
    }


    private class SimpleAdapter(private val recyclerView: RecyclerView, val items:  List<Mero>) :
        RecyclerView.Adapter<SimpleAdapter.ViewHolder?>() {

        private var selectedItem = UNSELECTED

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_item, parent, false)
            return ViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind()
        }

        override fun getItemCount(): Int {
            return 2
        }

        inner class ViewHolder(itemView: View) :
            RecyclerView.ViewHolder(itemView),
            View.OnClickListener, OnExpansionUpdateListener {
            private val expandableLayout: ExpandableLayout
            private val titleView = itemView.findViewById<TextView>(R.id.title)
            private val subTitleView = itemView.findViewById<TextView>(R.id.subText)

            fun bind() {
                val position = adapterPosition
                val isSelected = position == selectedItem
                titleView.text = "Будущие мероприятия"
                if (position == 1)
                    titleView.text = "Прошедшие мероприятия"
                titleView.isSelected = isSelected
                subTitleView.text = "Здесь будут ваши мероприятия"
                expandableLayout.setExpanded(isSelected, false)
            }

            override fun onClick(view: View) {
                val holder =
                    recyclerView.findViewHolderForAdapterPosition(selectedItem) as ViewHolder?
                if (holder != null) {
                    holder.titleView.isSelected = false
                    holder.expandableLayout.collapse()
                }
                val position = adapterPosition
                if (position == selectedItem) {
                    selectedItem = UNSELECTED
                } else {
                    titleView.isSelected = true
                    expandableLayout.expand()
                    selectedItem = position
                }
            }

            override fun onExpansionUpdate(
                expansionFraction: Float,
                state: Int
            ) {
                Log.d("ExpandableLayout", "State: $state")
                if (state == ExpandableLayout.State.EXPANDING) {
                    recyclerView.smoothScrollToPosition(adapterPosition)
                }
            }

            init {
                expandableLayout = itemView.findViewById(R.id.expandable_layout)
                expandableLayout.setInterpolator(OvershootInterpolator())
                expandableLayout.setOnExpansionUpdateListener(this)
                titleView.setOnClickListener(this)
            }
        }

        companion object {
            private const val UNSELECTED = -1
        }

    }
}
