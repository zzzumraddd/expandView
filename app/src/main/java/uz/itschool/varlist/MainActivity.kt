package uz.itschool.varlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import uz.itschool.varlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var leaugues: MutableMap<String, ArrayList<String>>
    private lateinit var binding: ActivityMainBinding
    private lateinit var leagueTitle: ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    loadDate()
        val adapter = Leugue_Adapter(leaugues, leagueTitle)
        binding.expand.setAdapter(adapter)

    }
    private fun loadDate(){
        leaugues = mutableMapOf()
        var Laliga = arrayListOf("Barcelona", "Real Madrid", "Atletiko Madrid")
        var Laliga2 = arrayListOf("Barcelona2", "Real Madrid2", "Atletiko Madrid2")
        var Laliga3 = arrayListOf("Barcelona3", "Real Madrid3", "Atletiko Madrid3")
        leaugues.put("Laliga", Laliga)
        leaugues.put("Laliga2", Laliga2)
        leaugues.put("Laliga3", Laliga3)
        leagueTitle= ArrayList(leaugues.keys)
    }
}