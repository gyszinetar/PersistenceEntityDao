package hu.prooktatas.persistenceentitydao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import hu.prooktatas.persistenceentitydao.asynctask.AsyncInsertAuthor
import hu.prooktatas.persistenceentitydao.asynctask.fa
import hu.prooktatas.persistenceentitydao.persistence.MusicDatabase
import hu.prooktatas.persistenceentitydao.persistence.dao.AuthorDao
import hu.prooktatas.persistenceentitydao.persistence.entity.Author


class MainActivity : AppCompatActivity(), fa {
    private lateinit var button: Button
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button=findViewById(R.id.button)
        textView=findViewById(R.id.editTextTextPersonName)
        button.setOnClickListener {
            val a= Author()
            a.name=textView.editableText.toString()
            Log.d("dui","dui1")
            AsyncInsertAuthor(a,this,this).execute()
            Log.d("dui","dui2")
        }
    }

    override fun faAuthor(faA:List<Author>) {

        Log.d("dui",faA.toString())
        Log.d("dui","dui")
    }
}