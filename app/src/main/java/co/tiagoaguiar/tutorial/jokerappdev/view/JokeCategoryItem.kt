package co.tiagoaguiar.tutorial.jokerappdev.view

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import co.tiagoaguiar.tutorial.jokerappdev.R
import co.tiagoaguiar.tutorial.jokerappdev.model.JokeCategory
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item

class JokeCategoryItem(val category: JokeCategory) : Item<JokeCategoryItem.CategoryViewHolder>() {

    override fun createViewHolder(itemView: View) = CategoryViewHolder(itemView)

    override fun bind(viewHolder: CategoryViewHolder, position: Int) {
        viewHolder.itemView.findViewById<TextView>(R.id.txt_category).text = category.name
        viewHolder.itemView.findViewById<LinearLayout>(R.id.container_category)
            .setBackgroundColor(category.backgroundColor.toInt())
    }

    override fun getLayout(): Int = R.layout.item_category

    inner class CategoryViewHolder(view: View) : GroupieViewHolder(view)
}