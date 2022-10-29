package org.battir.personsform

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.versionedparcelable.VersionedParcelize

//@Person.Parcelize
//data class Person(val name:String, val ID:Int, val emai:String, val web:String) : Parcelable {
//}

class MainActivity : AppCompatActivity() {
    lateinit var name_edt: EditText
    lateinit var id_edt: EditText
    lateinit var email_edt: EditText
    lateinit var web_edt: EditText
    var personsList = mutableListOf<Person>()
    companion object{
        val formActivityCode=10
        val experienceActivityCode=12
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        name_edt = findViewById(R.id.edt_name)
        id_edt = findViewById(R.id.edt_ID)
        email_edt = findViewById(R.id.edt_email)
        web_edt = findViewById(R.id.edt_web)

        findViewById<Button>(R.id.btn_add).setOnClickListener() {
            personsList.add(Person(name_edt.text.toString(),
                id_edt.text.toString().toInt(),
                email_edt.text.toString(),
                web_edt.text.toString()))
            Toast.makeText(this, "Person Added", Toast.LENGTH_LONG).show()
            name_edt.text.clear()
            id_edt.text.clear()
            email_edt.text.clear()
            web_edt.text.clear()
        }
        findViewById<Button>(R.id.btn_show).setOnClickListener() {
            var intent: Intent = Intent(this@MainActivity, OutputActivity::class.java)
            intent.putParcelableArrayListExtra("PersonsList", ArrayList(personsList))
            startActivity(intent)
        }




    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelableArrayList("count", ArrayList(personsList))
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        personsList = savedInstanceState.getParcelableArrayList<Person>("PersonsList") as ArrayList<Person>
        startActivityForResult(Intent(this@MainActivity, FromScratchAtivity::class.java),formActivityCode)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(resultCode){
            formActivityCode->{

            }
            experienceActivityCode->{

            }
        }
    }
}