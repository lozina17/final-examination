package example.tatyana.myfinalexaminationapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class InfoFragment : Fragment() {

    lateinit var developersRecycleView: RecyclerView
    lateinit var webSiteButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_info, container, false)

        val developersNames: List<String> = listOf("Tatyana")

        webSiteButton = view.findViewById(R.id.web_site_button)
        developersRecycleView = view.findViewById(R.id.developers_recycler_view)
        developersRecycleView.layoutManager = LinearLayoutManager(
            context, LinearLayoutManager.VERTICAL,
            false
        )
        developersRecycleView.adapter = DeveloperAdapter(developersNames)


        webSiteButton.setOnClickListener {
            val link = Uri.parse("https://google.com/")
            val intent = Intent(Intent.ACTION_VIEW, link)
            context?.startActivity(intent)


        }

        return view
    }


}