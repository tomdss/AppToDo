package com.example.mytodo1.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "users")
data class User(
    @ColumnInfo(name = "name") var name: String = "",
    @ColumnInfo(name = "age") var age: Int = 0
)