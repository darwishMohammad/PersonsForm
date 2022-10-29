package org.battir.personsform

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class PersonForm2 : AppCompatActivity() {
    lateinit var name_edt: EditText
    lateinit var id_edt: EditText
    lateinit var email_edt: EditText
    lateinit var web_edt: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_form2)
        name_edt = findViewById(R.id.edt_name)
        id_edt = findViewById(R.id.edt_ID)
        email_edt = findViewById(R.id.edt_email)
        web_edt = findViewById(R.id.edt_web)

        findViewById<Button>(R.id.btn_add).setOnClickListener() {
            setResult(Activity.RESULT_OK, Intent().putExtra("Person",Person(name_edt.text.toString(),
                id_edt.text.toString().toInt(),
                email_edt.text.toString(),
                web_edt.text.toString())))
            Toast.makeText(this, "Person Added", Toast.LENGTH_LONG).show()
            name_edt.text.clear()
            id_edt.text.clear()
            email_edt.text.clear()
            web_edt.text.clear()
            finish()
        }
        findViewById<Button>(R.id.btn_show).setOnClickListener() {
            finish()
        }
    }
}