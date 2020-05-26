import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.iriton.urfurate.MeetItem
import com.iriton.urfurate.R

class MeetAdapter(var items: List<MeetItem>, val callback: Callback) : RecyclerView.Adapter<MeetAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = MainHolder(LayoutInflater.from(parent.context).inflate(R.layout.main_item, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val startTime = itemView.findViewById<TextView>(R.id.startTime)
        private val endTime = itemView.findViewById<TextView>(R.id.endTime)
        private val meetName = itemView.findViewById<TextView>(R.id.meetName)

        fun bind(item: MeetItem) {
            startTime.text = item.timeOfStart
            endTime.text = item.timeOfEnd
            meetName.text = item.nameOfMeet

            itemView.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) callback.onItemClicked(items[adapterPosition])
            }
        }
    }

    interface Callback {
        fun onItemClicked(item: MeetItem)
    }

}