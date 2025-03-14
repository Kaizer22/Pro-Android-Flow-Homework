package otus.homework.flowcats

import com.google.gson.annotations.SerializedName
import retrofit2.http.GET

data class JsonBinRecord<T>(
    @field:SerializedName("record")
    val record: T?,
    @field:SerializedName("metadata")
    val metadata: JsonBinMetadata?,
)

data class JsonBinMetadata(
    @field:SerializedName("id")
    val id: String?,
    @field:SerializedName("private")
    val private: Boolean?,
    @field:SerializedName("createdAt")
    val createdAt: String?,
    @field:SerializedName("name")
    val name: String?,
)

interface CatsService {

    @GET("b/67d041be8a456b796673cb7c")
    suspend fun getCatFact(): JsonBinRecord<Fact>
}