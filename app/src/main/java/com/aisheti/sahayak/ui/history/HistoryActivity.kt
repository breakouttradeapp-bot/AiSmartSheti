package com.aisheti.sahayak.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aisheti.sahayak.data.models.ScanHistory
import com.aisheti.sahayak.databinding.ActivityHistoryBinding
import com.aisheti.sahayak.databinding.ItemHistoryBinding
import com.aisheti.sahayak.viewmodel.HistoryViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@AndroidEntryPoint
class HistoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHistoryBinding
    private val viewModel: HistoryViewModel by viewModels()
    private val historyAdapter = HistoryAdapter { item -> viewModel.deleteHistory(item) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener { finish() }

        binding.recyclerHistory.apply {
            layoutManager = LinearLayoutManager(this@HistoryActivity)
            adapter = historyAdapter
        }

        viewModel.scanHistory.observe(this) { list ->
            historyAdapter.submitList(list)
            binding.tvEmpty.visibility = if (list.isEmpty()) View.VISIBLE else View.GONE
        }
    }
}

class HistoryAdapter(
    private val onDelete: (ScanHistory) -> Unit
) : RecyclerView.Adapter<HistoryAdapter.HistoryVH>() {

    private var items = listOf<ScanHistory>()

    fun submitList(list: List<ScanHistory>) {
        items = list
        notifyDataSetChanged()
    }

    inner class HistoryVH(val binding: ItemHistoryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ScanHistory) {
            val icon = when (item.type) {
                "disease" -> "📷"
                "weather" -> "🌦"
                "fertilizer" -> "🌱"
                else -> "🎤"
            }
            binding.tvIcon.text = icon
            binding.tvType.text = item.type.replaceFirstChar { it.uppercase() }
            binding.tvQuery.text = item.query
            binding.tvResponse.text = item.response.take(100) + if (item.response.length > 100) "…" else ""
            binding.tvTime.text = SimpleDateFormat("dd MMM yyyy, HH:mm", Locale.getDefault())
                .format(Date(item.timestamp))
            binding.btnDelete.setOnClickListener { onDelete(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        HistoryVH(ItemHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: HistoryVH, position: Int) = holder.bind(items[position])
    override fun getItemCount() = items.size
}
