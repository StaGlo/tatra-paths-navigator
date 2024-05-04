import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.touristpath.tools.DataStoreManager
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class TimerViewModel(
    private val dataStoreManager: DataStoreManager,
    private val pathTitle: String
) : ViewModel() {

    private val _elapsedTime = MutableStateFlow(0.0)
    val elapsedTime: StateFlow<Double> get() = _elapsedTime

    private var job: Job? = null

//    private val isTimerRunning: Boolean
//        get() = job?.isActive ?: false

    init {
        // Load saved elapsed time from the DataStore
        viewModelScope.launch {
            val savedTime = dataStoreManager.getStopperValue(pathTitle).firstOrNull() ?: 0.0
            _elapsedTime.value = savedTime
        }
    }

    fun startTimer() {
        if (job?.isActive == true) return
        job = viewModelScope.launch {
            while (isActive) {
                delay(10)
                _elapsedTime.value += 0.01
                Log.d("TimerViewModel", "Timer for ${pathTitle}: ${_elapsedTime.value}")
            }
        }
    }

    fun stopTimer() {
        job?.cancel()
        // Save the elapsed time to the DataStore
        viewModelScope.launch {
            dataStoreManager.setStopperValue(pathTitle, _elapsedTime.value)
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

    fun setElapsedTime(value: Double) {
        if (job?.isActive == true)
            return
        _elapsedTime.value = value
        viewModelScope.launch {
            dataStoreManager.setStopperValue(pathTitle, value)
        }

    }
}


class TimerViewModelFactory(
    private val dataStoreManager: DataStoreManager,
    private val pathTitle: String
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TimerViewModel(dataStoreManager, pathTitle) as T
    }
}

object TimerViewModelManager {
    private val viewModelMap = mutableMapOf<String, TimerViewModel>()

    fun getOrCreate(dataStoreManager: DataStoreManager, pathTitle: String): TimerViewModel {
        return viewModelMap[pathTitle] ?: TimerViewModel(dataStoreManager, pathTitle).also {
            viewModelMap[pathTitle] = it
        }
    }
}