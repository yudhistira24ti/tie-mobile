package com.example.pertemuan.Message

import android.content.Intent // TAMBAHAN
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu // TAMBAHAN
import android.view.MenuInflater // TAMBAHAN
import android.view.MenuItem // TAMBAHAN
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.pertemuan.Message.tutorial.TutorialMessageActivity // TAMBAHAN
import com.example.pertemuan.R // TAMBAHAN
import com.example.pertemuan.databinding.FragmentMessageBinding


class MessageFragment : Fragment() {

    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!

    private val messageList = listOf(
        MessageModel("Alya", "Halo! Apa kabar?", "https://avatarapi.runflare.run/public/1"),
        MessageModel("Budi", "Sudah makan?", "https://avatarapi.runflare.run/public/2"),
        MessageModel("Citra", "Jangan lupa tugasnya ya!", "https://avatarapi.runflare.run/public/3"),
        MessageModel("Dika", "Besok kita rapat jam 9", "https://avatarapi.runflare.run/public/4"),
        MessageModel("Eka", "Nice job kemarin!", "https://avatarapi.runflare.run/public/5"),
        MessageModel("Fajar", "Lagi ngapain?", "https://avatarapi.runflare.run/public/6"),
        MessageModel("Gita", "Boleh minta tolong?", "https://avatarapi.runflare.run/public/7"),
        MessageModel("Hana", "Lihat email ya", "https://avatarapi.runflare.run/public/8"),
        MessageModel("Irfan", "Oke noted", "https://avatarapi.runflare.run/public/9"),
        MessageModel("Joko", "Sampai jumpa besok", "https://avatarapi.runflare.run/public/10")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Message"

        setHasOptionsMenu(true) // TAMBAHAN: agar option menu tampil


        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItems.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.message_toolbar_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_tutorial -> {
                val intent = Intent(requireContext(), TutorialMessageActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}