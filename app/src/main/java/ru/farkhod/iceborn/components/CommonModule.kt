package ru.farkhod.iceborn.components

import dagger.Module
import dagger.Provides
import ru.farkhod.iceborn.MainActivity
import ru.farkhod.iceborn.fragments.ContinentsFragment
import ru.farkhod.iceborn.fragments.MainFragment
import ru.farkhod.iceborn.fragments.PagerAdapter
import ru.farkhod.iceborn.models.ContinentsModul
import ru.farkhod.iceborn.presenters.ContinentsFragmentPresenter
import ru.farkhod.iceborn.presenters.MainFragmentPresenter
import javax.inject.Singleton

@Module
class CommonModule {
    @Provides
    @Singleton
    fun providesMainActivity() = MainActivity()

    @Provides
    @Singleton
    fun providesContinentsFragment(): ContinentsFragment = ContinentsFragment()

    @Provides
    @Singleton
    fun providesContinentsFragmentPresenter(): ContinentsFragmentPresenter = ContinentsFragmentPresenter()

    @Provides
    @Singleton
    fun providesContinentsModul(): ContinentsModul = ContinentsModul()
}