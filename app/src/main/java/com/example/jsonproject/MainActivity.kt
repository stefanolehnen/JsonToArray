package com.example.jsonproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Toast
import com.example.jsonproject.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var userArrayLIst : ArrayList<UserModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userArrayLIst = arrayListOf(
            UserModel("stefano","yes"),
            UserModel("Luana","no"),
            UserModel("Laurinha","yes")

        )



        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonSaveUsers.setOnClickListener {

            turnJsonToArray()

        }
        binding.buttonShowUsers.setOnClickListener {
            turnArrayToJson(userArrayLIst)
        }

        //val json = "[{\"likesOranges\":\"yes\",\"name\":\"stefano\"},{\"likesOranges\":\"no\",\"name\":\"Luana\"},{\"likesOranges\":\"yes\",\"name\":\"Laurinha\"}]"

       // val typeToken = object: TypeToken<List>() {}.type
        //val userArrayList = Gson().fromJson<List>(json)

    }

    private fun turnArrayToJson(userArrayList: ArrayList<UserModel>): String{
        var gson = Gson()
        var jsonString = gson.toJson(userArrayLIst)



        Toast.makeText(this,jsonString, Toast.LENGTH_SHORT).show()
        println(jsonString)
        println("compare with array $userArrayLIst")

        return jsonString
    }

    private fun turnJsonToArray() {
        //just to test if the json is been converting by the function
        val json = """[{"name":"John","type":"Technical Author"},{"name":"Jane","type":"Technical Author"},{"name":"William","type":"Technical Editor"}]"""
        val typeToken = object : TypeToken<List<UserModel>>() {}.type
        val userArrayList = Gson().fromJson<List<UserModel>>(json, typeToken)

        println(userArrayList)
    }

}