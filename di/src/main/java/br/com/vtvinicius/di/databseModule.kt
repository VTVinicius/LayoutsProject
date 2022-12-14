package br.com.vtvinicius.di

import androidx.room.Room
import br.com.vtvinicius.data_local.database.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "app-database"
        ).build()
    }

    single { get<AppDatabase>().viaCepDao() }


}