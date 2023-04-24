package danapradana.belajarapp.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import danapradana.belajarapp.R
import danapradana.belajarapp.ToastGlobal
import danapradana.belajarapp.counter.view.MainActivity
import danapradana.belajarapp.login.LoginActivity
import danapradana.belajarapp.login.UserData

class RegisterActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var registerFormButton: Button
    private lateinit var presenter: RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        this.presenter = RegisterPresenter(this)
        initView()
    }

    private fun initView() {
        this.nameEditText = findViewById(R.id.nameRegisterEditText)
        this.emailEditText = findViewById(R.id.emailRegisterEditText)
        this.passwordEditText = findViewById(R.id.pswdRegisterEditText)
        this.registerFormButton = findViewById(R.id.registerFormButton)

        this.registerFormButton.setOnClickListener{
            this.validation()
        }
    }

    private fun validation(){
        val email = this.emailEditText.text
        val name = this.nameEditText.text
        val password = this.passwordEditText.text
        when{
            name.isEmpty() -> ToastGlobal(applicationContext, "Name Required").failed()
            email.isEmpty() -> ToastGlobal(applicationContext, "Email Required").failed()
            password.isEmpty() -> ToastGlobal(applicationContext, "Password Required").failed()
            else -> this.submitRegister(
                UserData(
                name = name.toString(),
                email = email.toString(),
                password = password.toString()
            )
            )
        }
    }

    private fun submitRegister(data: UserData){
        this.presenter.submitRegister(data)
    }

    fun onSuccess(message: String){
        val intent = Intent(applicationContext, LoginActivity::class.java)
        ToastGlobal(applicationContext, message).success()
        finishAffinity()
        startActivity(intent)
    }

    fun onFailed(message:String){
        val toast = ToastGlobal(applicationContext, message).failed()
    }
}