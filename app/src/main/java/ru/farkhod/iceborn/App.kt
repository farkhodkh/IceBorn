package ru.farkhod.iceborn

import android.app.Application
import android.content.Context
import ru.farkhod.iceborn.components.AppComponent
import ru.farkhod.iceborn.components.DaggerAppComponent

class App(): Application() {

    override fun onCreate() {
        super.onCreate()
    }

    var context: Context = applicationContext;

    companion object {

        fun getComponent(): AppComponent {
            return DaggerAppComponent.create()
        }
    }
}