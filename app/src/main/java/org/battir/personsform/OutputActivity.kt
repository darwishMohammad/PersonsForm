package org.battir.personsform

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class OutputActivity : AppCompatActivity() {

    lateinit var output_tv: TextView
    var personsList= mutableListOf<Person>()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.persons_list)
        output_tv=findViewById(R.id.tv_output)
        personsList = intent.getParcelableArrayListExtra<Person>("PersonsList") as ArrayList<Person>
        var index:Int
        index=0
        for (p:Person in personsList){
            with(output_tv){
                append("Index : ${index++} \n")
                append(p.toString().plus("\n"))
            }
        }
        findViewById<Button>(R.id.btn_finish).setOnClickListener(){
            finish()
        }
        setResult(10,intent)
    }
    override fun onBackPressed() {
        finish()
    }
}


