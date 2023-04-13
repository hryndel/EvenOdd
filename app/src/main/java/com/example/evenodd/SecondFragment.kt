package com.example.evenodd

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.evenodd.databinding.FragmentFirstBinding
import com.example.evenodd.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    lateinit var binding: FragmentSecondBinding
    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater)
        return  binding.root
    }

    override  fun onViewCreated(view: View, savedInstanceState: Bundle?){
        dataModel.messageForSecondFragment.observe(activity as LifecycleOwner) {
            binding.PlayerFragmentFirst.text = it.first.toString()
            binding.PlayerFragmentSecond.text = it.second.toString()
            binding.PlayerFragmentThird.text = it.third.toString()
            binding.PlayerFragmentSum.text = it.toList().sum().toString()
            (binding.GroupPlayer.getChildAt((0..1).random()) as RadioButton).isChecked = true
            dataModel.messageFromSecondFragment.value = binding.PlayerFragmentEven.isChecked && it.toList().sum() % 2 == 0 || binding.PlayerFragmentOdd.isChecked && it.toList().sum() % 2 != 0
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = SecondFragment()
    }
}