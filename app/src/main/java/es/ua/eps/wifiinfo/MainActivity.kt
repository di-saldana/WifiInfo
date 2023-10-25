package es.ua.eps.wifiinfo

import android.content.Context
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wifiManager = getSystemService(Context.WIFI_SERVICE) as WifiManager
        val wifiInfo = wifiManager.connectionInfo
        val dhcpInfo = wifiManager.dhcpInfo

        if(wifiInfo.bssid != null) {
            val ssidText = findViewById<TextView>(R.id.ssid)
            val ssid = wifiInfo.ssid
            ssidText.text = "SSID: $ssid"

            val bssidText = findViewById<TextView>(R.id.bssid)
            val bssid = wifiInfo.bssid
            bssidText.text = "BSSID: $bssid"

            val frecuenciaText = findViewById<TextView>(R.id.frecuencia)
            val frecuencia = wifiInfo.frequency
            frecuenciaText.text = "Frecuencia: $frecuencia"

            val velocidadText = findViewById<TextView>(R.id.velocidad)
            val velocidad = wifiInfo.linkSpeed
            velocidadText.text = "Velocidad: $velocidad"

            val fuerzaSenalText = findViewById<TextView>(R.id.fuerzaSenal)
            val fuerzaSenal = wifiInfo.rssi
            fuerzaSenalText.text = "Fuerza de la señal: $fuerzaSenal"

            val redOcultaText = findViewById<TextView>(R.id.redOculta)
            val redOculta = wifiInfo.hiddenSSID
            redOcultaText.text = "Está oculta la red?: $redOculta"

            val ipText = findViewById<TextView>(R.id.ip)
            val ip = dhcpInfo.ipAddress
            ipText.text = "IP (privada): $ip"

            val puertaEnlaceText = findViewById<TextView>(R.id.puertaEnlace)
            val puertaEnlace = dhcpInfo.gateway
            puertaEnlaceText.text = "Puerta de enlace: $puertaEnlace"

            val mascaraText = findViewById<TextView>(R.id.mascara)
            // val mascara =
            // mascaraText.text = "Máscara: $mascara"
        }

    }
}