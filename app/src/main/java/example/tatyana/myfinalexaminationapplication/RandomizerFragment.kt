package example.tatyana.myfinalexaminationapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment

private const val LAST_ROLLED_IMAGE = "image"

class RandomizerFragment : Fragment() {

    lateinit var numberImageView: ImageView
    lateinit var randomButton: Button

    private val numberImageList: List<Int> = listOf(
        R.drawable.one,
        R.drawable.two,
        R.drawable.three,
        R.drawable.four,
        R.drawable.five,
        R.drawable.six,
        R.drawable.seven,
        R.drawable.eight,
        R.drawable.nine,
        R.drawable.ten,
    )

    var lastRolledImageRec = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_randomizer, container, false)

        numberImageView = view.findViewById(R.id.number_image_view)
        randomButton = view.findViewById(R.id.random_button)


        if (savedInstanceState!=null)
            numberImageView.setImageResource(savedInstanceState.getInt(LAST_ROLLED_IMAGE))


        randomButton.setOnClickListener {
            lastRolledImageRec = numberImageList.random()
            numberImageView.setImageResource(lastRolledImageRec)
        }


        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_ROLLED_IMAGE, lastRolledImageRec)
    }


}