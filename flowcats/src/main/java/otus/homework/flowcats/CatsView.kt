package otus.homework.flowcats

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout

class CatsView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr), ICatsView {

    override fun render(state: Result) {
        when (state) {
            is Result.Error -> {
                Toast.makeText(context, state.message, Toast.LENGTH_LONG)
                    .show()
            }
            Result.Loading -> {
                findViewById<TextView>(R.id.fact_textView).visibility = INVISIBLE
            }
            is Result.Success<*> -> {
                val s = state as Result.Success<Fact>
                findViewById<TextView>(R.id.fact_textView).text = s.data.text
                findViewById<TextView>(R.id.fact_textView).visibility = VISIBLE
            }
        }

    }
}

interface ICatsView {

    fun render(state: Result)
}