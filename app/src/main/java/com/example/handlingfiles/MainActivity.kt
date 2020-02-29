package com.example.handlingfiles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        save_to_file.setOnClickListener {
            writeToFile("data1.txt")
        }

        read_from_file.setOnClickListener {
            readFromFile("data1.txt")
        }
    }

    private fun writeToFile(fileName: String){
        val file = File(filesDir, fileName)

        val data = file_text.text.toString()

        file.writeText(data)

//        file.writeBytes(data.toByteArray())

//        file.bufferedWriter().use{ out->
//            out.write(data)
//        }

        file_text.setText("")
    }

    private fun readFromFile(fileName: String){
        val file = File(filesDir, fileName)

        file_text.setText(file.readText())

//        file_text.setText(file.readBytes().toString(Charsets.UTF_8))

//        file_text.setText(file.bufferedReader().readText())

    }
}
