package com.example.ddlite.data.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class Restaurant {

    @SerializedName("status")
    @Expose
    val status: String? = null

    @SerializedName("description")
    @Expose
     val description: String? = null

    @SerializedName("delivery_fee")
    @Expose
     var deliveryFee: Int? = null

    @SerializedName("cover_img_url")
    @Expose
     val coverImgUrl: String? = null

    @SerializedName("id")
    @Expose
     val id: Int? = null

    @SerializedName("name")
    @Expose
     val name: String? = null


    @Transient
    private var displayDeliveryFee: String? = null
    private var averageRating = 0.0
    private var numberOfRatings = 0

    @Transient
    private var displayRating: String? = null


    fun getDisplayDeliveryFee(): String? {
        if (displayDeliveryFee == null) {
            updateDisplayDeliveryFee()
        }
        return displayDeliveryFee
    }


    private fun updateDisplayDeliveryFee() {
        var display: String?
        if (deliveryFee!! <= 0) {
            display = PRICE_FREE
        } else {
            val dollars = deliveryFee!! / 100
            val cents = deliveryFee!! % 100
            display = "$CURRENCY_SYMBOL$dollars."
            if (cents < 10) {
                display += "0"
            }
            display += cents
        }
        displayDeliveryFee = display
    }

    private fun updateDisplayRating() {
        displayRating =
            "$averageRating / $RATING ($numberOfRatings ratings)"
    }

    companion object {
        private const val CURRENCY_SYMBOL = "$" //cents
        private const val PRICE_FREE = "FREE"
        private const val RATING = 5.0
    }
}