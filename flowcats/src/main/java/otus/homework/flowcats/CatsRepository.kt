package otus.homework.flowcats

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class CatsRepository(
    private val catsService: CatsService,
    private val refreshIntervalMs: Long = 5000
) {
    fun listenForCatFacts() = flow {
        while (true) {
            try {
                emit(Result.Loading)
                val latestNews = catsService.getCatFact()
                emit(
                    Result.Success(
                        Fact.EMPTY.copy(
                            text = "${latestNews.record?.text} ${System.currentTimeMillis()}"
                        )
                    )
                )
            } catch (e: Throwable) {
                emit(
                    Result.Error(message = e.message.orEmpty())
                )
            }
            delay(refreshIntervalMs)
        }
    }
}