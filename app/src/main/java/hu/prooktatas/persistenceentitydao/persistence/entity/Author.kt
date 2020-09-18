package hu.prooktatas.persistenceentitydao.persistence.entity

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "authors")
class Author() {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    var id: Int = 0

    var name: String = ""

}