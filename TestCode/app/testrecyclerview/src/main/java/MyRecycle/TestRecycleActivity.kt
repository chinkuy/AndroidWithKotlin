package MyRecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import vd.samsung.mce.testrecyclerview.R
import vd.samsung.mce.testrecyclerview.databinding.ActivityTestRecycleBinding
import vd.samsung.mce.testrecyclerview.databinding.ItemdataBinding

//RecyclerView Test

class TestRecycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityTestRecycleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = mutableListOf<String>()

        for(i in 1..10){
            data.add("Hello $i")
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = MyAdapter(data)

        //binding.recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

    }
}

class MyHolder(val binding : ItemdataBinding): RecyclerView.ViewHolder(binding.root){

}

class MyAdapter(val data: MutableList<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyHolder(ItemdataBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as MyHolder).binding
        binding.itemdata.text = data[position]
    }

    override fun getItemCount(): Int {
        return data.size
    }
}