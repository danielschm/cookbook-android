package com.example.cookbook.ui.meal

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cookbook.data.MealRepository
import com.example.cookbook.data.OperationCallback
import com.example.cookbook.model.Meal

class MealViewModel(private val repository: MealRepository) : ViewModel() {

    private val _meals = MutableLiveData<ArrayList<Meal>>().apply { value = arrayListOf() }
    val meals: LiveData<ArrayList<Meal>> = _meals

    private val _isViewLoading=MutableLiveData<Boolean>()
    val isViewLoading:LiveData<Boolean> = _isViewLoading

    private val _isEmptyList=MutableLiveData<Boolean>()
    val isEmptyList:LiveData<Boolean> = _isEmptyList

    private val _onMessageError=MutableLiveData<Any>()
    val onMessageError:LiveData<Any> = _onMessageError

    fun loadMeals() {
        repository.retrieveMeals(object : OperationCallback<ArrayList<Meal>> {
            override fun onError(error: String?) {
                _isViewLoading.postValue(false)
                _onMessageError.postValue( error)
            }

            override fun onSuccess(data: ArrayList<Meal>?) {
                _isViewLoading.postValue(false)

                if (data != null) {
                    if (data.isEmpty()) {
                        _isEmptyList.postValue(true)
                    } else {
                        _meals.value = data
                    }
                }
            }
        })
    }
}

