package com.rsamqui.bakingbills.bd.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rsamqui.bakingbills.bd.entidades.IngredienteEntity
import com.rsamqui.bakingbills.bd.entidades.ProductoEntity
import com.rsamqui.bakingbills.bd.entidades.UsuarioEntity

interface MainDataBaseProvider {
    fun usuarioDao(): UsuarioDao
    fun productoDao(): ProductoDao
    fun ingredienteDao(): IngredienteDao
}

@Database(
    entities = [UsuarioEntity::class, ProductoEntity::class, IngredienteEntity::class], version = 3
)
abstract class BDPanadería : RoomDatabase(), MainDataBaseProvider {
    abstract override fun usuarioDao(): UsuarioDao
    abstract override fun productoDao(): ProductoDao
    abstract override fun ingredienteDao(): IngredienteDao


    companion object {
        @Volatile
        private var INSTANCE: BDPanadería? = null
        fun getDataBase(context: Context): BDPanadería {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        BDPanadería::class.java,
                        "main_bdpanaderia"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}