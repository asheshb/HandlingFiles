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
            writeToFile("data.txt")
        }

        read_from_file.setOnClickListener {
            readFromFile("data.txt")
        }
    }

    private fun writeToFile(fileName: String){
        val file = File.createTempFile(fileName, null, cacheDir)

        val data = file_text.text.toString()

        file.writeText(data)

        file_text.setText("")

        //file_text.setText("Data written to file: ${file.name}")
    }

    private fun readFromFile(fileName: String){

        val files = cacheDir.listFiles()
        files?.forEach {
            file_text.append("${it.name}\n")
        }
    }
}
