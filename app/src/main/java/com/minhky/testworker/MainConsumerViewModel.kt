package com.minhky.testworker

import com.minhky.testworker.domain.usecase.ObserverFruittesUseCase
import com.minhky.testworker.viewmodel.MainViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainConsumerViewModel @Inject constructor(
    observerFruittesUseCase: ObserverFruittesUseCase
) : MainViewModel(observerFruittesUseCase) {



}