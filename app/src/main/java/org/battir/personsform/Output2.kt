package org.battir.personsform

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityOptionsCompat

class Output2 : AppCompatActivity() {

    lateinit var output_tv: TextView
    var personsList= mutableListOf<Person>()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_output2)
        output_tv=findViewById(R.id.tv_output)
        //personsList = intent.getParcelableArrayListExtra<Person>("PersonsList") as ArrayList<Person>
//        var index:Int
//        index=0
//        for (p:Person in personsList){
//            with(output_tv){
//                append("Index : ${index++} \n")
//                append(p.toString().plus("\n"))
//            }
//        }
        findViewById<Button>(R.id.btn_finish).setOnClickListener(){

            //The old way to start activity for result
           // startActivityForResult(Intent(this@Output2,PersonForm2::class.java),10)
            // The new  way to start activity for result
            val intent = Intent(this@Output2,PersonForm2::class.java)
            getResult.launch(intent)
        }
       // setResult(10,intent)
    }
    override fun onBackPressed() {
        finish()
    }


    //The new way to receive data
    private val getResult =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) {
            if(it.resultCode == Activity.RESULT_OK){
                var person = it.data?.getParcelableExtra<Person>("Person")!!
                personsList.add(person)
                var index:Int
                index=0
                for (p:Person in personsList){
                    with(output_tv){
                        append("Index : ${index++} \n")
                        append(p.toString().plus("\n"))
                    }
                }
            }
        }
    //The Deprecated Way to receive data
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        var person = data?.getParcelableExtra<Person>("Person")!!
//        personsList.add(person)
//        var index:Int
//        index=0
//        for (p:Person in personsList){
//            with(output_tv){
//                append("Index : ${index++} \n")
//                append(p.toString().plus("\n"))
//            }
//        }
//    }
}