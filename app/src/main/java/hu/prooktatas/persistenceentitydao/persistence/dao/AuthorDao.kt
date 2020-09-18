package hu.prooktatas.persistenceentitydao.persistence.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import hu.prooktatas.persistenceentitydao.persistence.entity.Author

@Dao
interface AuthorDao{

    @Insert
    fun insertAuthor(author: Author)

    @Query("select * from authors")
    fun fetchAll(): List<Author>


    @Delete
    fun delete(author: Author)

}