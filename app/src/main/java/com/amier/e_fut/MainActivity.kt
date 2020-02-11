package com.amier.e_fut

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Pair
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amier.e_fut.adapter.MainRecyclerAdapter
import com.amier.e_fut.fragment.AccountFragment
import com.amier.e_fut.fragment.HomeFragment
import com.amier.e_fut.model.Items
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var fragment: Fragment
    private lateinit var bottomNavigation: AHBottomNavigation
    lateinit var recyclerView: RecyclerView
    val adapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setup()

        adapter.add(MainRecyclerAdapter(Items("Makan","Ayam",4f,R.drawable.lapangan_futsal_1)))
        adapter.add(MainRecyclerAdapter(Items("Maka","Ayam",2f,R.drawable.lapangan_futsal_2)))
        adapter.add(MainRecyclerAdapter(Items("Mak","Ayam",3f,R.drawable.lapangan_futsal_3)))
        adapter.add(MainRecyclerAdapter(Items("MP","M",5f,R.drawable.lapangan_futsal_4)))

        adapter.setOnItemClickListener { item, view ->
            val mra = item as MainRecyclerAdapter
            val items = mra.list

            val intent = Intent(this,DetailActivity::class.java)
            intent.putExtra("items",items)
            val options = ActivityOptions.makeSceneTransitionAnimation(this, Pair.create(view.findViewById<ImageView>(R.id.main_item_image),"imgtranslate"))
            startActivity(intent,options.toBundle())
        }

        bottomNavigation.setOnTabSelectedListener { position, _ ->
//            displayFragment(position)
            true
        }
    }
    private fun setup(){
        val item1 = AHBottomNavigationItem(R.string.home, R.drawable.ic_home, R.color.colorPrimary)
        val item2 = AHBottomNavigationItem(R.string.account, R.drawable.ic_person, R.color.colorPrimaryDark)
        bottomNavigation = findViewById(R.id.main_bottomnavigation)
        bottomNavigation.addItem(item1)
        bottomNavigation.addItem(item2)
        bottomNavigation.isColored = true

//        displayFragment(0)
        main_et_search.isFocusable = false
        recyclerView = findViewById(R.id.main_recycler)
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerView.adapter = adapter
    }

    private fun displayFragment(pos:Int){
        var title = ""
        when (pos) {
            0 -> {
                title = "Beranda"
                fragment = HomeFragment()
            }
            1 -> {
                title = "Zona Baca"
                fragment = AccountFragment()
            }
        }
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.main_relative, fragment).commit()
        supportActionBar?.title = title
    }
}
