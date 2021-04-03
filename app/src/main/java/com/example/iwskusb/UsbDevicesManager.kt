package com.example.iwskusb


import android.content.Context
import android.hardware.usb.UsbDevice
import android.hardware.usb.UsbManager
import androidx.recyclerview.widget.RecyclerView
import java.util.HashMap

class UsbDevicesManager (private val context: Context){
    private var devicesList : ArrayList<UsbDevice> = ArrayList()

    public fun getUsbDevices(): Array<UsbDevice> {
        devicesList.clear()
        val usbManager = context.getSystemService(Context.USB_SERVICE) as UsbManager
        val usbDevices: HashMap<String, UsbDevice>? = usbManager.deviceList

        usbDevices?.forEach{ (key, value) ->
            handleUsbDevice(key, value)
        }

        return devicesList.toTypedArray()
    }

    private fun handleUsbDevice(key: String, value: UsbDevice){
        devicesList.add(value)
        println("Key: " + key + ", product name: " + value.productName
                + ", device pid: " + value.productId
                + ", device vid: " + value.vendorId
                + ", device id: " + value.deviceId
                )
    }
}