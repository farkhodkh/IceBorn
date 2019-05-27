package ru.farkhod.iceborn.repositories

import android.databinding.BaseObservable

class Repository(var name: String?, var is_used: Boolean?, var iso_code: String?) :
    BaseObservable()