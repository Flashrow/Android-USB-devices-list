package com.example.iwskusb

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var btn_checkUsb : Button
    private lateinit var recyclerView : RecyclerView
    private lateinit var usbManager : UsbDevicesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usbManager = UsbDevicesManager(applicationContext)

        recyclerView = findViewById(R.id.recyclerView)
        
        btn_checkUsb = findViewById(R.id.btn_checkDevices)
        btn_checkUsb.setOnClickListener { findUsb()}
    }

    private fun findUsb(){
        recyclerView.adapter = DevicesAdapter(usbManager.getUsbDevices())
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
    }

}