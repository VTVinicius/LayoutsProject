package br.com.vtvinicius.basecomposetemplate


import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import br.com.vtvinicius.di.*
import br.com.vtvinicius.di.navigation.navigationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

//Classe de inicialização do Koin

@Suppress("unused")
class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        startKoin {
            modules(
                navigationModule +
                        listOf(
                            presentationModule,
                            domainModule,
                            dataModule,
                            dataRemoteModule,
                            dataLocalModule,
                            databaseModule
                        )
            ).androidContext(applicationContext)
        }
    }
}