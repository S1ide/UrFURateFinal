package com.iriton.urfurate

import MeetAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.applandeo.materialcalendarview.EventDay
import com.applandeo.materialcalendarview.listeners.OnDayClickListener
import kotlinx.android.synthetic.main.fragment_meet.*
import java.util.*


private val eventsDay = mutableListOf<EventDay>()
private val calendar = Calendar.getInstance()
private var events = mutableListOf<Event>()
private var selectedEvents = mutableListOf<Event>()

class MeetFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        events = mutableListOf(
                Event("Собрание с ректором", "13:00", "14:30", R.drawable.background_urfu,R.drawable.logo_urfu,
                    2020, 5, 1), Event("Мафия", "13:00", "14:30", R.drawable.background_rtf , R.drawable.logo_rtf,2020,
        5, 8), Event("Турнир по шахматам", "15:00", "16:30", R.drawable.background_hti, R.drawable.logo_hti, 2020,
        5, 11), Event("Онлайн-хакатон", "16:30", "18:30", R.drawable.background_fti,R.drawable.logo_fti, 2020,
        5, 16), Event("Культурный вечер", "12:00", "13:30", R.drawable.background_isa, R.drawable.logo_isa, 2020,
        5, 19), Event("Здоровый день", "15:00", "17:30", R.drawable.background_ifksimp, R.drawable.logo_ifksimp, 2020,
        5, 13), Event("Пикник", "16:00", "19:30", R.drawable.background_info, R.drawable.logo_info, 2020,
        5, 14), Event("Турнир по Dota 2", "19:30", "20:30", R.drawable.background_ienim, R.drawable.logo_ienim, 2020,
        5, 19), Event("Лекция от СБЕРБАНКа", "12:00", "13:30", R.drawable.background_igup, R.drawable.logo_igup, 2020,
        5, 5), Event("Мастер-класс", "18:00", "20:30", R.drawable.background_ineu, R.drawable.logo_ineu, 2020,
        5, 9), Event("Клуб гуманитариев", "09:00", "11:30", R.drawable.background_ugi, R.drawable.logo_ugi, 2020,
        5, 30), Event("Онлайн-марафон", "14:00", "14:30", R.drawable.background_inmit, R.drawable.logo_inmit, 2020,
        5, 15), Event("Как выжить", "13:00", "15:30", R.drawable.background_uenin, R.drawable.logo_uenin, 2020,
        5, 7))
        events.sortWith(compareBy({ it.timeOfStart }, { it.date }))

        return inflater.inflate(R.layout.fragment_meet, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        events.forEach {
            calendar.set(it.year, it.month - 1, it.date)
            eventsDay.add(EventDay(calendar, R.drawable.tochka))
        }
        calendarView.setEvents(eventsDay)
        val myAdapter = MeetAdapter(events, object : MeetAdapter.Callback {
            override fun onItemClicked(item: Event) {
                //TODO Сюда придёт элемент, по которому кликнули. Можно дальше с ним работать
            }
        })
        myRecycler.adapter = myAdapter
        calendarView.setOnDayClickListener(object :
            OnDayClickListener {
            override fun onDayClick(eventDay: EventDay) {
                val clickedDayCalendar = eventDay.calendar
                //TODO Когда нажимаешь на день, менять RecyclerView, под этот день
            }
        })
    }
}