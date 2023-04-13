package com.example.evenodd

import android.annotation.SuppressLint
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.example.evenodd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val dataModel: DataModel by viewModels()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        openFrag(FirstFragment.newInstance(), R.id.FirstFragment)
        openFrag(SecondFragment.newInstance(), R.id.SecondFragment)

        binding.buttonStart.setOnClickListener{
            dataModel.messageForFirstFragment.value = GenerateNumbers()
        }

        dataModel.messageFromFirstFragment.observe(this) {
            if (it) binding.PlayerCount.text = (binding.PlayerCount.text.toString().toInt() + 1).toString()
            dataModel.messageForSecondFragment.value = GenerateNumbers()
        }

        dataModel.messageFromSecondFragment.observe(this) {
            if (it) binding.PCCount.text = (binding.PCCount.text.toString().toInt() + 1).toString()
        }
    }
    private fun openFrag(f: Fragment, idHolder: Int){
        supportFragmentManager
            .beginTransaction()
            .replace(idHolder, f)
            .commit()
    }
    fun GenerateNumbers(): Triple<Int, Int, Int> = Triple((1..6).random(), (1..6).random(), (1..6).random())
    fun Exit(view: View) = finishAndRemoveTask()
}