package com.example.ukulima

import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.ukulima.databinding.FragmentDetailBinding

class Detail : Fragment() {

    lateinit var binding: FragmentDetailBinding
    private val args: DetailArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_detail, container, false)

        binding = FragmentDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        //parsing arguments
        Glide.with(binding.imageView)
            .load(args.detailsArgs.image)
            .into(binding.imageView)

        binding.textViewMaize.text = args.detailsArgs.title
        binding.textViewMaizePlant.text = args.detailsArgs.plant
        binding.textViewMaizePlace.text = args.detailsArgs.place
        //binding.textViewMaizeDiseases.text = args.detailsArgs.diseases

        binding.arrowDownBtn.setOnClickListener {
            if (binding.howToPlantScrollView.visibility == View.GONE){
                TransitionManager.beginDelayedTransition(binding.expandedViewPlant,AutoTransition())
                binding.howToPlantScrollView.visibility == View.VISIBLE
                binding.arrowDownBtn.setBackgroundResource(R.drawable.ic_arrow_up)
            }else{
                TransitionManager.beginDelayedTransition(binding.expandedViewPlant,AutoTransition())
                binding.howToPlantScrollView.visibility == View.GONE
                binding.arrowDownBtn.setBackgroundResource(R.drawable.ic_arrow_down)
            }
        }
        binding.arrowDown1.setOnClickListener {
            if (binding.textViewMaizePlace.visibility == View.GONE){
                TransitionManager.beginDelayedTransition(binding.whereScroll,AutoTransition())
                binding.textViewMaizePlace.visibility == View.VISIBLE
                binding.arrowDown1.setBackgroundResource(R.drawable.ic_arrow_up)
            }else{
                TransitionManager.beginDelayedTransition(binding.whereScroll,AutoTransition())
                binding.textViewMaizePlace.visibility == View.GONE
                binding.arrowDown1.setBackgroundResource(R.drawable.ic_arrow_up    )
            }
        }


        /*binding.textHowToPlant.setOnClickListener{
            if (binding.expandedViewPlant.visibility == View.GONE) {
            //TransitionManager.beginDelayedTransition(binding.expandedViewPlant, AutoTransition())
            binding.expandedViewPlant.visibility == View.VISIBLE
            binding.arrowDownBtn.setBackgroundResource(R.drawable.ic_arrow_up)
            }else{
            //TransitionManager.beginDelayedTransition(binding.expandedViewPlant, AutoTransition())
            binding.expandedViewPlant.visibility == View.GONE
            binding.arrowDownBtn.setBackgroundResource(R.drawable.ic_arrow_down)
        }
    }*/

        return view
    }
}