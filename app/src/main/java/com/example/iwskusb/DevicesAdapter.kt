package com.example.iwskusb

import android.hardware.usb.UsbDevice
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DevicesAdapter(private val dataSet: Array<UsbDevice>) :
        RecyclerView.Adapter<DevicesAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val deviceName: TextView
        val deviceVid: TextView
        val devicePid: TextView

        init {
            // Define click listener for the ViewHolder's View.
            deviceName = view.findViewById(R.id.deviceName)
            deviceVid = view.findViewById(R.id.deviceVID)
            devicePid = view.findViewById(R.id.devicePID)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DevicesAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.device_row_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: DevicesAdapter.ViewHolder, position: Int) {
        println("Adding to recycler view: " + dataSet[position].productName + ", position: " + position)
        holder.deviceName.text = dataSet[position].productName
        holder.devicePid.text = dataSet[position].productId.toString()
        holder.deviceVid.text = dataSet[position].vendorId.toString()
    }

    override fun getItemCount() = dataSet.size
}