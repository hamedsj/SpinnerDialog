package com.github.hamzaahmedkhan

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.github.hamzaahmedkhan.spinnerdialog.callbacks.OnSpinnerOKPressedListener
import com.github.hamzaahmedkhan.spinnerdialog.ui.single.SpinnerDialogFragment
import com.github.hamzaahmedkhan.spinnerdialog.models.SpinnerModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val arraySpinnerModel: ArrayList<SpinnerModel> = ArrayList()

        for (i in 1..9) {
            arraySpinnerModel.add(
                SpinnerModel(
                    "Number $i"
                )
            )
        }


        // Init single select Fragment
        val spinnerSingleSelectDialogFragment =
            SpinnerDialogFragment.newInstance(
                SpinnerDialogFragment.SINGLE_SELECT_MODE,"Spinner Dialog", arraySpinnerModel,
                object :
                    OnSpinnerOKPressedListener {
                    override fun onItemSelect(data: SpinnerModel, selectedPosition: Int) {
                        Toast.makeText(applicationContext, data.text, Toast.LENGTH_LONG).show()
                    }

                }, 0
            )


        // Init multi select Fragment
        val spinnerMultiSelectDialogFragment =
            SpinnerDialogFragment.newInstance(
                SpinnerDialogFragment.MULTI_SELECT_MODE,"Spinner Dialog", arraySpinnerModel,
                object :
                    OnSpinnerOKPressedListener {
                    override fun onItemSelect(data: SpinnerModel, selectedPosition: Int) {
                        Toast.makeText(applicationContext, data.text, Toast.LENGTH_LONG).show()
                    }

                }, 0
            )



        // Using optional features for single select dialog
        spinnerSingleSelectDialogFragment.buttonText = "SAVE"
        spinnerSingleSelectDialogFragment.themeColorResId = resources.getColor(R.color.material_pink500)
        spinnerSingleSelectDialogFragment.showSearchBar = true
        spinnerSingleSelectDialogFragment.searchbarHint = "type here to search.."


        // Using optional features for multi select dialog
        spinnerMultiSelectDialogFragment.buttonText = "SAVE"
        spinnerMultiSelectDialogFragment.themeColorResId = resources.getColor(R.color.material_pink500)
        spinnerMultiSelectDialogFragment.showSearchBar = true
        spinnerMultiSelectDialogFragment.searchbarHint = "type here to search.."


        txtShowSingleChoiceSpinner.setOnClickListener { spinnerSingleSelectDialogFragment.show(supportFragmentManager, "SpinnerDialogFragment") }
        txtShowMultiChoiceSpinner.setOnClickListener { spinnerMultiSelectDialogFragment.show(supportFragmentManager, "SpinnerDialogFragment") }
    }
}
