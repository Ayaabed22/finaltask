
import com.google.gson.annotations.SerializedName

data class DataModel(
    @SerializedName("count")
    val count: Int? = null,
    @SerializedName("data")
    val `data`: List<Data?>? = null,
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("status")
    val status: Boolean? = null
)