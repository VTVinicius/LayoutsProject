package br.com.vtvinicius.feature_home.lobby

import android.content.Intent
import android.net.Uri

val intentHavan = Intent(Intent.ACTION_VIEW).apply {
    data = Uri.parse(
        "https://play.google.com/store/apps/details?id=com.artech.eaplic.havan"
    )
    setPackage("com.android.vending")
}
val intentRiHappy = Intent(Intent.ACTION_VIEW).apply {
    data = Uri.parse(
        "https://play.google.com/store/apps/details?id=br.com.rihappy.meusolzinho"
    )
    setPackage("com.android.vending")
}
val intentLeve = Intent(Intent.ACTION_VIEW).apply {
    data = Uri.parse(
        "https://play.google.com/store/apps/details?id=br.com.levesaude"
    )
    setPackage("com.android.vending")
}