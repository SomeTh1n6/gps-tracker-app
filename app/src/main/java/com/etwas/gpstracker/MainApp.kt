package com.etwas.gpstracker

import android.app.Application
import com.etwas.gpstracker.db.MainDb

class MainApp : Application() {
    val database by lazy { MainDb.getDatabase(this) }
}