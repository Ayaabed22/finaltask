
import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("price")
    val price: Int? = null,
    @SerializedName("quantity")
    val quantity: Int? = null,
    @SerializedName("restaurant_id")
    val restaurantId: Int? = null
)