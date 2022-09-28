package edu.utap.fragment

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import edu.utap.fragment.databinding.FourImageBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FourImageFragment : Fragment() {
    // https://developer.android.com/topic/libraries/view-binding#fragments
    private var _binding: FourImageBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private fun makeImageClickable(imageView: ImageView, index: Int) {
        imageView.setOnClickListener {
            // XXX Write me (findNavController())
            NavHostFragment.findNavController(this).
            navigate(FourImageFragmentDirections.actionFourImageFragmentToOneImageFragment(index))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FourImageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainActivity = requireActivity() as MainActivity
        // XXX Write me

        mainActivity.hideBars()

        val ivFirst = binding.IV0
        ivFirst.setImageBitmap(BitmapFactory.decodeStream(this.context?.assets?.open("aye_aye.jpg")))
        binding.IV0.setOnClickListener {
            makeImageClickable(binding.IV0, 0)
        }

        val ivSecond = binding.IV1
        ivSecond.setImageBitmap(BitmapFactory.decodeStream(this.context?.assets?.open("ben_atchley_arm_nocpr.jpg")))
        binding.IV1.setOnClickListener {
            makeImageClickable(binding.IV1, 1)

        }

        val ivThird = binding.IV2
        ivThird.setImageBitmap(BitmapFactory.decodeStream(this.context?.assets?.open("red_panda.jpg")))
        binding.IV2.setOnClickListener {
            makeImageClickable(binding.IV2, 2)

        }

        val ivFourth = binding.IV3
        ivFourth.setImageBitmap(BitmapFactory.decodeStream(this.context?.assets?.open("watchmen_rorschach.jpg")))
        binding.IV3.setOnClickListener {
            makeImageClickable(binding.IV3, 3)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}