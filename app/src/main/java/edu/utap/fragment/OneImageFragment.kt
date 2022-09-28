package edu.utap.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import edu.utap.fragment.databinding.OneImageBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class OneImageFragment : Fragment() {
    // https://developer.android.com/topic/libraries/view-binding#fragments
    private var _binding: OneImageBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    // SafeArgs plugins
    private val args: OneImageFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = OneImageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainActivity = requireActivity() as MainActivity
        // NB: You have to modify MainActivity.hideBars for it to work properly
        mainActivity.hideBars()
        // Clicking the big image returns us to the four image fragment
        binding.oneImageIV.setOnClickListener {
            // Why don't we do this?
            // val action = OneImageFragmentDirections.actionOneImageFragmentToFourImageFragment()
            // findNavController().navigate(action)
            findNavController().popBackStack()
        }
        // XXX Write me
        val ivFirst = binding.oneImageIV
        ivFirst.setImageBitmap(mainActivity.bitMap.elementAt(args.index))
    }

    override fun onDestroyView() {
        // XXX Write me
        val mainActivity = requireActivity() as MainActivity
        mainActivity.showBars()
        _binding = null
        super.onDestroyView()
    }
}