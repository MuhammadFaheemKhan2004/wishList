package com.example.mywishlistapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wish-table")
class Wish(
    @PrimaryKey(autoGenerate = true)
    val id:Long=0L,
    @ColumnInfo(name="wish-title")
    val title:String="",
    @ColumnInfo(name="wish-desc")
    val description:String=""


)
object DummyWish{
    val wishList = listOf(
        Wish(title="Google 1",description="An Android Watch"),
        Wish(title="Google 2",description="An ios Watch"),
        Wish(title="Google 3",description="An Analog Watch")
    )
}