package hu.prooktatas.persistenceentitydao.asynctask

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import hu.prooktatas.persistenceentitydao.persistence.MusicDatabase
import hu.prooktatas.persistenceentitydao.persistence.dao.AuthorDao
import hu.prooktatas.persistenceentitydao.persistence.entity.Author
interface  fa{
    fun faAuthor(faA:List<Author>)
}
class  AsyncInsertAuthor(val author: Author,val context: Context,val fa:fa):AsyncTask<Unit,Unit,List<Author>>(){

    override fun doInBackground(vararg p0: Unit) :List<Author> {
        val dao = MusicDatabase.getDatabase(context)?.authorDao()
        dao!!.insertAuthor(author)
        return dao!!.fetchAll()

    }

    override fun onPostExecute(result: List<Author>) {
        super.onPostExecute(result)
        val dao = MusicDatabase.getDatabase(context)?.authorDao()
        fa.faAuthor(result)
        Log.d("dui", "onPostExecute")
        return
    }

}