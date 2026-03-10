package com.aisheti.sahayak.ui.language

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aisheti.sahayak.databinding.ActivityLanguageBinding
import com.aisheti.sahayak.databinding.ItemLanguageBinding
import com.aisheti.sahayak.ui.MainActivity
import com.aisheti.sahayak.utils.Language
import com.aisheti.sahayak.utils.Languages
import com.aisheti.sahayak.utils.PreferencesManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class LanguageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLanguageBinding

    @Inject
    lateinit var preferencesManager: PreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLanguageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val adapter = LanguageAdapter(Languages.all) { language ->
            lifecycleScope.launch {
                preferencesManager.saveLanguage(language.name, language.code)
                preferencesManager.setFirstLaunchDone()
                startActivity(Intent(this@LanguageActivity, MainActivity::class.java))
                finish()
            }
        }
        binding.recyclerLanguages.apply {
            layoutManager = GridLayoutManager(this@LanguageActivity, 2)
            this.adapter = adapter
        }
    }
}

class LanguageAdapter(
    private val languages: List<Language>,
    private val onSelect: (Language) -> Unit
) : RecyclerView.Adapter<LanguageAdapter.LanguageVH>() {

    inner class LanguageVH(val binding: ItemLanguageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(lang: Language) {
            binding.tvFlag.text = lang.flag
            binding.tvLanguageName.text = lang.name
            binding.tvNativeName.text = lang.nativeName
            binding.root.setOnClickListener { onSelect(lang) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        LanguageVH(ItemLanguageBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: LanguageVH, position: Int) =
        holder.bind(languages[position])

    override fun getItemCount() = languages.size
}
