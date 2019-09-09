package com.scb.easybit.fragment


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.scb.easybit.R
import kotlinx.android.synthetic.main.fragment_main.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class MainFragment : Fragment() {
    private lateinit var mAdapter: CustomAdapter

    companion object {
        fun newInstance(): MainFragment = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val _view = inflater.inflate(R.layout.fragment_main, container, false)

        _view.recyclerView.let {
//            it.adapter = mAdapter

            //IMPORTANT ! ! ! ! ! !
//            it.layoutManager = LinearLayoutManager(activity)
            it.layoutManager = LinearLayoutManager(activity, LinearLayout.HORIZONTAL,false)
            //it.layoutManager = GridLayoutManager(activity,2)
        }

        return _view


    }

    inner class CustomAdapter(val context: Context) : RecyclerView.Adapter<CustomHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {

            return CustomHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.bidnow_layout,
                    parent,
                    false
                )
            )
        }

        override fun getItemCount(): Int = 2

        override fun onBindViewHolder(holder: CustomHolder, position: Int) {
//            val item = mDataArray[position]
//
//            holder.titleTextView.text = item.title
//            holder.subtitleTextView.text = item.subtitle
//
//            Glide.with(context!!).load(item.avatar_image).apply(RequestOptions.circleCropTransform())
//                .into(holder.avatarImageView)
//            Glide.with(context!!).load(item.youtube_image).into(holder.youtubeImageView)
//
//            //unique id
//            holder.avatarImageView.setTag(R.id.avatarImageView,item.title)
//            holder.itemView.setTag(R.id.view_pager,item.id)


        }

    }

    inner class CustomHolder(view: View) : RecyclerView.ViewHolder(view) {

//        val avatarImageView : ImageView = view.avatarImageView
//        val titleTextView : TextView = view.titleTextView
//        val subtitleTextView : TextView = view.subtitleTextView
//        val youtubeImageView : ImageView = view.youtubeImageView


    }

}
