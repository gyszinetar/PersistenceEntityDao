package hu.prooktatas.persistenceentitydao.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import hu.prooktatas.persistenceentitydao.persistence.dao.AuthorDao
import hu.prooktatas.persistenceentitydao.persistence.entity.Author

@Database(entities = [Author::class], version = 1)
abstract class MusicDatabase: RoomDatabase() {

    abstract fun authorDao(): AuthorDao

    companion object {
        private var dbInstance: MusicDatabase? = null

            internal fun getDatabase(context: Context): MusicDatabase? {
                if (dbInstance == null) {
                    synchronized(MusicDatabase::class.java) {
                        if (dbInstance == null) {
                            dbInstance = Room.databaseBuilder(context.applicationContext, MusicDatabase::class.java, "music").build()
                        }
                    }
                }

                return dbInstance
        }
    }
}