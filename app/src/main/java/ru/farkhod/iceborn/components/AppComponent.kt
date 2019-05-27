package ru.farkhod.iceborn.components

import dagger.Component
import ru.farkhod.iceborn.MainActivity
import ru.farkhod.iceborn.fragments.ContinentsFragment
import ru.farkhod.iceborn.presenters.ContinentsFragmentPresenter
import javax.inject.Singleton

@Component(modules = arrayOf(CommonModule::class))
@Singleton
interface AppComponent {
    fun injectMainactivity(activity: MainActivity)

    fun injectContinentsFragment(fragment: ContinentsFragment)

    fun injectContinentsFragmentPresenter(fragment: ContinentsFragmentPresenter)
}