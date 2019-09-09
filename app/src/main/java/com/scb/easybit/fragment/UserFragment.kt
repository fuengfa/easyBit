package com.scb.easybit.fragment


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.scb.easybit.MainMenuActivity.Companion.fName
import com.scb.easybit.SellerActivity
import kotlinx.android.synthetic.main.fragment_user.view.*
import com.scb.easybit.MainMenuActivity.Companion.img
import com.scb.easybit.MainMenuActivity.Companion.lName


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class UserFragment : Fragment() {

    companion object {
        fun newInstance(): UserFragment = UserFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val _view:View = inflater.inflate(com.scb.easybit.R.layout.fragment_user, container, false)

        _view.auctionMenu.setOnClickListener {
            clickAuctionMenu()
        }

        setUserDetail(_view)





//        Glide.with(context!!).load("http://i.pinimg.com/originals/aa/eb/45/aaeb45f239fedec7ca853725e06f2b2e.jpg").apply(options).into(_view.profileImg)
//        val url = URL("https://i.pinimg.com/originals/aa/eb/45/aaeb45f239fedec7ca853725e06f2b2e.jpg")
//        val avatarImageView : ImageView = _view.userImg
//        val bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream())
//        avatarImageView.setImageBitmap(bmp)
        return _view
    }

    private fun setUserDetail(_view: View) {

        _view.name.setText(fName + " " + lName)

        context?.let {
            Log.d("profile",img)
            // If context is not null use it in the passed block as `it`
            Glide.with(it)
                .load(img)
                .into(_view.profileImg)
        }
    }


    private fun clickAuctionMenu() {
        val intent = Intent(context, SellerActivity::class.java)
        startActivity(intent)
    }


}
