package com.sammy.datasource.cache

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sammy.datasource.cache.genre.Genre
import com.sammy.datasource.cache.genre.GenreDao
import com.sammy.datasource.cache.genre.GenreResponse
import com.sammy.datasource.cache.movies.MovieDao
import com.sammy.datasource.cache.movies.MoviesResponse
import com.sammy.datasource.cache.trailer.TrailerDao
import com.sammy.datasource.cache.trailer.TrailerResponse
import com.sammy.datasource.utils.Converters

@Database(
    entities = [
        MoviesResponse::class,
        GenreResponse::class,
    TrailerResponse::class
    ], version = 1
)
@TypeConverters(Converters::class)
abstract class MainDatabase : RoomDatabase() {


    abstract fun genreDao(): GenreDao

    abstract fun movieDao(): MovieDao

    abstract fun trailerDao():TrailerDao


    companion object {
        @Volatile
        private var INSTANCE: MainDatabase? = null

        fun getDatabase(context: Context): MainDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MainDatabase::class.java,
                    "MainDatabase"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}