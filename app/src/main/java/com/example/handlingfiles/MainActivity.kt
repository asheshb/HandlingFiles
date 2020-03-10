package com.example.handlingfiles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        save_to_file.setOnClickListener {
            writeToFile("data.txt")
        }

        read_from_file.setOnClickListener {
            readFromFile("data.txt")
        }
    }

    private fun writeToFile(fileName: String){
        val file = File(getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), fileName)

        val data = file_text.text.toString()

        file.writeText(data)

        file_text.setText("")
    }

    private fun readFromFile(fileName: String){

        val file = File(getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), fileName)

        file_text.setText(file.readText())


    }
}
