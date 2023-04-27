package com.example.codinginflowimagesearchapp.viewModel

import androidx.lifecycle.*
import androidx.paging.cachedIn
import com.example.codinginflowimagesearchapp.data.repository.UnsplashRepository
import dagger.assisted.Assisted
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(private val repository: UnsplashRepository, state: SavedStateHandle) : ViewModel() {

    val currentQuery = state.getLiveData(CURRENT_QUERY, DEFAULT_QUERY)
    val photos = currentQuery.switchMap {
        repository.getSearchResults(currentQuery.value ?: DEFAULT_QUERY).cachedIn(viewModelScope)
    }

    fun searchPhotos(query: String) {
        currentQuery.value = query
    }

    companion object {
        private const val DEFAULT_QUERY = "cats"
        private const val CURRENT_QUERY = "current_query"
    }
}