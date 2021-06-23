package com.example.gift

import android.app.Person
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager

private val RequestManager.placeHolder: Unit
    get() {}

class Adapter(private val list: List<Person>) : RecyclerView.Adapter<Adapter.RecycleViewHolder>() {

    class RecycleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView = itemView.findViewById<TextView>(R.id.textView5)
        private val textView2 = itemView.findViewById<TextView>(R.id.textView6)
        private val imageView : ImageView = itemView.findViewById(R.id.imageView2)

        fun bindPerson(person: Person) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewHolder {
        return RecycleViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.fragment_home,
                parent,
            )
        )
    }


    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = list.size
}