package es.ua.eps.wifiinfo

import android.content.Context
import android.net.wifi.WifiManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


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
            frecuenciaText.text = "Frecuencia: $frecuencia MHz"

            val velocidadText = findViewById<TextView>(R.id.velocidad)
            val velocidad = wifiInfo.linkSpeed
            velocidadText.text = "Velocidad: $velocidad Mbps"

            val fuerzaSenalText = findViewById<TextView>(R.id.fuerzaSenal)
            val fuerzaSenal = wifiInfo.rssi
            fuerzaSenalText.text = "Fuerza de la señal: $fuerzaSenal dBM"

            val redOcultaText = findViewById<TextView>(R.id.redOculta)
            val redOculta = wifiInfo.hiddenSSID
            redOcultaText.text = "Está oculta la red?: $redOculta"

            val ipText = findViewById<TextView>(R.id.ip)
            val ip = dhcpInfo.ipAddress
            val ipString: String = String.format(
                "%d.%d.%d.%d",
                ip and 0xff,
                ip shr 8 and 0xff,
                ip shr 16 and 0xff,
                ip shr 24 and 0xff
            )
            ipText.text = "IP (privada): $ipString"

            val puertaEnlaceText = findViewById<TextView>(R.id.puertaEnlace)
            val pE = dhcpInfo.gateway
            val gatewayString: String = String.format(
                "%d.%d.%d.%d",
                pE and 0xff,
                pE shr 8 and 0xff,
                pE shr 16 and 0xff,
                pE shr 24 and 0xff
            )
            puertaEnlaceText.text = "Puerta de enlace: $gatewayString"

            val mascaraText = findViewById<TextView>(R.id.mascara)
            val mascara = dhcpInfo.netmask
            mascaraText.text = "Máscara: $mascara"
        }

        // https://stackoverflow.com/questions/21391395/get-ssid-when-wifi-is-connected
        // https://developer.android.com/reference/android/net/DhcpInfo#netmask
        // https://developer.android.com/reference/android/net/wifi/WifiManager.html
        // https://developer.android.com/reference/android/net/wifi/WifiInfo.html

    }
}