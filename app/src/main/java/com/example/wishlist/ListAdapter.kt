package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter (private val lists: MutableList<Listing>) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // TODO: Create member variables for any view that will be set
        // as you render a row.
        val itemEditText: TextView
        val urlEditText: TextView
        val priceEditText: TextView
        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            // TODO: Store each of the layout's views into
            // the public final member variables created above
            itemEditText = itemView.findViewById(R.id.wishName)
            urlEditText=itemView.findViewById(R.id.wishUrl)
            priceEditText=itemView.findViewById(R.id.wishPrice)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context=parent.context
        val inflater= LayoutInflater.from(context)
        val contactView=inflater.inflate(R.layout.list_item, parent, false)

        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val list=lists[position]
        holder.itemEditText.text= list.item
        holder.urlEditText.text=list.url_type
        holder.priceEditText.text=list.price.toString()

    }

    override fun getItemCount(): Int {
        return lists.size
    }
}