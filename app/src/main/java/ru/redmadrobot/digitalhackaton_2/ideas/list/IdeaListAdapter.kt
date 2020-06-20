package ru.redmadrobot.digitalhackaton_2.ideas.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.redmadrobot.digitalhackaton_2.databinding.ItemIdeaOfferBinding
import ru.redmadrobot.digitalhackaton_2.ideas.list.data.IdeaOffer

class IdeaListAdapter(private val items: MutableList<IdeaOffer>) : RecyclerView.Adapter<IdeaOfferViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IdeaOfferViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemPersonBinding = ItemIdeaOfferBinding.inflate(layoutInflater, parent, false)
        return IdeaOfferViewHolder(itemPersonBinding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: IdeaOfferViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun updateList(newItems: List<IdeaOffer>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}


class IdeaOfferViewHolder(private val binding: ItemIdeaOfferBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(idea: IdeaOffer) {
        binding.tvTitle.text = idea.theme
        binding.tvAuthor.text = "Елисеев Влад ${idea.created.substring(0, 10)}"
        binding.tvBody.text = idea.description
        binding.tvCategory.text = idea.category.name
        binding.btnLikes.text = idea.likeCount
    }

}
