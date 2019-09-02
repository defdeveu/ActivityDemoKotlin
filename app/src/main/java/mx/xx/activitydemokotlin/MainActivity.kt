package mx.xx.activitydemokotlin

import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle

import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    internal lateinit var builder: AlertDialog.Builder
    private var loginButton: Button? = null
    private var usernameField: EditText? = null
    private var passwordField: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val context = this
        setContentView(R.layout.activity_main)
        loginButton = findViewById(R.id.button) as Button
        usernameField = findViewById(R.id.editText4) as EditText
        passwordField = findViewById(R.id.editText5) as EditText

        builder = AlertDialog.Builder(context, android.R.style.Theme_Material_Dialog_Alert)

        loginButton!!.setOnClickListener {
            if (usernameField!!.text.toString() == "demo" && passwordField!!.text.toString() == "demo") {
                val intent = Intent(context, Secret::class.java)
                startActivity(intent)
            } else {
                builder.setTitle("Error")
                    .setMessage("Incorrect credentials entered")
                    .setPositiveButton(android.R.string.yes,
                        DialogInterface.OnClickListener { dialog, which ->
                            usernameField!!.setText("")
                            passwordField!!.setText("")
                        })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show()

            }
        }
    }
}
