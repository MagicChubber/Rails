import androidx.savedstate.SavedState
import androidx.savedstate.savedState
import com.aimicor.navtype.serializableType
import kotlinx.serialization.Serializable
import kotlin.test.Test
import kotlin.test.assertEquals

class NavTypeTest {
    private val savedState: SavedState = savedState()

    @Serializable
    data class Dummy(
        val intVal: Int,
        val stringVal: String,
        val floatVal: Float,
        val boolVal: Boolean,
        val doubleVal: Double,
        val charVal: Char,
        val longVal: Long,
        val shortVal: Short,
        val byteVal: Byte,
        val listStringVal: List<String>,
        val mapStringIntVal: Map<String, Int>,
    )

    private val dummy = Dummy(
        intVal = 1,
        stringVal = "string",
        floatVal = 2.0f,
        boolVal = true,
        doubleVal = 3.0,
        charVal = 'c',
        longVal = 4L,
        shortVal = 5,
        byteVal = 6,
        listStringVal = listOf("a", "b", "c"),
        mapStringIntVal = mapOf("a" to 1, "b" to 2, "c" to 3),
    )

    @Test
    fun `GIVEN complex data input WHEN encoded THEN decoded correctly`() {
        // Given
        val key = "dummy"
        val navType = serializableType<Dummy>()

        // When
        navType.put(savedState, key, dummy)
        val decoded = navType.get(savedState, key)

        // Then
        assertEquals(dummy, decoded)
    }
}
