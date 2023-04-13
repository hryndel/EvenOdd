package com.example.evenodd

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.evenodd.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    lateinit var binding: FragmentFirstBinding
    private val dataModel: DataModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater)
        return  binding.root
    }

    override  fun onViewCreated(view: View, savedInstanceState: Bundle?){
        dataModel.messageForFirstFragment.observe(activity as LifecycleOwner) {
            if (binding.GroupComputer.checkedRadioButtonId != -1) {
                binding.ComputerFragmentFirst.text = it.first.toString()
                binding.ComputerFragmentSecond.text = it.second.toString()
                binding.ComputerFragmentThird.text = it.third.toString()
                binding.ComputerFragmentSum.text = it.toList().sum().toString()
                dataModel.messageFromFirstFragment.value = binding.ComputerFragmentEven.isChecked && it.toList().sum() % 2 == 0 || binding.ComputerFragmentOdd.isChecked && it.toList().sum() % 2 != 0
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = FirstFragment()
    }
}
