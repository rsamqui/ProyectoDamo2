package com.rsamqui.bakingbills.API.DataClass

import com.google.gson.annotations.SerializedName

data class Presupuesto (
    @SerializedName("idIngrediente" ) var idBudget     : Int?    = null,
    @SerializedName("ingrediente"   ) var ingrediente  : String? = null,
    @SerializedName("unidades"      ) var unidades     : Double? = null,
    @SerializedName("medida"        ) var medida       : String? = null,
    @SerializedName("precio"        ) var precio       : Double? = null,
    @SerializedName("total"         ) var total        : Double? = null
)